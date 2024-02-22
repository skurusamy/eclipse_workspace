import java.util.HashMap;
import java.util.Map;

public class DuplicateMissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Arr = {5,6,6,4,4,2};
		HashMap<Integer,Boolean> hash = new HashMap<>();
		for(Integer a : Arr) {
			if(hash.get(a)==null) {
				hash.put(a, true);
			}
			else
				System.out.println(a);
		}
		for(int i=1;i<=Arr.length;i++) {
			if(hash.get(i)==null) {
				System.out.println("Missing:"+i);
			}
		}
			
	}

}
