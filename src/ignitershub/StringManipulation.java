package ignitershub;

import java.util.Scanner;

public class StringManipulation {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a sentence: ");
	        String inputSentence = scanner.nextLine();

	        // Operation 1: Count the number of words
	        int wordCount = wordCount(inputSentence);
	        System.out.println("Number of words in the sentence: " + wordCount);

	        // Operation 2: Reverse the order of words
	        String reversedSentence = reversedSentence(inputSentence);
	        System.out.println("Reversed sentence: " + reversedSentence);

	        // Operation 3: Replace spaces with hyphens
	        String hyphenatedSentence = replaceSpaceWithHyphen(inputSentence);
	        System.out.println("Sentence with spaces replaced by hyphens: " + hyphenatedSentence);

	        scanner.close();
	    }

	    private static int wordCount(String sentence) {
	        String[] words = sentence.split("\\s+");
	        return words.length;
	    }

	    private static String reversedSentence(String sentence) {
	        String[] words = sentence.split("\\s+");
	        StringBuilder reversedSentence = new StringBuilder();

	        for (int i = words.length - 1; i >= 0; i--) {
	            reversedSentence.append(words[i]).append(" ");
	        }

	        return reversedSentence.toString().trim();
	    }

	    private static String replaceSpaceWithHyphen(String sentence) {
	        return sentence.replaceAll("\\s", "-");
	    }

}
