public class StringOperations {
    public static void main(String[] args) {
        String str = "Hello, World!";

        // Get length of the string
        int length = str.length();
        System.out.println("Length: " + length);

        // Convert to uppercase
        String upperStr = str.toUpperCase();
        System.out.println("Uppercase: " + upperStr);

        // Convert to lowercase
        String lowerStr = str.toLowerCase();
        System.out.println("Lowercase: " + lowerStr);

        // Substring from index 7 to the end
        String substring = str.substring(7);
        System.out.println("Substring (from index 7): " + substring);

        // Replace 'World' with 'Java'
        String replacedStr = str.replace("World", "Java");
        System.out.println("Replaced String: " + replacedStr);

        // Check if the string contains 'Hello'
        boolean containsHello = str.contains("Hello");
        System.out.println("Contains 'Hello': " + containsHello);

        StringDemo.stringBuilderOp();
        StringDemo.divideConqureOp();
        StringDemo.reverseStream(str);
        StringDemo.isPalindrome("madam");
        StringDemo.occurrenceCount("hello world");
         StringDemo.countChars("hello world");

    }
    
}
