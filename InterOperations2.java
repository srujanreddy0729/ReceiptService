package Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InterOperations2 {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 3, 4, 3, 2, 4, 9);
        List<String> list1 = Arrays.asList("rohit", "virat", "pant", "sky","bumrah");

        //distinct will print the unique elements
        list.stream()
                .distinct()
                .forEach(System.out::println);

        //sorted will sort the elements in ascending order
        System.out.println("------sorted function---------");
        list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //printing elements based on the length of a string
        list1.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        //skip function will skip number of elements based in the input
        System.out.println("--------skip function---------");
        list1.stream()
                .skip(2)
                .forEach(System.out::println);

        //limit function will print the elements based on input and block the remaining elements
        System.out.println("-------limit function------------");
        list1.stream()
                .limit(3)
                .forEach(System.out::println);


    }
}
