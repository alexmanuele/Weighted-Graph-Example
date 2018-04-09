
public class debug {

	public static void main(String[] args) {
		RouteRecommender rr = new RouteRecommender();
		WeightedGraph g = new WeightedGraph();
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addEdge(a, b, 3);
		g.addEdge(b, c, 5);
		g.addEdge(b, d, 1);
		g.addEdge(c, d, 15);
        LinkedList L = rr.dijkstra(g, a, d);
        System.out.println("The size of the LL from dijkstra is " + L.size);
        for (int i = 0; i < L.size; i++) {
        	System.out.println(L.get(i).getName());
        }
	}

}
