
public class innerClassEg {
	int i =90;
	public class innerClass{
		public int x=100;
	}
public static void main(String[] args) {
	innerClassEg outer = new innerClassEg();
	System.out.println(outer.i);
	//innerClassEg.innerClass inner = outer.new innerClass();
	//innerClassEg.innerClass in = new innerClassEg.innerClass();
	//System.out.println(i.x);
}
}
