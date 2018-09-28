package com.observer.pattren;

public class AverageScore implements Observer {

	private float runRate;
	private int predictedScore;

	@Override
	public void updateScore(int run, int over, int wicket) {
		this.runRate = (float) run / over;
		this.predictedScore = (int) this.runRate * 50;
		this.display();
	}

	@Override
	public void display() {
		System.out.println("RunRate " + runRate + " PredicatedScore " + predictedScore);
	}
}
