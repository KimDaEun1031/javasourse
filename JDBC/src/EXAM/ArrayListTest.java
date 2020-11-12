package EXAM;

import java.util.ArrayList;
import java.util.List;

/* 데이터를 어디에 담을 것인가? 기본형 타입 / 클래스 타입(객체)  
 * 기본형 : int, double...char, float
 * 객체 : Integer, Float, Double, String...
 * 
 * 담을 데이터가 많아진다면 : 배열, 컬렉션(list,set), Map
 * 
 * List interface : ArrayList, LinkedList
 */

public class ArrayListTest {

	public static void main(String[] args) {
		//리스트 객체 생성
		List<String> list = new ArrayList<String>();
		
		//생성된 list에 요소 추가
		list.add("java");
		list.add("JDBC");
		list.add("oracle");
		list.add("html");
		
		//요소 확인
		for(String str:list) {
			System.out.println(str);
		}
		System.out.println();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		//특정요소 확인
		System.out.println(list.get(2));
		
	}

}
