package EXAM;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1234, "�輭��"));
		list.add(new Member(1235, "�����"));
		list.add(new Member(1236, "�ֿ���"));
		list.add(new Member(1237, "������"));
		list.add(new Member(1238, "������"));
		list.add(new Member(1239, "����Ű"));
		
		for(Member mem:list) {
			System.out.println(mem);
		}
	}

}
