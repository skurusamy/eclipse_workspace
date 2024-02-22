
public class Multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		int b = 20;
		int ans = 0;
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b>0) {
			ans = ans + a;
			b--;
		}
		System.out.println(ans);
	}

}
