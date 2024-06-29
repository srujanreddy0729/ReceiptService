package Streams.TerminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TermOperations2 {
    public static void main(String args[]){
        List<Integer> list= Arrays.asList(1,4,8,2,10,4);

        //min function is used to pick the min value in list
        Optional<Integer> minEle = list.stream().min(Comparator.naturalOrder());
        System.out.println(minEle.get());

        //max function is used to pick the max value in list
        Optional<Integer> maxEle = list.stream().max(Comparator.naturalOrder());
        System.out.println(maxEle.get());

        //findFirst function will return the first element of a list
        Optional<Integer> first = list.stream().
                filter(n -> n % 2 == 0).findFirst();
        System.out.println(first.get());

        //anyMatch function will check the list that matches the condition return boolean value
        System.out.println(list.stream().anyMatch(n->n%2==0));

        //count function will count the number of elements in the list
        System.out.println(list.stream().count());

        //sum function will sum the element sin the list
        int sum=list.stream().
                mapToInt(n->n.intValue())
                .sum();
        System.out.println(sum);

        //parallel streams will perform the operations in parallel threads.
        //It is used for complex operations and it takes time less when compared to sequential streams
        //but not to use  to simple operations
    }
}
