package EXAM;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1234, "±è¼­¿¬"));
		list.add(new Member(1235, "±è´ÙÀº"));
		list.add(new Member(1236, "ÁÖ¿µ¿ì"));
		list.add(new Member(1237, "ÁøÇöÁÖ"));
		list.add(new Member(1238, "±èÀ¯Àº"));
		list.add(new Member(1239, "±èÀ¯Å°"));
		
		for(Member mem:list) {
			System.out.println(mem);
		}
	}

}
