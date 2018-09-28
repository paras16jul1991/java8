package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MovieComparatorChain implements Comparator<Movie> {
	List<Comparator<Movie>> list;

	public MovieComparatorChain(Comparator<Movie>... comparators) {
		list = Arrays.asList(comparators);
	}

	@Override
	public int compare(Movie o1, Movie o2) {
		for (Comparator<Movie> c : list) {
			int result = c.compare(o1, o2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

}

public class TestComparatorChaining {

	public static void main(String[] args) {

		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("AA", "Romantic", 5));
		movies.add(new Movie("AA", "Action", 1));
		movies.add(new Movie("B", "Comady", 9));
		movies.add(new Movie("K", "Romantic", 11));
		movies.add(new Movie("AA", "Comady", 8));
		movies.add(new Movie("Ax", "Action", 10));
		movies.add(new Movie("XX", "Comady", 4));
		movies.add(new Movie("YX", "Romantic", 6));
		movies.stream().forEach(x -> System.out.println(x));
		movies.sort(new MovieComparatorChain(new NameCompare(), new TypeCompare(), new RatingCompare()));
		System.out.println("----------------------");

		movies.stream().forEach(x -> System.out.println(x));

	}

}
