package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {
	private int counter = 1;
	private static Map<String, Integer> base10To62 = new HashMap<>();
	private static Map<Integer, String> base62To10 = new HashMap<>();
	private Map<String, String> shortToLong = new HashMap<>();

	static {
		for (int i = 0; i < 26; i++) {
			base10To62.put("" + new Character(((char) (65 + i))), i);
			base10To62.put("" + new Character(((char) (97 + i))), 26 + i);
			base62To10.put(i, "" + new Character(((char) (65 + i))));
			base62To10.put(26 + i, "" + new Character(((char) (97 + i))));
		}
		for (int i = 0; i < 10; i++) {
			base10To62.put("" + i, 52 + i);
			base62To10.put(52 + i, "" + i);
		}

	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String shortUrl = toBase62(++counter);
		shortToLong.put(shortUrl, longUrl);
		return shortUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLong.get(shortUrl);
	}

	private String toBase62(int input) {
		StringBuilder base62 = new StringBuilder();
		while (input != 0) {
			int r = input % 62;
			base62.append(base62To10.get(r));
			input = input / 62;
		}
		String r = base62.reverse().toString();
		for (int i = r.length(); i < 6; i++) {
			base62.append(base62To10.get(0));
		}
		return base62.reverse().toString();

	}

	private int toDecimal(String base62) {
		int sum = 0;
		int base = 1;
		for (int i = base62.length() - 1; i >= 0; i--) {
			sum += (base * base10To62.get("" + base62.charAt(i)));
			base *= 62;
		}

		return sum;
	}

	public static void main(String args[]) {
		TinyURL obj = new TinyURL();
		int s = 63;
		String base62 = obj.toBase62(s);
		System.out.println("base62 == " + base62);
		System.out.println("Decimal == " + obj.toDecimal(base62));
	}
}
