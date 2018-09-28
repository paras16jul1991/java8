package com.vandingmachine;

import java.util.Map;

class Item {
	int code;
	String name;
	double price;

	Item(int code, String name) {
		this.code = code;
		this.name = name;
	}
}

enum Coin {

}

public interface VandingMachine {

	double getItemPrice() throws Exception;

	void insertCoin(Coin coin);

	void reset();
}

class Inventory<T> {
	Map<T, Integer> map;

	T getUnit() {
		return null;
	}

	boolean hasUnit() {
		return false;
	}

	void addUnit(T t) {
		map.put(t, map.get(t) != null ? 0 : map.get(t) + 1);
	}
}

class VandingMachineImpl implements VandingMachine {

	Inventory<Coin> coinInventory;
	Inventory<Item> itemInventory;

	VandingMachineImpl() {
		init();
	}

	void init() {
		coinInventory = new Inventory<Coin>();
		itemInventory = new Inventory<Item>();
	}

	@Override
	public double getItemPrice() throws Exception {
		if (itemInventory.hasUnit())
			return itemInventory.getUnit().price;

		throw new Exception("Not available");
	}

	@Override
	public void reset() {
	}

	@Override
	public void insertCoin(Coin coin) {
		coinInventory.addUnit(coin);
	}

}
