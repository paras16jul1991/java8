package com.java8.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Movie implements Comparable<Movie> {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	String type;
	int rating;

	Movie(String name, String type, int rating) {
		this.name = name;
		this.type = type;
		this.rating = rating;
	}

	@Override
	public int compareTo(Movie m) {
		return this.name.compareTo(m.name);
	}

	@Override
	public String toString() {
		return this.name + " " + this.rating + " " + this.type;
	}
}

public class TestComparatorChainingUsingStream {

	public static void main(String[] args) {

		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("AA", "Romantic", 1));
		movies.add(new Movie("AA", "Action", 5));
		movies.add(new Movie("B", "Comady", 9));
		movies.add(new Movie("K", "Romantic", 11));
		movies.add(new Movie("AA", "Comady", 8));
		movies.add(new Movie("Ax", "Action", 10));
		movies.add(new Movie("XX", "Comady", 4));
		movies.add(new Movie("YX", "Romantic", 6));
		movies.stream().forEach(x -> System.out.println(x));

		System.out.println("----------After sorting-------");

		Stream<Movie> sorted = movies.stream().sorted(
				Comparator.comparing(Movie::getName).thenComparing(Movie::getType).thenComparing(Movie::getRating));

		sorted.forEach(x -> System.out.println(x));

		System.out.println("----------Reverse sorting-------");

		movies.stream().sorted(Collections.reverseOrder(Comparator.comparing(Movie::getName)))
				.forEach(System.out::println);
		

	}
}
