package com.designpatterns.template;

public class TemplatePatternDemo {

	public static void main(String[] args) {

		Game game = new Chess();
		game.play();
		System.out.println("**********");
		game = new Soccer();
		game.play();
	}
}
