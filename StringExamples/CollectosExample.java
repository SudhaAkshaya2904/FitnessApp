import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class CollectosExample {
     public static void main(String[] args) {
        List<String> fruits=Arrays.asList("apple","banana","apple","Mango");
        Map<String,Long> fruitMap=fruits.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(fruitMap);
        // //1. Filter Even Numbers from a List
        //1. Filter Even Numbers from a List
        List<Integer> nums=Arrays.asList(1,2,3,6,8,3,5,7,10);
        List<Integer> filteredList=nums.stream().filter( n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(filteredList);
        ////Given a list of integers, find out all the numbers starting with 1 using Stream functions?
         //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> numbers=Arrays.asList(1,12,3,6,18,3,15,7,10);
        List<Integer> result = numbers.stream()
                                      .map(String::valueOf)
                                      .filter(s -> s.startsWith("1"))
                                      .map(Integer::valueOf)
                                      .collect(Collectors.toList());
        System.out.println(result);
         //How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> dubnumbers=Arrays.asList(10,12,3,6,18,3,15,7,10);
      List<Integer> debresult = dubnumbers.stream()
                                      .distinct()
                                      .collect(Collectors.toList());
        System.out.println(debresult);
         //How to sort a given list of integers in java using Stream functions?
        List<Integer> unsortedNumbers=Arrays.asList(10,2,3,6,18,3,15,7,10);
      List<Integer> sortedresult = unsortedNumbers.stream()
                                      .sorted()
                                      .collect(Collectors.toList());
        System.out.println(sortedresult);
    }
    
}
