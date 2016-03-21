## 삽입 정렬(Insertion Sort)
<br>
정렬되어 있는 부분 집합에 정렬할 새로운 원소 위치를 찾아 삽입하는 방법이다.<br>
삽입 정렬에서는 정렬할 자료가 두 개의 부분집합 Sorted와 Unsorted로 나뉘어 있다.<br>
정렬되지 않은 부분집합 U의 원소를 하나씩 꺼내서 이미 정렬되어 있는 부분집합 S의 마지막 원소부터 비교하며 위치를 찾아 삽입하여 부분집합 S의 원소는 하나씩 늘리고 부분집합 U의 원소는 하나씩 줄어든다. U의 원소를 모두 삽입하여 공집합이 되면 삽입 정렬이 완성된다.<br>
<br>
n개의 자료를 정렬하는 삽입 정렬에서 사용하는 메모리 공간은 n개가 된다.<br>
삽입 정렬에서 원소를 비교하는 횟수가 최소인 경우에는 이미 원소들이 정렬된 경우다.<br>
이미 정렬되어 있는 경우에는 바로 앞자리 원소와 한번만 비교한다.<br>
그러므로 최소의 전체 비교 회수는 n-1이 되어 시간 복잡도가 O(n)이 된다.<br>
만약 모든 원소가 역순으로 되어 있는 경우에는 비교 횟수가 최대가 되어 시간 복잡도가 O(n^2)가 된다. 
