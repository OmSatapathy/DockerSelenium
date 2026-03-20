package corejava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class collection {

	public static void main(String[] args) {

		Integer[] num = { 5, 6, 7, 8, 9, 2, 55, 9, 5, 2 };

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
