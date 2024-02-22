
public class Application implements IExample{

	public int multiply(int a, int b) {
		int ans =0;
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b>0) {
			ans = ans + a;
			b--;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
	}

}
