import java.util.LinkedHashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello world";
		LinkedHashSet<Character> hash =  new LinkedHashSet<>();
		for( int i =0;i<str.length();i++) {
			hash.add(str.charAt(i));
		}
		for(Character a: hash) {
			System.out.println(a);
		}
	}

}
