
public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 ="Hello";
		String s2 ="Hi Hello World";
		for(int i=0;i<=s2.length()-s1.length();i++) {
			int j;
			for(j =0 ; j<s1.length();j++) {
				if(s2.charAt(i+j)!=s1.charAt(j))
					break;
			}
			if(j==s1.length())
			{
				System.out.println(i);
				break;
			}		
		}
 }

}
