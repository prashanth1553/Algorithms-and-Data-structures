package com.designpatterns.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Singleton instance1 = new Singleton();
	private static Singleton lazy;

	private Singleton() {
		if (lazy != null) {
			throw new InstantiationError("Creating of this object is not allowed.");
		}

	}

	public Singleton getInstance() {
		return instance1;
	}

	public Singleton getLazyInstance() {
		if (lazy == null) {
			synchronized (Singleton.class) {
				if (lazy == null) { // double checking
					lazy = new Singleton();
				}

			}
		}
		return lazy;
	}

	protected Object readResolve() {
		return getInstance();
	}
}
