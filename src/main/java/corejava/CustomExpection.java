package corejava;

public class CustomExpection {

	
	public static void verifyAge(int age) throws Exception {
		
		if(age<18) {
			throw new Exception("Age must be 18 or above");
		}
		else {
			 System.out.println("Eligible for voting");
		}
		
	}
	public static void main(String[] args) {
		
			try {
				verifyAge(15);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

	}

}
