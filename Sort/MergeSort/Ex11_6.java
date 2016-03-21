class Sort{
	private int sorted[] = new int [30];
	
	public void merge(int a[], int m, int middle, int n){
		int size = a.length;
		int  i, j, k, t;
		boolean hi;
		// i는 왼쪽 집합의 시작점(m~middle), j는 우측 집합의 시작점(middle+1~n), k는 임시 배열인 sorted 배열의 시작점
		i = m;
		j = middle+1;
		k = m;

		System.out.println("\n\n=============================");
		System.out.printf("m=%d, middle=%d, n=%d\n", m, middle, n);

		System.out.println("while문 조건 - i<=middle && j<=n\n");
		while(i<=middle && j<=n){

				System.out.printf("while(i(%d)<=middle(%d) && j(%d)<=n(%d))   a[i(%d)]=%d, a[j(%d)]=%d, sorted[k(%d)]=%d\n", i, middle, j, n, i, a[i], j, a[j], k,  sorted[k]);
			hi=false;
			
			if(a[i] <= a[j]){
				sorted[k] = a[i];
				System.out.printf("while(i(%d)<=middle(%d) && j(%d)<=n(%d))   a[i(%d)]=%d <= a[j(%d)]=%d, sorted[k(%d)]=%d\n\n", i, middle, j, n, i, a[i], j, a[j], k,  sorted[k]);
				i++;
				hi=true;
			} else{
				sorted[k] = a[j];
				System.out.printf("while(i(%d)<=middle(%d) && j(%d)<=n(%d))   a[i(%d)]=%d >  a[j(%d)]=%d, sorted[k(%d)]=%d\n\n", i, middle, j, n, i, a[i], j, a[j], k,  sorted[k]);
				j++;
				hi=true;
			}
			k++;
			if (hi == false) {
				System.out.printf("while문 비교 후(밑) a[i]=%d, a[j]=%d, sorted[k]=%d, i=%d, j=%d, k=%d\n\n", a[i-1], a[j-1], sorted[k-1], i-1, j-1, k-1 );
			}
		}
		if(i>middle){
			for(t=j; t<=n; t++, k++){
				sorted[k] = a[t];
				System.out.printf("[i(%d) > middle(%d)] [첫 t는 j. t(%d) <= n(%d)] sorted[k(%d)] = %d = a[t(%d)]\n\n", i, middle, t, n, k, a[t], t);
			}
			
		}
		else{
			for(t=i; t<=middle; t++, k++){ 
				sorted[k] = a[t];
				System.out.printf("[i(%d) <=  middle(%d)] [첫 t는 i. t(%d) <= middle(%d)] sorted[k(%d)] = %d = a[t(%d)]\n\n", i, middle, t, middle, k, a[t], t);
			}
		}
		
		for(t=m; t<=n; t++){
			a[t] = sorted[t];
			System.out.printf("(a[%d] = sorted[%d]) a[t]=%d, sorted[t]=%d\n", t, t, a[t], sorted[t]);
		}
		System.out.printf("\n Merge Sort >> ");
		for(t=0; t<size; t++) 
			System.out.printf("%3d ", a[t]);
		System.out.printf("\n");
	}
		
	public void mergeSort(int a[], int m, int n)	{
		int middle;
		if(m<n){
			middle = (m+n)/2;
			mergeSort(a, m, middle);
			mergeSort(a, middle+1, n);
			merge(a, m, middle, n);
		}
	}		
 }

class Ex11_6{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		Sort S = new Sort();
		System.out.printf("\n Elements to sort : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.mergeSort(a, 0, size-1);
	}
}
