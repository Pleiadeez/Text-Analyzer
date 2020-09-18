import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*Author: Jarett Wright
 * Class: Software Development 1
 * Due Date: 09/20/2020
 * Description: This program takes a .txt file of Edgar Allen Poe's "The Raven", and scans the contents to determine
 * the most used words and the frequency at which they occur. The results are printed with the rank in descending order.
 * 
 */

public class TextAnalyzer {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Open txt file and scanner
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:/Module 2 work/TheRaven.txt"));
	    } catch (FileNotFoundException e) {
		       e.printStackTrace();  
		}
        
		// Hashmap to store words and instances
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String word = scan.next(); 
            if(map.containsKey(word) == false) // If word doesn't exist in map add it with value of 1
                map.put(word,1);
            else // Locate word, remove and replace it, then ++ the count
            {
                int count = (int)(map.get(word));
                map.remove(word);  
                map.put(word,count+1); 
            }
        }
        
        // Collect Entries
        Set<Map.Entry<String, Integer>> set = map.entrySet(); 
        
        // Create and Sort arraylist
        List<Map.Entry<String, Integer>> wordList = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort( wordList, new Comparator<Map.Entry<String, Integer>>() 
        {
        	// Sort by descending values
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 
            {
                return (b.getValue()).compareTo( a.getValue() ); 
            }
        } );
        
        // Output Results
        int numCount = 1;
        System.out.println("Rank\tWord\t\tNumber of Instances");
        System.out.println("====\t====\t\t===================");
        for(Map.Entry<String, Integer> i:wordList){
            System.out.println(numCount + ")\t" + i.getKey() + "\t\t\t" + i.getValue());
            numCount++;
        }
		
	

	}

}
