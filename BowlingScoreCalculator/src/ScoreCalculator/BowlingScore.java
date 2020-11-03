package ScoreCalculator;

public class BowlingScore {
	private String[] scoreArray = new String[10];
	private int score;
	
	public BowlingScore(String s) {
		score = 0;
		int sCounter = 0;
		for(int i = 0; i < 10; i++) {
			scoreArray[i] = "";
			while((sCounter < s.length())&&!(s.charAt(sCounter) == '-')) {
				scoreArray[i] += s.charAt(sCounter);
				sCounter++;
			}
			sCounter++;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void printScoreArray() {
		System.out.print("[");
		for(int i = 0; i < 10; i++) {
			System.out.print(scoreArray[i]);
			if(i != 9) {
				System.out.print(" ");
			}
		}
		System.out.print("]\n");
	}
	
	public int calculateFrame(int i){
		int frameScore= 0;
		int sCounter = 0;
		switch(scoreArray[i]) {
			case "X":
				return 10+calculateThrows(i+1, 2);
			default:
				for(int j = 0; j< 2; j++) {
					if((j == 0)&& scoreArray[i].charAt(j+1) == '/') {
						frameScore += 10 + calculateThrows((i+1), 1);
						break;
					}
					frameScore += Integer.parseInt(scoreArray[i].substring(j,j+1));
				}
				
		}
		return frameScore;
	}
	
	public int calculateThrows(int i, int n) {
		int frameScore= 0;
		if(n == 0) {
			return 0;
		}
		switch(scoreArray[i]) {
			case "X":
				return 10+calculateThrows((i+1),(n-1));
			default:
				for(int j = 0; j < n; j++) {
					if((j == 0)&& scoreArray[i].charAt(j+1) == '/') {
						frameScore += 10;
						break;
					}else if(scoreArray[i].charAt(j )== 'X' ) {
						frameScore += 10;
					}else {
						frameScore += Integer.parseInt(scoreArray[i].substring(j,j+1));	
					}		
				}
		}
		return frameScore;
	}
	
	public int calculateFinalFrame(int i, int bowlThrow, int digit) {
		int frameScore = 0;
		for(int j = digit; j < digit+bowlThrow; j++) {
			if(scoreArray[i].charAt(j) == 'X') {
				if(j == 0) {
					frameScore += 10 + calculateFinalFrame(i, 2, j+1);
					break;
				}else {
					frameScore += 10;
				}
			}
			else if((j == 0)&& scoreArray[i].charAt(j+1) == '/') {
				frameScore += 10+calculateFinalFrame(i, 1, j+2);
				break;
			}
			else{
				frameScore += Integer.parseInt(scoreArray[i].substring(j,j+1));			
			}
		}
		return frameScore;
	}
	
	public int fullScore(){
		int fScore = 0;
		int arrayIndex;
		for(arrayIndex = 0; arrayIndex < 9; arrayIndex++) {
			fScore += this.calculateFrame(arrayIndex);
		}
		fScore += this.calculateFinalFrame(9, 2, 0);
		return fScore;
	}
}
