import java.util.HashMap;


public class Anadrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> charCountMap 
        = new HashMap<Character, Integer>(); 

    String word = "abcb";
    int count =0;
    char[] strArray = word.toCharArray(); 

    // checking each char of strArray 
    for (char c : strArray) { 
        if (charCountMap.containsKey(c)) { 
            charCountMap.put(c, charCountMap.get(c) + 1); 
        } 
        else {  
            charCountMap.put(c, 1); 
        } 
    }
    for(int i=0;i< word.length();i++) {
    	if(charCountMap.get(word.charAt(i)) %2 != 0) {
    		count++;
    		//System.out.println(word.charAt(i));
    	}
    }
   // System.out.println(charCountMap.keySet());
	//System.out.println(charCountMap.values());
    //System.out.println(count-1);
	}

}
