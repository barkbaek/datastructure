import java.util.*;

public class Ex6_1{
	public static void main(String args[]){
		// 링크드 리스트 인스턴스를 생성한다.
		LinkedList L = new LinkedList();
		System.out.println("(1) Insert 3 nodes");
		L.insertLastNode("Mon");
		L.insertLastNode("Wed");
		L.insertLastNode("Sun");
		L.printList();

		System.out.println("(2) Insert Wed node after Fri node");
		ListNode pre = L.searchNode("Wed");
		if(pre == null) 
			System.out.println("Search Fail>> No Found.");
		else{
			L.insertMiddleNode(pre, "Fri");
			L.printList();
		}

		System.out.println("(3) Change the order of node of list to reverse");
		L.reverseList();
		L.printList();

		System.out.println("(4) Delete the last node of list");      
		L.deleteLastNode();
		L.printList();
	}
}

class LinkedList{
	private ListNode head;
	public LinkedList(){
		head = null;
	}
	// pre는 삽입할 새 노드의 앞 노드를 지칭한다. 새 노드의 링크를 pre의 링크로 채워주고, pre의 링크를 새 노드의 링크로 채워준다.
	public void insertMiddleNode(ListNode pre, String data){       
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	// 새 노드를 생성하여 링크드리스트의 가장 마지막 노드로 추가한다.
	public void insertLastNode(String data){
		ListNode newNode = new ListNode(data);
		if(head == null){
			this.head = newNode;
		}
		else{
			ListNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	// 링크드 리스트에 가장 마지막에 존재하는 노드를 삭제한다.
	// 참고 : 가장 마지막 노드는 가장 최근에 추가된 노드이다. 
	public void deleteLastNode(){
		ListNode pre, temp;
		// 링크드 리스트가 비어있는 경우라면 그대로 함수 종료한다.
		if(head == null)  return;
		// 링크드 리스트에 단 1개의 노드만 존재한다면, head를 비워준다.
		if(head.link == null){
			head = null;
		}
		else{
			// 링크드 리스트에 2개 이상의 노드가 존재한다면, temp가 가장 마지막 노드를, pre가 마지막에서 2번째 노드를 가리키도록 지정한 후, 마지막 노드를 삭제한다.
			pre = head;
			temp = head.link;
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	// 노드를 검색하고, 찾는 경우 해당 노드 객체를 반환하고, 찾지 못하는 경우 null을 반환한다.
	public ListNode searchNode(String data){
		ListNode temp = this.head;
		while(temp != null){
			// 데이터를 찾은 경우 노드를 반환한다.
			if(data == temp.getData())  
				return temp;
			else temp = temp.link;
		}
		// 여기까지 실행되면 temp는 null인 상태이다. 즉, 검색 실패이며 null을 반환한다.
		return  temp;
	}
	// 링크드 리스트의 순서를 역순으로 변경한다.
	public void reverseList(){
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		// pre는 역순으로 변경되기 전 current의 바로 앞에 위치한 노드이다.
		// current.link로 pre를 연결함으로써, 역순으로 변경한다.
		while(next != null){
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	// 링크드 리스트의 head부터 차례대로 출력한다.
	public void printList(){
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null){
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null){
				System.out.printf(", ");
			}			
		}
		System.out.println(")");
	}
}

// 링크드 리스트의 각 노드를 정의한다. 생성자에 있어 오버로딩을 사용하였다.
class ListNode{
	private String data;
	public ListNode link;
	public ListNode(){
		this.data = null;
		this.link = null;
	}
	public ListNode(String data){
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link){
		this.data = data;
		this.link = link;
	}
	public String getData(){
		return  this.data;
	}
}
