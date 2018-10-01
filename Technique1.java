/**
 * 
 */
package Lab3;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author ybui210
 *
 */
public class Technique1 {

	public static boolean checkAnagram(String src, String cmp){
		//create a copy for cmp string.
		String word = cmp;
		if (src.equals(word) || src.length()!= word.length()){
			return false;
		}
		
		StringBuilder build = new StringBuilder(word);
		for (int i = 0; i< src.length(); i++){
			char a = src.charAt(i); 
			int index = build.indexOf(""+a);
			//find character a from src string in  word, if not available, return false
			if (index != -1){
				build = build.deleteCharAt(index);
			}
			else {
				return false;
			}
		}
		
		return true;
		
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
