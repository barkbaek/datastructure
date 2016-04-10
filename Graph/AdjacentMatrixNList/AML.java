class AdjMatrix {
	private int matrix[][] = new int[10][10];
	private int totalV = 0;

	public void insertVertex(int v) {
		totalV++;
	}

	public void insertEdge(int v1, int v2) {
		if (v1 >= totalV || v2 >= totalV) {
			System.out.println("Wrong vertex for edge.. - AdjMatrix");
		} else {
			matrix[v1][v2] = 1;
		}
	}

	public void printMatrix() {
		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n\t\t");
			for (int j = 0; j < totalV; j++) {
				System.out.printf("%2d", matrix[i][j]);
			}
		}
	}
}

class GraphNode {
	int vertex;
	GraphNode link;
}

class AdjList {
	private GraphNode head[] = new GraphNode[10];
	private int totalV = 0;

	public void insertVertex(int v){
		totalV++;
	}

	public void insertEdge(int v1, int v2) {
		if (v1 >= totalV || v2 >= totalV) {
			System.out.println("Wrong vertex for edge.. - AdjList");
		} else {
			GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			if (gNode.link == null) System.out.printf("v1 : %d, v2 : %d , the edge link is null\n", v1, v2);
			else System.out.printf("v1 : %d, v2 : %d , the edge link is not null. next vertex is %d\n", v1, v2, gNode.link.vertex);
			head[v1] = gNode;
		}
	}

	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n[Adjacent List of Vertex %c]", i + 65);
			gNode = head[i];
			while (gNode != null) {
				System.out.printf(" -> %c", gNode.vertex + 65);
				gNode = gNode.link;
			}
		}
	}
}

class AML {
	public static void main(String[] args) {
		AdjMatrix MG1 = new AdjMatrix();
		for (int i = 0; i < 4; i++) {
			MG1.insertVertex(i);
		}
		MG1.insertEdge(0, 3);
		MG1.insertEdge(0, 1);
		MG1.insertEdge(1, 3);
		MG1.insertEdge(1, 2);
		MG1.insertEdge(1, 0);
		MG1.insertEdge(2, 3);
		MG1.insertEdge(2, 1);
		MG1.insertEdge(3, 2);
		MG1.insertEdge(3, 1);
		MG1.insertEdge(3, 0);
		System.out.printf("\nAdjacent Matrix of Graph G1 : ");
		MG1.printMatrix();
		System.out.println();

		AdjList LG1 = new AdjList();
		for (int i = 0; i < 4; i++) {
			LG1.insertVertex(i);
		}
		LG1.insertEdge(0, 3);
		LG1.insertEdge(0, 1);
		LG1.insertEdge(1, 3);
		LG1.insertEdge(1, 2);
		LG1.insertEdge(1, 0);
		LG1.insertEdge(2, 3);
		LG1.insertEdge(2, 1);
		LG1.insertEdge(3, 2);
		LG1.insertEdge(3, 1);
		LG1.insertEdge(3, 0);

		System.out.printf("\nAdjacent Matrix of Graph G1 : ");

		LG1.printAdjList();

		System.out.println();
		
	}
}
