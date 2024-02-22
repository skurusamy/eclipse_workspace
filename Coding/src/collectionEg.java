import java.util.ArrayList;
import java.util.Iterator;

class Student{
	int roll;
	String name;
}

public class collectionEg {
public static void main(String[] args) {
	ArrayList<String> a = new ArrayList<String>();
	ArrayList a2 =  new ArrayList();
	Student s = new Student();
	s.name="Subha";
	s.roll=100;
	a.add("hai");
	a.add("string");
	
	a2.add(1);
	a2.add("Hai");
	a2.add("Hai");
	a2.add(s);
	a2.set(2, "element");
	a2.remove(2);
	
		/*
		 * Iterator<String> i = a.iterator(); while(i.hasNext()){
		 * System.out.println(i.next()); };
		 */
	for( Object i: a2) {
		System.out.println(i);
	}
	System.out.println(a2.get(2));
}
}
