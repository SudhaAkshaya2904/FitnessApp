
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
//imprt linkedhashmap

class streamexamples {

    public static void main(String[] args) {
        String str = "hello world";

        // Count occurrences of each character using streams
        Map<Character, Long> charCountMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        // Print the character counts
        charCountMap.forEach((character, count) -> 
            System.out.println(character + ": " + count)
        );
        // Find the first non-repeating character
        for (Map.Entry<Character, Long> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating character: " + entry.getKey());
                break;
            }
        }
        // stream example to remove duplicates from a list
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());  
                // Print the distinct numbers
        System.out.println("Distinct Numbers: " + distinctNumbers);
        //groupingby example
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "apple", "orange", "banana", "apple");
        Map<String, Long> fruitCount = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));     
        // Print the fruit counts
        fruitCount.forEach((fruit, count) ->    
            System.out.println(fruit + ": " + count)
        );  
        // using Function.identity
        Map<String, Long> fruitCountIdentity = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));    
        // Print the fruit counts using Function.identity
        fruitCountIdentity.forEach((fruit, count) ->    
            System.out.println(fruit + ": " + count)
        );
        //collect in linkedHashMap
        Map<String, Long> fruitCountLinkedHashMap = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));



        
    }
}