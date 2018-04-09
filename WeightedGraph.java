//I used the same implementation of Graph as I used in assignment5. I merely changed Vertex to store weights in the adjacency list
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class WeightedGraph {
	WeightedGraph(){
		vertices = new ConcurrentHashMap<String, Vertex>();
	}
	private ConcurrentHashMap<String, Vertex> vertices;
	

	public ConcurrentHashMap<String, Vertex> getVertices(){
		return this.vertices;
	}
	
	public void addVertex(Vertex v) {
		vertices.put(v.getName(), v);
	}
	
	
	
	public void addEdge(Vertex x, Vertex y, int weight) {
		x.getAdjacency().put(y.getName(), new Tuple(y, weight));
		y.getAdjacency().put(x.getName(), new Tuple(x, weight));
	}
	
	public void removeEdge(Vertex x, Vertex y) {
		x.getAdjacency().remove(y.getName());
		y.getAdjacency().remove(x.getName());
	}
	
	public void removeVertex(Vertex v) {
		Vertex temp;
		Set<String> keys = v.getAdjacency().keySet();
		for(String s: keys) {
			temp = v.getAdjacency().get(s).getVertex(); //iterates through every vertex in v adjacency list
			removeEdge(v, temp);	
			
		}
		this.vertices.remove(v.getName());
	}
	
	
}