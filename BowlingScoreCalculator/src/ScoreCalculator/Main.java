package ScoreCalculator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BowlingScore b = new BowlingScore("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/5");
		b.printScoreArray();
		System.out.println(b.fullScore());
	}

}
