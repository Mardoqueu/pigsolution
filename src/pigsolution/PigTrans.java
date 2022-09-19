package pigsolution;


import java.util.Scanner;

public class PigTrans {
	

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // try with resource will ensure the Scanner gets closed.
            String userString = getUserInput(scanner);
            while (!userString.isEmpty()) {
                System.out.println(buildLatinString(userString));
                userString = getUserInput(scanner);
            }
        }
    }

    private static String buildLatinString(String userString) {
        StringBuilder latinString = new StringBuilder();
        for (String word : userString.split("\\s")) {
            latinizeWord(latinString, word);
        }
        return latinString.toString();
    }

    private static void latinizeWord(StringBuilder latinString, String word) {
        if (startsWithVowel(word)) {
            latinString.append(word).append("ay ");
        } else {
            latinString.append(word.substring(1)).append(word.charAt(0)).append("ay ");
        }
    }

    private static String getUserInput(Scanner scanner) {
        System.out.print("Enter a string to be converted into Pig Latin. To stop, enter a blank input: ");
        return scanner.nextLine();
    }

    private static boolean startsWithVowel(String word) {
        return "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
    }
    
}