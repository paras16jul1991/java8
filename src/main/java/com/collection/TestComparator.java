package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class RatingCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.rating - o2.rating;
	}
}

class TypeCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.type.compareTo(o2.type);
	}
}

class NameCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.name.compareTo(o2.name);
	}
}

public class TestComparator {

	public static void main(String[] args) {

		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("A", "Romantic", 5));
		movies.add(new Movie("Z", "Action", 1));
		movies.add(new Movie("B", "Comady", 9));
		movies.add(new Movie("K", "Romantic", 11));

		System.out.println("----Sort By rating---------");
		movies.sort(new RatingCompare());
		movies.stream().forEach(x -> System.out.println(x.name));

		System.out.println("----Sort By Type---------");
		movies.sort(new TypeCompare());
		movies.stream().forEach(x -> System.out.println(x.name));

		System.out.println("----Sort By Name---------");
		movies.sort(new NameCompare());
		movies.stream().forEach(x -> System.out.println(x.name));

	}
}