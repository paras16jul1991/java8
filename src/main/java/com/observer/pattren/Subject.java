package com.observer.pattren;

public interface Subject {

	void registerObserver(Observer o);

	void deRegisterObserver(Observer o);

	void notifyObserver();
}
