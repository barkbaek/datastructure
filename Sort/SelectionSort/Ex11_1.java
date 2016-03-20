import java.util.*; 
// 선택 정렬

class Sort{
	public void selectionSort(int a[]){		
		int i, j, min;

		// for문이 length-1까지만 돌아도 마지막 데이터는 자동으로 가장 큰 데이터가 되므로
		// 따로 정렬하지 않아도 된다.
		for(i=0; i<a.length-1; i++){
			// min에는 일단 변경하고자 하는 인덱스 값으로 초기화한다.
			min = i;
			// i의 다음 데이터부터 인덱스 min 위치에 존재하는 값과 비교하여 더 작으면 인덱스를 min으로 변경한다.
			for(j=i+1; j<a.length; j++){
				if(a[j] < a[min])
					min = j;
			}				
			// 인덱스 i와 min 위치에 존재하는 데이터를 교환한다.
			swap(a, min, i);
			System.out.printf("\nCurrent Step : ", i+1);
			// 정렬에는 불필요한 연산이다. 출력하기 위해 사용하였다.
			for(j=0; j<a.length; j++)
				System.out.printf("%3d ", a[j]);
		}
	}
	
	// 교환하는 함수이다.
	public void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
 }

class Ex11_1{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		Sort S = new Sort();
		System.out.printf("\n Origin Arr : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.selectionSort(a);
	}
}	
