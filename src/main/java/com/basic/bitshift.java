package com.basic;

public class bitshift {

	public static void main(String[] args) {

		System.out.println(16 & 1);
		System.out.println(16 >> 1);
		int v = 15;
		int count = 0;
		while (v > 0) {
			if ((v & 1) == 1)
				count++;
			v = v >> 1;
		}
		System.out.print(count);

	}
}
