import java.util.concurrent.ConcurrentHashMap;

public class Vertex implements Comparable {
	
	Vertex(String n){
		name = n;
		adj = new ConcurrentHashMap<String, Tuple>();
		visited = false;
		dist = Integer.MAX_VALUE; //dist is set to 'infinite' here
		parent = null;
	}
	private String name;
	private ConcurrentHashMap<String, Tuple> adj; //adjacency list stores tuples of the adjacent vertex and its associated weight
	private boolean visited = false;
	private int dist;
	private Vertex parent;
	
	
	//getters and setters
	public String getName() {
		return this.name;
	}
	public ConcurrentHashMap<String, Tuple> getAdjacency(){
		return this.adj;
	}
	public void visit() {
		this.visited = true;
	}
	public boolean isVisited() {
		return this.visited;
	}
	public int getDist() {
		return this.dist;
	}
	public void setDist(int d) {
		this.dist = d;
	}
	public Vertex getParent() {
		return this.parent;
	}
	public void setParent(Vertex v) {
		this.parent = v;
	}
	
	public int compareTo(Object o) { 
		if(!(o instanceof Vertex)) {
			throw new ClassCastException();
		}
		Vertex v = (Vertex) o;
		if (this.getDist() > v.getDist()) {
			return 1;
		}else if(this.getDist() < v.getDist()) {
			return -1;
		}
			return 0;
	}
}
