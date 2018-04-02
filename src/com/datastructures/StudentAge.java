package com.datastructures;


public class StudentAge implements Comparable<StudentAge>{

	
	private float id;

	public StudentAge(float id) {
		this.id = id;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	@Override
	public int compareTo(StudentAge other) {
		return Float.compare(id, other.getId());
	}

	
	
	
	
}
