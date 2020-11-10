package arraypractice;

import java.util.Arrays;

public class EX01 {

	public static void main(String[] args) {
		// 1 ~ 1000���� �� ������ ���� ���ϱ�
		//EX) 10~15���� �� ������ ������ ���غ��� 
		//�� : 10 = 1,0  / 11 = 1,1 / ... / 15 = 1,5  �̹Ƿ� 0�� 1�� 1�� 7�� ���� �̷�������
		
		
		//if���� ���� ��
		int array [] = new int[10]; // 0~9�� ���� ����			
		for(int i =1;i<=1000;i++) {
			array[i%10]++;
			if(i>=10) array[(i/10)%10]++; //ù��° ������ ���� ���� ���� �ι�° ������ ���� ��
			if(i>=100) array[(i/100)%10]++;
			if(i==1000) array[1]++;	//1000�� �������� �� 0 3���� ������ 1�� �ȵ��⿡ 1�� ���ڰ� �Ҵ� �� �迭 1�� 1�� �����Ǵ� ����
		}
		System.out.println(Arrays.toString(array));
		
		
		
		//do while�� ���� ��
		int arr[] = new int[10];
		for(int i = 1; i <= 1000; i++) {
		    int tmp = i;
		    do  {arr[tmp % 10]++;} 
		    while((tmp /= 10) != 0);
		}
		System.out.println(Arrays.toString(arr));
	}

}
