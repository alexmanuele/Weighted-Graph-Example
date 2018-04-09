import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.PriorityQueue; //The Oracle library Priority Queue implements a heap-based PQ
public class RouteRecommender implements Tester {

	RouteRecommender(){};
	
	public ArrayList<String> compute(Scanner log) {
		
		return null;
	}
	public LinkedList dijkstra(WeightedGraph G, Vertex start, Vertex end){
		shortestPath(G, start);
		LinkedList L = new LinkedList();
		while( end != null) {
			L.prepend(end);
			end = end.getParent();
		}
		return L;
	}
	private void shortestPath(WeightedGraph G, Vertex start) {
		//note that the dist value of each vertex is initialized to MAX_INT so does not need to be changed here
		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>(); //Vertex implements comparable and compares by dist
		start.setDist(0);
		Vertex u; //the placeholder vertex for logic below
		int distance; //used in for loop
		PQ.add(start); //enqueue the starting vertex
		
		while(PQ.size() > 0) {
			u = PQ.poll(); //this is the equivalent to getMin() as seen in Lecture 27
			if (u.isVisited()) {
				continue;
			}
			u.visit(); //sets u to visited
			Set<String> keys = u.getAdjacency().keySet();
			for(String s: keys) { //s is the key from the list of keys in the adjacency list of u
				Vertex w = G.getVertices().get(s); //every vertex in u's adjacency list is also in G's vertex list with the same key.
				distance = u.getDist() + u.getAdjacency().get(s).getWeight(); //u.dist + weight(u,w)
				if( w.getDist() > distance) {
					w.setDist(distance);
					w.setParent(u);
					PQ.add(w); //because Vertex implements Comparable and uses dist as comparator, only need to pass w into add()
				}
			}
		}
	}
}
