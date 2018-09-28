package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Movie implements Comparable<Movie> {
	String name;
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

public class TestComparable {

	public static void main(String[] args) {

		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("A", "Romantic", 5));
		movies.add(new Movie("Z", "Action", 1));
		movies.add(new Movie("B", "Comady", 9));
		movies.add(new Movie("K", "Romantic", 11));

		movies.stream().forEach(x -> System.out.println(x.name));
		Collections.sort(movies);
		System.out.println("-------------");
		movies.stream().forEach(x -> System.out.println(x.name));
	}

}
