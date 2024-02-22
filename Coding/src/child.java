
public class child extends Parent{
	public int x;
	public child(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * public void display() { System.out.println("This is child"); }
	 */

	public void abstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("Method from Abstract class");
	}
	public static void main(String[] args) {
		
		Parent c = new child(200);
		c.display();
		c.abstractMethod();
		System.out.println(c.x);
		
	}


}
