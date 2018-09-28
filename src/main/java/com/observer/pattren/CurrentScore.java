package com.observer.pattren;

public class CurrentScore implements Observer {

	int run, over, wicket;

	@Override
	public void updateScore(int run, int over, int wicket) {
		this.run = run;
		this.over = over;
		this.wicket = wicket;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current Score : run" + run + " over " + over + " wicket " + wicket);
	}

}
