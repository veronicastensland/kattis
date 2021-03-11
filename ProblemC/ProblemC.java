/*
Problem
The problem here is that you want to be able to put in up to 200 words, and for each word, no matter how many letters it contains 
- it should output the amount of possible unique anagrams/permutations you could make out of that word. 
The tricky thing here is the actual mathematical calculation here, at least for me since I am not really familiar with, 
to get the number of possible permutations of the word. 

Solution
Since I wasn't really familiar with the math behind this, I had to look it up and discovered that: 
the factorial of wordlenght divided by the factorial of numOfSameCharsInWord will output the number of different combinations possible. 
So the program needed to run and keep expecting words until it reached 200, so by having a counter, 
a while(input.hasNext()) and a condition to break the loop when the counter reached 200 I achived that. 
I made a factorial(wordlength) method to multiply the BigInteger with 2, 3 ... and so on until wordlenght. 
To check how many chars in the word that were the same, I made two for-loops (for small and big letters) 
that go though the whole alphabet and check if the current letter ch in the alphabet is the same as any char in the word. 
If it is, then I increment an int representing totalNumOfSame chars, that is the corrent number when it has iterated over both for-loops. 
By the last allocation of result in the forloop the result is ready to be printed.
*/

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemC {

    private Scanner input = new Scanner(System.in);
    private String userInput;

    public static void main(String[] args) {
        ProblemC problem = new ProblemC();
        problem.start();
    }

    private void start() {
        int counter = 0;

        while (input.hasNext()) {
            userInput = input.next();
            calculateNumberOfPossibleAnagrams();
            counter++;

            if (counter >= 200)
                break;
        }

        input.close();
    }

    private void calculateNumberOfPossibleAnagrams(){
        BigInteger result = factorial(userInput.length());

        for (char c = 'A'; c <= 'Z'; c++)
            result = result.divide(factorial(countMatchingCharsInString(userInput , c)));
            
        for (char c = 'a'; c <= 'z'; c++)
            result = result.divide(factorial(countMatchingCharsInString(userInput , c)));
            
        System.out.println(result);
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));

        return result;
    }
    
    public static int countMatchingCharsInString(String str , char ch) {
        int numOfSameChars = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                numOfSameChars++;
        
        return numOfSameChars;
    }
}


    // int numOfAnagrams;

    // public static void main(String[] args) {
    //     Scanner scan = new Scanner(System.in);
    //     String input = scan.nextLine();
    //     permutation(input, "");
    //  }    

    //  private static void permutation(String input, String sofar) {
    //      if (input.equals("")) {
    //          System.out.printf("%s,", sofar);
    //      }
    //      for (int i = 0; i<input.length(); i++) {
    //          char c = input.charAt(i);
    //          if (input.indexOf(c, i + 1) != -1)
    //          continue;

    //          //permutation(input.substring(0, i) + input.substring(i + 1), sofar+c);

    //      }
    //  }




        // while (input.hasNext())
        //     {
        //     String str = input.next();
            
        //     BigInteger result = factorial(str.length());
            
        //     for (char c = 'A'; c <= 'Z'; c++)
        //         result = result.divide(factorial(countMatchingCharsInString(str , c)));
            
        //     for (char c = 'a'; c <= 'z'; c++)
        //         result = result.divide(factorial(countMatchingCharsInString(str , c)));
            
        //     System.out.println(result);
        //     }
        
        //     input.close();


    




    // public static void main(String[] args) { 
	// 	subString("deaf"); 
	// } 

	// static void subString(String s){ 
	// 	HashMap<String, Integer> map = new HashMap<>(); 

	// 	for(int i = 0; i < s.length(); i++){ 
	// 		for(int j = i; j < s.length(); j++){ 
	// 			char[] valC = s.substring(i, j+1).toCharArray(); 
	// 			Arrays.sort(valC); 
	// 			String val = new String(valC); 
	// 			if (map.containsKey(val)) 
	// 				map.put(val, map.get(val)+1); 
	// 			else
	// 				map.put(val, 1); 
	// 		} 
	// 	} 
	// 	int anagramPairCount = 0; 
	// 	for(String key: map.keySet()){ 
	// 		int n = map.get(key); 
	// 		anagramPairCount += (n * (n-1))/2; 
	// 	} 
	// 	System.out.println(anagramPairCount); 
	// } 