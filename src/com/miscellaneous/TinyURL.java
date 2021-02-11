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
		return base62.reverse().toString();

	}

}
