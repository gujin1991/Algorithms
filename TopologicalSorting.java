package July22th;
import java.util.*;

public class TopologicalSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<DirectedGraphNode> topSortDFS(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> sortedNodes = new ArrayList<>();
        int len = graph.size();
        boolean[] visited = new boolean[len];
        
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                find(graph.get(i), visited, sortedNodes);
            }
        }
    
        return sortedNodes;
        
    }
    
    void find(DirectedGraphNode node, boolean visited[], ArrayList<DirectedGraphNode> sortedNodes)
    {
        visited[node.label] = true;

        for(DirectedGraphNode neigh : node.neighbors) {
            if(!visited[neigh.label]) {
                find(neigh, visited, sortedNodes);
            }
        }
 
        // Push current vertex to stack which stores result
        sortedNodes.add(0, node);
    }
	
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> sortedNodes = new ArrayList<>();
        int len = graph.size();
        int[] degree = new int[len];
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neigh : node.neighbors) {
                degree[neigh.label]++;
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(degree[i] == 0) {
                queue.offer(graph.get(i));
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                DirectedGraphNode cur = queue.poll();
                sortedNodes.add(cur);
                
                for(DirectedGraphNode neigh : cur.neighbors) {
                    degree[neigh.label]--;
                    if(degree[neigh.label] == 0) {
                        queue.offer(graph.get(neigh.label));
                    }
                }
            }
        }
        
        return sortedNodes;
        
    }
	
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	};

}
