import java.util.ArrayList;
import java.util.List;

public class AddKSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,3};
		int k = 3;
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<arr.length-k+1;i++) {
			int sum =0;
			for(int j = i;j<i+k;j++) {
				sum = arr[j]+sum;
				
			}
			list.add(sum);
		}
		System.out.println(list);
	}
}
