package com.observer.pattren;

import java.util.ArrayList;
import java.util.List;

public class CricketData implements Subject {
	int run;
	int wicket;

	public CricketData(int run, int wicket, int over) {
		this.run = run;
		this.wicket = wicket;
		this.over = over;
	}

	int over;

	public int getRun() {
		return run;
	}

	public int getWicket() {
		return wicket;
	}

	public int getOver() {
		return over;
	}

	private List<Observer> list = new ArrayList<>();

	@Override
	public void registerObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void deRegisterObserver(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObserver() {
		list.stream().forEach(x -> {
			x.updateScore(getRun(), getOver(), getWicket());
		});
	}

	void dataChange(int run, int over, int wicket) {
		this.run = run;
		this.over = over;
		this.wicket = wicket;
		notifyObserver();
	}

	public static void main(String[] args) {
		CricketData data = new CricketData(10, 5, 1);
		data.registerObserver(new CurrentScore());
		data.registerObserver(new AverageScore());
		data.dataChange(12, 6, 1);
		data.dataChange(19, 7, 2);
	}
}
