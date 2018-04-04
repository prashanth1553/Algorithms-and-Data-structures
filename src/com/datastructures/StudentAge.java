package com.datastructures;

public class StudentAge implements Comparable<StudentAge> {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Float) id).hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAge other = (StudentAge) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
