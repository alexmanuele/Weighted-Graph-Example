
public class LinkedList {
	LinkedList(){
		head = null;
		size = 0;
	}
	Node head;
	int size;
	
	public void prepend(Vertex v) {
		Node n = new Node(v);
		if( size > 0 ) {
			n.next = head;
			head = n;
		}
		else {
			n.next = null;
			head = n;
		}
		size++;
	}
	public Vertex get(int i) {
		if (i >= size) {
			System.out.println("Out of bounds at LinkedList.get()");
			return null;
		}
		Node n = head;
		for(int j = 0; j < i; j++) {
			n = n.next;
		}
		return n.elem;
	}
}
