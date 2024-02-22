
public class HelloWorld implements firstInterface{
public static void main(String[] args) {
	System.out.println("Hello World");
	HelloWorld h = new HelloWorld();
	h.display();
}

@Override
public void display() {
	System.out.println("In interface");
	// TODO Auto-generated method stub
	
}
}
