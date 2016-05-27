import java.util.*;
public class MinmumDisInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public GraphNode findMinDistance(GraphNode[] graph) {
		//List<GraphNode> minNode;
		int minPath = Integer.MAX_VALUE;
		GraphNode minNode = null;
		
		for(GraphNode node : graph) {
			if(node.pass) {
				int distance = getDis(graph, node);
				if(minPath > distance ) {
					minPath = distance;
					minNode = node;
				}
			}
		}
		
		return minNode;
	}
	
	
	
	private int getDis(GraphNode[] graph, GraphNode node) {
		// TODO Auto-generated method stub
		int dis = 0;
		int n = graph.length;
		int[] distance = new int[n];
		int vcnt = 0;
		boolean[] visited = new boolean[n];
		
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(node);
		vcnt++;
		visited[node.label] = true;
		
		while(queue.isEmpty()) {
			GraphNode cur = queue.poll();
			for(GraphNode neigh : node.neighbors) {
				if(neigh.pass && !visited[neigh.label]) {
					queue.offer(neigh);
					visited[neigh.label] = true;
					vcnt++;
					distance[neigh.label] = distance[cur.label] + 1;
				}
			}
			
		}
		
		int sum = 0;
		for(int val : distance) {
			sum += val;
		}
		return vcnt == n ? sum : Integer.MAX_VALUE;
	}



	class GraphNode {
		 int label;
		 boolean pass;
		 List<GraphNode> neighbors;
		 GraphNode(int x) { label = x; neighbors = new ArrayList<GraphNode>(); pass = true;}
	};

}
