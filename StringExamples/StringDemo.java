import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringDemo {
   // private String str="Hello, World!";

    public static void stringBuilderOp(){
        //String reverse
        StringBuilder strBuilder = new StringBuilder("Hello, World!");
        String reversedStr = strBuilder.reverse().toString();   
        System.out.println("Reversed String: " + reversedStr);  
        
    }
    public static void divideConqureOp(){
        //String reverse
        String strHw = new String("Hello, World!");
         int len = strHw.length();
         int mid = len / 2;
         char[] charArray = strHw.toCharArray();
         String firstHalf = new String(charArray, 0, mid);
         String secondHalf = new String(charArray, mid, len - mid);
         String reversedStr=reverseMid(secondHalf)+reverseMid(firstHalf);
         System.out.println("Reversed String using Divide and Conquer: " + reversedStr);
        
    }

    public static void reverseStream(String str) {
        String reversedStr = str.chars()
                                .mapToObj(c -> (char) c)
                                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
                                //explain in comments how it works
                                // The chars() method converts the string into an IntStream of characters.
                                // The mapToObj() method maps each int character to a Character object.
                                // The reduce() method accumulates the characters in reverse order by prepending each character to the accumulated string.
                                // The final result is the reversed string.
                                // The third parameter of reduce() is a combiner function, which is used in parallel streams to combine partial results. Here, it concatenates two strings.
                                // Since we are not using parallel streams, this combiner is not really needed, but it's required by the reduce() method signature.
        System.out.println("Reversed String using Streams: " + reversedStr);
    }

    private static String reverseMid(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseMid(str.substring(0, str.length() - 1));
    }
    public static boolean isPalindrome(String str) {
         int strEnd=str.length()-1;
         int strStart=0;
        while(strEnd >= strStart){
	       if(str.charAt(strEnd) != str.charAt(strStart)){
            System.out.println( str + " is not a palindrome");
		     return false;
           }
           strEnd--;
            strStart++;}
            System.out.println( str + " is a palindrome");
        return true;
    }   
    public static void occurrenceCount(String str) {
        Map<Character, Integer> charCountMap = new java.util.HashMap<>();
        charCountMap=str.chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.summingInt(c -> 1)));
        System.out.println("Character Occurrence Count: " + charCountMap);
    } 
   public static void countChars(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
	   map.put(c,map.getOrDefault(c,0)+1);
	}
      
    System.out.println("countChars: " + map);
 }
 public static void firstOccurrence(String s){
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
	for(char c : s.toCharArray()){
	   map.put(c,map.getOrDefault(c,0)+1);
	}
	for(Entry<Character, Integer> a : map.entrySet()){
         if(a.getValue()==1){
              System.out.println("First non-repeating character is: " + a.getKey());
              break;
         }
	}
 }
}
