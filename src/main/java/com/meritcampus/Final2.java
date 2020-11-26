package com.meritcampus;

public class Final2 {
	int lanif = 37;
	int nafi = 21;

	public static void main(String[] args) {
		final Final2 f = new Final2();
		f.process2();
		Final2 f2 = modify(f);
		f2.process2();
	}

	public static final Final2 modify(final Final2 f) {
		f.process();

		Final2 f2 = new Final2();
		f2.process();
		return f2;
	}

	final void process() {
		lanif = nafi + nafi;
		System.out.print(lanif + " " + nafi + " ");
	}

	void process2() {
		nafi = lanif / 2;
		System.out.print(nafi + " " + lanif + " ");
	}
}