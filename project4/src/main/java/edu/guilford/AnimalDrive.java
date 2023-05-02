package edu.guilford;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AnimalDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // get user input for number of animals
        System.out.println("How many animals would you like to create?");
        int numAnimals = scanner.nextInt();

        // create an array of animals
        Animal[] animals = new Animal[numAnimals];

        // create animals and add to array
        for (int i = 0; i < numAnimals; i++) {
            animals[i] = new Animal();
        }
        // print out animals unsorted
        System.out.println("Animals unsorted:");
        System.out.println(Arrays.toString(animals));

        // sort animals by age using insertion sort O(n2)
        long startTime = System.nanoTime();
        for (int i = 1; i < animals.length; i++) {
            Animal current = animals[i];
            int j = i - 1;
            while (j >= 0 && animals[j].getAge() > current.getAge()) {
                animals[j + 1] = animals[j];
                j--;
            }
            animals[j + 1] = current;
        }
        long endTime = System.nanoTime();
        double insertationTime = (endTime - startTime) / 1000000.0;

        System.out.println("\nSorted animals (by age):");
        System.out.println(Arrays.toString(animals));
        System.out.println("Insertion sort time: " + insertationTime + " milliseconds");

        // shuffle animals
        // Collections.shuffle(Arrays.asList(animals));

        // sort animals by name using selection sort O(n2)
        startTime = System.nanoTime();
        for (int i = 0; i < animals.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[j].getName().compareTo(animals[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }
            Animal temp = animals[minIndex];
            animals[minIndex] = animals[i];
            animals[i] = temp;
        }
        long endTime2 = System.nanoTime();
        double selectionTime = (endTime2 - startTime) / 1000000.0;

        System.out.println("\nSorted animals (by name):");
        System.out.println(Arrays.toString(animals));
        System.out.println("Insertion time: " + selectionTime + " milliseconds");

        // Age binary search O(log n2)
        System.out.println("Enter an age to search for:");
        int searchAge = scanner.nextInt();
        int index = binarySearch(animals, searchAge);

        startTime = System.nanoTime();
        if (index >= 0) {
            System.out.println("Found animal at index " + index + ": " + animals[index]);
        } else {
            System.out.println("Animal not found");
        }
        long endTime4 = System.nanoTime();
        double binaryTime = (endTime4 - startTime) / 1000000.0;
        System.out.println("Binary search time: " + binaryTime + " milliseconds");
        
        //print all times 
        System.out.println("\nTimes:");
        System.out.println("Insertion sort time: " + insertationTime + " milliseconds");
        System.out.println("Selection sort time: " + selectionTime + " milliseconds");
        System.out.println("Binary search time: " + binaryTime + " milliseconds");

    }

    public static int binarySearch(Animal[] animals, int searchAge) {
        int low = 0;
        int high = animals.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (animals[mid].getAge() == searchAge) {
                return mid;
            } else if (animals[mid].getAge() < searchAge) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
