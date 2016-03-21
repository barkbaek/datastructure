// 삽입 정렬

class Sort{
	public void insertionSort(int a[], int size){
		int i, j, t, temp;	
		for(i=1; i<size; i++){
			temp = a[i];
			j = i;
			// temp가 정렬된 원소보다 크거나 같을 때까지 혹은 정렬된 모든 원소보다 작을 때까지 while문을 반복한다.
			// 만약 temp가 정렬된 원소보다 작을 경우, 정렬된 원소 값을 다음 인덱스로 옮긴다.
			//
			while((j>0) && (a[j-1]>temp)){
				a[j] = a[j-1];
				j--;
			}
			// 이 지점에 도착했다면, a[j]는 a[0] 혹은 정렬된 원소들 사이에 위치한다.
			a[j] = temp;
			System.out.printf("\n Insertion Sort step : ", i);
			for(t=0; t<size; t++)
				System.out.printf("%3d ", a[t]);			
		}
		System.out.println();
	}
}

class Ex11_4{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		Sort S = new Sort();
		System.out.printf("\nOriginal Array : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.insertionSort(a, size);
	}
}
