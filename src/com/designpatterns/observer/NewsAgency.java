package com.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

	private List<Channel> channels = new ArrayList<>();

	public void addChannel(Channel channel) {
		channels.add(channel);
	}

	public void newsReceived(String news) {
		for (Channel channel : channels) {
			channel.update(news);
		}

	}
}
