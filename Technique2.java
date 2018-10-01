/**
 * 
 */
package Lab3;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * @author ybui210
 *
 */
public class Technique2 {

	public static String sort(String original){
		char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
		return sorted;
	}
	
	
	public static boolean checkAnagram(String src, String cmp){
		if (src.equals(cmp) || src.length()!= cmp.length()){
			return false;
		}
		String word1 = sort(src);
		String word2 = sort(cmp);
		if (word1.equals(word2))
			return true;
		else return false;
	}
		
		
	public static String findAnagram() throws FileNotFoundException{
		java.io.File file = new java.io.File("src/Lab3/Dict.txt");
		int max=0;
		String maxAnagram = null;
		Scanner scan1 = new Scanner(file);
		while (scan1.hasNext()){
			String orgWord = scan1.next();
			int count = 0;
			java.io.File file1 = new java.io.File("src/Lab3/Dict.txt");
			Scanner scan2 = new Scanner(file1);
			while (scan2.hasNext()){
				String cmpWord = scan2.next();
				if (checkAnagram(orgWord.toLowerCase(), cmpWord.toLowerCase())){
					count++;
				}
			}
			if (max < count){
				max = count;
				maxAnagram = orgWord;
				System.out.println(maxAnagram + " " + max);
			}
			scan2.close();
		}
		scan1.close();
		return maxAnagram;
	}
	public static void main(String[] args) throws FileNotFoundException {
		
        long start = System.nanoTime();
        String result = findAnagram();
        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        
		System.out.println(" Result: " + result + " in: " + microseconds + " microseconds");
		
	}

}
