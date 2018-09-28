package com.observer.pattren;

public interface Observer {

	void updateScore(int run, int over, int wicket);

	void display();
}
