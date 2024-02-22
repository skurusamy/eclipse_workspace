
public class staticBlockEg {
	static int x=10;
	public static void disp() {
		System.out.println("In static");
	}
	
public static void main(String[] args) {
	disp();
	staticBlockEg s = new staticBlockEg();
	s.x=100;
	System.out.println(s.x);
	
}
}
