import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph<T> {

	private Map<T, Node<T>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<>();
	}


	public void addVertex(T vertex) {
		if (adjacencyList.containsKey(vertex) == false) {
			adjacencyList.put(vertex, new Node<>(vertex));
		}
		
	}


	public void addEdge(T vertex1, T vertex2) {
		
//		if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
//			throw new RuntimeException("Vertex does not exist");
//		}
		if (!containsVertex(vertex1)) {
			addVertex(vertex1);
		}
		if (!containsVertex(vertex2)) {
			addVertex(vertex2);
		}

		// add the edge
		Node<T> node1 = getNode(vertex1);
		Node<T> node2 = getNode(vertex2);
		node1.addEdge(node2);
		node2.addEdge(node1);
	}



	public void removeEdge(T vertex1, T vertex2) {
		if (containsVertex(vertex1) || containsVertex(vertex2)) {
			getNode(vertex1).removeEdge(getNode(vertex2));
			getNode(vertex2).removeEdge(getNode(vertex1));
		}    
	}


	public boolean containsVertex(T vertex) {
		return adjacencyList.containsKey(vertex);
	}


	public boolean runBFS(T startVertex, T endVertex) {
		if (!containsVertex(startVertex)) {
			throw new RuntimeException("Start Vertex you specified does not exist.");
		}

		resetGraph();

		// Queue Initialization
		Queue<Node<T>> queue = new LinkedList<>();
		Node<T> start = getNode(startVertex);
		queue.add(start);

		// explore the graph
		while (!queue.isEmpty()) {
			Node<T> first = queue.remove();
			first.setVisited(true);
			first.edges().forEach(edge -> {
				Node<T> neighbour = edge.toNode();
				if (!neighbour.isVisited()) {
					queue.add(neighbour);
				}
			});
		}

		Node<T> end = getNode(endVertex);

		if (end.isVisited()){
			return true;
		}else{
			return false;
		}
	}


	private Node<T> getNode(T value) {
		return adjacencyList.get(value);
	}

	private void resetGraph() {
		adjacencyList.keySet().forEach(key -> {
			Node<T> node = getNode(key);
			node.setVisited(false);
		});
	}
}