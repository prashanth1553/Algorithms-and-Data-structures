package com.designpatterns.observer;

public class RepublicNewsChannel implements Channel {

	@Override
	public void update(String news) {
		System.out.println("RepublicNewsChannel receive news : " + news);

	}

}
