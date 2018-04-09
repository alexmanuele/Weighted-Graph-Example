//Used to store weight/vertex tuples in adjacency lists.
public class Tuple {
	Tuple(Vertex v, int w){
		this.weight = w;
		this.vertex = v;
	}
	int weight;
	Vertex vertex;
	
	public Vertex getVertex() {
		return this.vertex;
	}
	public int getWeight() {
		return this.weight;
	}
	
}
