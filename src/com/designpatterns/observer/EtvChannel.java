package com.designpatterns.observer;

public class EtvChannel implements Channel {

	@Override
	public void update(String news) {
		System.out.println("Etv receive news : " + news);

	}

}
