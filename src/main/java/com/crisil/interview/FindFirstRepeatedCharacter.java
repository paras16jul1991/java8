package com.crisil.interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFirstRepeatedCharacter {

	public static void main(String[] args) {
		String var = "ababcdde";
		
		Stream<Character> characterStream = var.chars().mapToObj(c -> (char) c);
		int[] iarr = {1}; 
		List<Character> result = characterStream.filter( (x) -> { 
			String s =var.substring(iarr[0]);
			++iarr[0];
			return !s.contains(x+"");
		}).collect(Collectors.toList());
		//forEach(System.out::println);;
		System.out.println(result.toString());
		}
	}

