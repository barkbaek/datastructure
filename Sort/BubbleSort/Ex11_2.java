// Bubble Sort

import java.util.*;

class Sort{
	public void bubbleSort(int a[]){		
		int i, j, temp, size;
		size = a.length;
		// 가장 마지막 인덱스부터 거꾸로 차례대로 정렬되므로 i는 배열의 가장 마지막 인덱스 값부터 갖는다.
		for(i=size-1; i>0; i--){			
			System.out.printf("\n Step : " + (size-i));
			// 뒤에서 정렬 완료되지 않은 두 번째 인덱스까지 for 문을 돈다.
			// for문 마지막 시, a[j+i]가 정렬 완료되지 않은 가장 마지막 인덱스를 가리키게 되기 때문이다.
			for(j=0; j<i; j++){
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				// 정렬에 필요하지 않은 연산이다. 출력하기 위해 사용하였다.
				System.out.printf("\n\t");
				for(int k=0; k<size; k++)
					System.out.printf("%3d  ", a[k]);
			}
		}
	}	
 }

class Ex11_2{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		Sort S = new Sort();
		System.out.printf("\n Origin : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.bubbleSort(a);
	}
}
