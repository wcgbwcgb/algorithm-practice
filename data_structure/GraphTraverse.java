package data_structure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import data_structure.MyGraph.Edge;

public class GraphTraverse {
	
	public static void graphDFSTraverse(MyGraph graph, int start) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visit = new HashSet<Integer>();
		stack.push(start);
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(!visit.contains(cur)) {
				visit.add(cur);
				System.out.print(cur+" ");
				List<Edge> list = graph.neighbors(cur);
				for(int i = list.size()-1;i>=0;i--) {
					if(!visit.contains(list.get(i).to)) {
						stack.push(list.get(i).to);
					}				
				}
			}
		}
	}
	
	public static void graphBFSTraverse(MyGraph graph, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visit = new HashSet<Integer>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(!visit.contains(cur)){
				visit.add(cur);
				System.out.print(cur+" ");
				List<Edge> list = graph.neighbors(cur);
				for(int i = 0;i<list.size();i++) {
					if(!visit.contains(list.get(i).to)) {
						queue.offer(list.get(i).to);
					}				
				}
			}
		}
	}

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(5);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 1);
		
		graphDFSTraverse(graph, 0);
		System.out.println();
		graphBFSTraverse(graph, 0);

	}

}
