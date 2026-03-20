package corejava;

public class Stringprog {

	public static void main(String[] args) {

		String str = "Om prakash satapathy";

		String[] stp = str.split(" ");

		for (int i = stp.length - 1; i >= 0; i--) {
			System.out.print(stp[i] + " ");
		}

		
	}

}
