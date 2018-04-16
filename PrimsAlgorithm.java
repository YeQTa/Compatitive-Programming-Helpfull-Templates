import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

	// Dügümleri temsil eden class yapimiz
	static class Vertex{
		List<Edge> neighbours;
		
		public Vertex() {
			neighbours = new ArrayList<>();
		}
	}
	
	// Kenarlari temsil eden class yapimiz
	static class Edge implements Comparable<Edge>{
		
		//Edge in nereye gittigini temsil ediyor
		int to;
		
		//Edge in agirligini temsil ediyor
		int weight;
		
		
		public Edge(int to,int weight) {
			this.to = to;
			this.weight = weight;
		}

		/**
		 *  Oncelikli Sirada(PriorityQueue) agirligi dusuk olani vermesi icin
		 *  Comparable arayuzu implement edildi ve compareTo methodu Override edildi.
		 */
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static int runPrimsAlgorithm(Vertex[] graph, int numOfVertex, int source) {
		
		boolean[] visited = new boolean[numOfVertex];
		
		//baslangic noktasi visited olarak isaretlendi
		visited[source] = true;
		
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
		
		// Baslangic dugumun kenarlari(edgeleri) priority queue ya eklenir
		for(Edge e : graph[source].neighbours)
			priorityQueue.add(e);
		
		// minimumCost degiskenimiz tum dugumleri gezmemiz icin gereken minimum agirligi tutacak
		int minimumCost = 0;
		
		while(!priorityQueue.isEmpty()) {
			//priorityqueue dan agirligi en dusuk olan kenar alinir
			Edge edge = priorityQueue.poll();
		
			/**
			 * eger bu aldigimiz kenarin gittigi dugum onceden ziyaret edildiyse,
			 * bu dugum icin herhangi bir islem yapmamize gerek yok.
			 */
			if(visited[edge.to])
				continue;
			
			// eger ziyaret edilmediyse,bu kenar ziyaret edildi olarak isaretlenir.
			visited[edge.to] = true;
			
			// bu kenar ilk defa ziyaret edildigi icin agirligi minimumCost degiskenine eklenir
			minimumCost += edge.weight;
			
			// bu kenarin gittigi dugumun kenarlari priorityqueue ya eklenir
			for(Edge childEdge : graph[edge.to].neighbours)
				priorityQueue.add(childEdge);
			
		}
		return minimumCost;
	}
	
	
	// ORNEK INPUT EKLENDI
	public static void main(String[] args) {
		
		final int numOfVertex = 5;
		final int source = 0;
		
		Vertex[] graph = new Vertex[numOfVertex];
		
		// Dugumler yaratildi
		for(int i = 0; i<numOfVertex;i++)
			graph[i] = new Vertex();
		
		// Ornek kenarlar(edges) eklendi
		graph[0].neighbours.add(new Edge(1, 3));
		graph[1].neighbours.add(new Edge(0,3));
		
		graph[0].neighbours.add(new Edge(2,4));
		graph[2].neighbours.add(new Edge(0,4));
		
		graph[3].neighbours.add(new Edge(1,6));
		graph[1].neighbours.add(new Edge(3,6));
		
		graph[4].neighbours.add(new Edge(1,2));
		graph[1].neighbours.add(new Edge(4,2));
		
		graph[1].neighbours.add(new Edge(2,5));
		graph[2].neighbours.add(new Edge(1,5));
		
		graph[2].neighbours.add(new Edge(4,7));
		graph[4].neighbours.add(new Edge(2,7));
	
		System.out.println(runPrimsAlgorithm(graph, numOfVertex, source));
	}

}
