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
public class Technique3 {
	
	public static boolean checkAnagram(String src, String cmp){
		if (src.equals(cmp) || src.length()!= cmp.length()){
			return false;
		}
		int charNumber = 128;
		
		//create int array to count character
		int[] count = new int[charNumber];
		
		/*increase the number of character if it's available in char1
		decrease the number of character if it's available in char 2
		*/
		for (int i=0; i<src.length(); i++){
			count[src.charAt(i)]++;
			count[cmp.charAt(i)]--;
		}
		//if any character has the number of 
		for (int i=0; i<charNumber; i++){
			if (count[i] !=0) {
				return false;
			}		
		}
		System.out.print(" " + cmp);
		return true;		
	}
		
		
	public static String findAnagram() throws FileNotFoundException{
		java.io.File file = new java.io.File("src/Lab3/Dict.txt");
		int max=0;
		String maxAnagram = null;
		Scanner scan1 = new Scanner(file);
		while (scan1.hasNext()){
			String orgWord = scan1.next();
			System.out.print("\n" + orgWord);
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
