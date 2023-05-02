package edu.guilford;

import java.util.Random;

public class Animal {

    // instance variables
    private String name;
    private int age;
    private String species;

    // constructor
    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    // method that instinates a list and adds random species list
    public Animal() {
        String[] speciesList = { "Dog", "Cat", "Tortoise", "Bird", "Fish", "Snake", "Lizard", "Frog", "Hamster",
                "Guinea Pig" };
        Random rand = new Random();
        int randomIndex = rand.nextInt(speciesList.length);// random index from speciesList array
        this.species = speciesList[randomIndex];
        if (this.species.equals("Tortoise")) {
            this.age = rand.nextInt(200) + 1;
        } else if (this.species.equals("Bird")) {
            this.age = rand.nextInt(100) + 1;
        } else if (this.species.equals("Fish")) {
            this.age = rand.nextInt(50) + 1;
        } // for all objects that are not tortoise, bird, or fish
        else {
            this.age = rand.nextInt(20) + 1;
        }
        // add animal name list
        String[] nameList = { "Buddy", "Max", "Bella", "Lucy", "Charlie", "Daisy", "Molly", "Lola", "Sadie", "Maggie",
                "tim ", "joe", "bob", "jim", "joe", "jim", "joe", "jim", "joe", "jim" };
        Random rand2 = new Random();
        int randomIndex2 = rand2.nextInt(nameList.length);// random index from nameList array
        this.name = nameList[randomIndex2];

    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // to method
    @Override
    public String toString() {
        return "\nname:" + this.name + " Age:" + this.age + " Species:" + this.species;
    }
    

}
