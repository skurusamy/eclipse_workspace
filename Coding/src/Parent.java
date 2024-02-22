
public abstract class Parent {
	public int x=200;
	public Parent(int x) {
		this.x=100;
	}
	public abstract void abstractMethod();
	public void display() {
		System.out.println("This is parent");
	}

	/*
	 * public void display(int y) { System.out.println(y); }
	 */
public static void main(String[] args) {
	//Parent p = new Parent();
	//p.display();
	//p.display(100);
}
}
