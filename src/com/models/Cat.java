package com.models;

public class Cat extends Pet  implements Comparable<Cat>{
    private String color;

    // Constructor
    public Cat(String petName, int petAge, String petColor) {
        super(petName, petAge);
        this.color = petColor;
    }

    public Cat( String petColor) {
    	 super("", 1);
        this.color = petColor;
    }
    // Getters
    public String getColor() { return(this.color); }

    // Setters
    public void setColor(String colorSet) { this.color = colorSet; }

    // Other Methods
    @Override
    public String speak() { return "Meow!"; } 

    // toString
    @Override
    public String toString() {
        String answer = "Name: " + super.getName() + " Age: "+super.getAge()
                + " Color: " + this.color;
        return answer;
    }

	@Override
	public int compareTo(Cat o) {
		 return color.compareTo(o.color);
	}

	
}
