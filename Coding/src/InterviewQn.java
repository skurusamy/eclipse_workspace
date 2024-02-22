abstract class Shape{
	Shape(){
		System.out.println("ShapeClass");
	}

	 void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle");
	}
}
class Circle extends Shape{
	void draw() {
		System.out.println("Circle");
	}
}
class Rectangle extends Shape{ 
	void draw() {
		System.out.println("Rectangle");
	}
}





public class InterviewQn {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s= new Circle();
		s.draw();
		
		Shape s1= new Rectangle();
		s1.draw();
	}

	

}
