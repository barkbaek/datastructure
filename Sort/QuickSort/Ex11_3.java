// Quick Sort

class Sort{
	int i=0;
	public int partition(int a[], int begin, int end){
		int pivot, temp, L, R, t;
		
		L = begin;
		R = end;
		pivot = (begin + end)/2;
		System.out.printf("\n[Before Quick Sort %d : a[pivot]=%d, pivot=%d, L=%d, R=%d]\n", ++i, a[pivot], pivot, L, R);
		while(L<R){
			while((a[L]<a[pivot]) && (L<R)) L++;
			while((a[R]>=a[pivot]) && (L<R)) R--;
			if(L<R){
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;
				
				//////
				// L과 pivot이 같을 경우, 바로 위에서 이미 L과 R의 값을 변경한 상태이기 때문에
				// 즉, pivot과 R의 값을 이미 변경하였기 때문에 while문 빠져나가 밑에서 다시 pivot과 R을 변경하면
				// 안되기 때문에 pivot과 R의 인덱스를 일치시켜주는 것이다.
				if(L==pivot)
					pivot = R;
				/////				
			}
		}
		// When (L=R)
		temp = a[pivot];
		a[pivot] = a[R];
		a[R] = temp;
		System.out.print("[After Quick Sort : ");
		for(t=0; t<a.length; t++)
			System.out.printf("%3d  ", a[t]);
		System.out.println(" ]");
		return R; 
	}
	
	public void quickSort(int a[], int begin, int end){		
		// 분할 후의 시작 인덱스와 마지막 인덱스가 같을 때까지 재귀적으로 반복한다.
		if(begin < end){
			int p;
			// begin과 end를 범위로 하여 pivot을 기준으로 비교 후 값을 교환한다. 마지막으로 교환된 pivot의 고정 위치가 p로 반환된다.
			p = partition(a, begin, end);

			quickSort(a, begin, p-1);
			quickSort(a, p+1, end);
		}
	}	
}


public class Ex11_3 {
	public static void main(String args[]){	
      		int a[]={69, 10, 30, 2, 16, 8, 31, 22};

		// size는 배열의 마지막 인덱스가 됨.
      		int size=a.length - 1;
	
		// 인스턴스 생성
		Sort S = new Sort();
		System.out.printf("\n Sorting Element : ");
		for(int i=0; i<=size; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		
		// 생성한 배열 a, 시작 인덱스 0, 마지막 인덱스 size를 전송한다.
		S.quickSort(a, 0, size);

/*		
		for(int i=0; i<=size; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
*/	
	}
}
