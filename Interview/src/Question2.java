import java.util.ArrayList;
import java.util.HashMap;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1,2,3,4,5,6};
		int d=5;
		 int level = (int) Math.sqrt(d-1);
		 int num = (int) Math.pow(2,level);
		 ArrayList<Integer> ans = new ArrayList<Integer>();
		 
		 int pre_element = (int)Math.pow(2, level-1)+1;
		 if(level ==0)
			 ans.add(-1);
		 else {
		 for(int i= pre_element+1;i<=pre_element+num;i++) {
			 if(i != d && i<=arr.length)
				ans.add(i);
		 }
		 }
		 int[] result = new int[ans.size()];
		 for(int i=0;i<ans.size();i++) {
			 result[i] = ans.get(i);
		 }
		// return result;
		 
		// for(int i=0;i<result.length;i++) {
		//	 System.out.println(result[i]);
		 //}
	}
	
	
	
	

}
