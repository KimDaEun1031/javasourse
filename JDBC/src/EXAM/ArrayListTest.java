package EXAM;

import java.util.ArrayList;
import java.util.List;

/* �����͸� ��� ���� ���ΰ�? �⺻�� Ÿ�� / Ŭ���� Ÿ��(��ü)  
 * �⺻�� : int, double...char, float
 * ��ü : Integer, Float, Double, String...
 * 
 * ���� �����Ͱ� �������ٸ� : �迭, �÷���(list,set), Map
 * 
 * List interface : ArrayList, LinkedList
 */

public class ArrayListTest {

	public static void main(String[] args) {
		//����Ʈ ��ü ����
		List<String> list = new ArrayList<String>();
		
		//������ list�� ��� �߰�
		list.add("java");
		list.add("JDBC");
		list.add("oracle");
		list.add("html");
		
		//��� Ȯ��
		for(String str:list) {
			System.out.println(str);
		}
		System.out.println();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		//Ư����� Ȯ��
		System.out.println(list.get(2));
		
	}

}
