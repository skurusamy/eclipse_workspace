
import java.util.HashMap;
public class Question4{
	private String fname;
	private String lname;
	public Question4(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public static void main(String[] args) {
		HashMap h = new HashMap();
		Question4 q1 = new Question4("abc","lok");
		Question4 q2 = new Question4("abc","lok");
		
		h.put(q1, "q1");
		System.out.println(h.get("q1"));
	}
}