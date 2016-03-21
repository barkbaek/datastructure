interface Stack{
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class StackNode{
	char data;	
	StackNode link;
}

class LinkedStack implements Stack{
	private StackNode top;
		
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(char item){
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;		
	}
	
	public char pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			char item = top.data;
			top = top.link;
			return item;	
		}				
	}	
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");			
		}
		else {
			top = top.link;
		}
	}
	
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else 
			return top.data;		
	}
	
	public void printStack(){
		if(isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else{
			StackNode temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null){
				System.out.printf("\t %c \n", temp.data);
				temp = temp.link;
			}
			System.out.println();	
		}
	}
}

class OptExp{
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp){
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '(' :
				case '{' :
				case '[' : 
					S.push(testCh); break;				
				case ')' :
				case '}' :
				case ']' : 
					if(S.isEmpty()) return false;
					else{
						openPair = S.pop();
						if((openPair == '(' && testCh != ')') ||
						   (openPair == '{' && testCh != '}') ||
						   (openPair == '[' && testCh != ']'))
						   return false;
					   else break;
					}
			}
		}
		if (S.isEmpty()) return true;
		else return false;
	}
	
	public char[] toPrefix(String infix){
		char testCh;		
		exp = infix;	
		int expSize = 10;
		int j=0;
		char prefix[] = new char[expSize];
		LinkedStack S = new LinkedStack();
		
		for(int i=expSize; i>=0; i--){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					prefix[j++] = testCh; break;
					
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					S.push(testCh); break;
					
				case '(' :  prefix[j++] =S.pop(); break;
				
				
				default:
			}
		}
		prefix[j] = S.pop();
		for (int x=0; x<=4; x++) {
			char ch = prefix[x];
			prefix[x] = prefix[9-x];
			prefix[9-x] = ch;
		}
		return prefix;
	}	
}

class Ex7_3{
	public static void main(String args[]){
		OptExp opt = new OptExp();
		String exp = "(3*5)-(6/2)";
		char prefix[];
		int value;
		System.out.println(exp);
		if(opt.testPair(exp))
			System.out.println("Correct Braces");
		else 
			System.out.println("Wrong Braces!");			
						
		System.out.printf("\nPrefix : ");
		prefix = opt.toPrefix(exp);
		System.out.println(prefix);	
	}
}

