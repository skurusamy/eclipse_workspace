
public class passbyRef {
public int x;
public int y;
public passbyRef(int x,int y) {
	this.x=x;
	this.y=y;
}
public static void swap(passbyRef a1, passbyRef a2) {
	a1.x=100;
	a1.y=100;
	passbyRef temp;
	temp=a1;
	a1=a2;
	a2=temp;
}
public static void main(String[] args) {
	passbyRef p1 = new passbyRef(1, 1);
	passbyRef p2 = new passbyRef(2, 2);
	swap(p1,p2);
	System.out.println(p1.x+" "+p1.y);
	System.out.println(p2.x+" "+p2.y);
	
}
}
