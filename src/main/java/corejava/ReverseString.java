package corejava;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "we are learing java";
		char[] ch = str.toCharArray();
		
		String rev ="";
		
		for( int i = ch.length-1 ; i >=0; i--) {
			
			rev = rev+ch[i];
			
		}
		
		System.out.println(rev);
		
		
		int a= 10,b =20;
		
		a= a+b;
		b = a-b;
		a= a-b;
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
