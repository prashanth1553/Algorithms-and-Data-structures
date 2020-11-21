package com.designpatterns.strategy;

public class Evaluator {

	private Evaluate evaluate;

	public Evaluator(Evaluate evaluate) {
		this.evaluate = evaluate;
	}

	public int execute(int a, int b) {
		return evaluate.execute(a, b);
	}
}
