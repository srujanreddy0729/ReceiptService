package Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterOperations1 {
    public static void main(String args[]) {
        List<Integer> list= Arrays.asList(1,3,4,6,2,8,9);
        List<String> list1=Arrays.asList("rohit","Virat","pant","sky");
        List<List<String>> list2=Arrays.asList(
                Arrays.asList("rohit","bumrah"),
                Arrays.asList("virat","siraj"),
                Arrays.asList("abhishek","bhuvi"));

        //filter takes lambda expression as parameter and it filters the list values based on the expression
        list.stream().
                filter(n->n%2==0).
                forEach(System.out::println);

        //map will transform one data to another data and it will takes function as output
        list1.stream().
                map(name->name.toUpperCase()).
                forEach(System.out::println);

        //flatmap will flatten the list of list elements into list
        List<String> result=list2.stream()
                .flatMap(lst->lst.stream())
                .map(ele->ele.toUpperCase())
                .toList();
        System.out.println(result);

        //peek will not modify the data but it prints the data
        List<Integer> squredlist=list.stream()
                .map(n->n*n)
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}
