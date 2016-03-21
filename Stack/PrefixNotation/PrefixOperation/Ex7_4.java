class StackNode{
	int data;	
	StackNode link;
}

class LinkedStack{
	private StackNode top;
		
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(int item){
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;		
	}
	
	public int pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			int item = top.data;
			top = top.link;
			return item;	
		}				
	}

	public void printStack() {
		StackNode temp = top;
		System.out.print("[");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.link;
		}
		System.out.println("]");
	}	
}

class OptExp2{	
	private String exp;
	
	public int evalPostfix(String postfix){		
		LinkedStack S = new LinkedStack();
		LinkedStack C = new LinkedStack();

		exp = postfix;
		int opr, val1, val2, value;			
		boolean firstLetter = false;
	    char testCh;
		for(int i=0; i<7; i++){		
			testCh = exp.charAt(i);

			System.out.println("\ntestCh : " + testCh);

			// 숫자면
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/'){
				value = testCh - '0';

				if (!firstLetter){
					
					C.push(value);
					firstLetter = true;
					System.out.println("첫번째 레터이기 때문에 push");
					S.printStack();
					C.printStack();
					
				} else {
					val1 = C.pop();
					val2 = value;
					opr = S.pop();

					switch(opr){
						case '+' : C.push(val1 + val2); break;
						case '-' : C.push(val1 - val2); break;
						case '*' : C.push(val1 * val2); break;
						case '/' : C.push(val1 / val2); break;
					}
					firstLetter = false;
					System.out.println("첫번째 레터가 아니기 때문에 pop - val1 : " + val1 + ", val2 : " + val2 + ", opr : " + (char)opr);
					S.printStack();
					C.printStack();
				}
				
			}
			// 연산자면
			else{
				S.push(testCh);
				firstLetter = false;
				S.printStack();
				C.printStack();
			}
		}

		S.printStack();
		C.printStack();

		while (!S.isEmpty()) {
			val2 = C.pop();
			val1 = C.pop();
			opr = S.pop();

			switch(opr){
				case '+' : C.push(val1 + val2); break;
				case '-' : C.push(val1 - val2); break;
				case '*' : C.push(val1 * val2); break;
				case '/' : C.push(val1 / val2); break;
			}
			
		}

		return C.pop();
	}	
}

class Ex7_4{
	public static void main(String args[]){
		OptExp2 opt = new OptExp2();
		int result;
		String exp = "-*35/62";	
		System.out.printf("\nPrefix Notation : %s", exp);
		result = opt.evalPostfix(exp);
		System.out.printf("\n Operation Result =  %d \n", result);		

	}
}
