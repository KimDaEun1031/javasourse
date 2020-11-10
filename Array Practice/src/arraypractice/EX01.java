package arraypractice;

import java.util.Arrays;

public class EX01 {

	public static void main(String[] args) {
		// 1 ~ 1000에서 각 숫자의 개수 구하기
		//EX) 10~15에서 각 숫자의 개수를 구해보자 
		//답 : 10 = 1,0  / 11 = 1,1 / ... / 15 = 1,5  이므로 0은 1개 1은 7개 등등등 이런식으로
		
		
		//if문을 썼을 때
		int array [] = new int[10]; // 0~9을 넣을 공간			
		for(int i =1;i<=1000;i++) {
			array[i%10]++;
			if(i>=10) array[(i/10)%10]++; //첫번째 나머지 값이 먼저 들어가고 두번째 나머지 값이 들어감
			if(i>=100) array[(i/100)%10]++;
			if(i==1000) array[1]++;	//1000을 나누었을 때 0 3개는 들어가지만 1이 안들어가기에 1의 숫자가 할당 된 배열 1이 1번 증감되는 거임
		}
		System.out.println(Arrays.toString(array));
		
		
		
		//do while을 썻을 때
		int arr[] = new int[10];
		for(int i = 1; i <= 1000; i++) {
		    int tmp = i;
		    do  {arr[tmp % 10]++;} 
		    while((tmp /= 10) != 0);
		}
		System.out.println(Arrays.toString(arr));
	}

}
