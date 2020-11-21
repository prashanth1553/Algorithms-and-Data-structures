package com.designpatterns.observer;

public class NewsChannelExample {

	public static void main(String args[]) {
		NewsAgency agency = new NewsAgency();
		agency.addChannel(new EtvChannel());
		agency.addChannel(new RepublicNewsChannel());
		agency.newsReceived("Test news");
	}
}
