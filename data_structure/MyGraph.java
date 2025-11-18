package data_structure;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {
	
	private static class Edge{
		int to;
		int weight;
		
		private Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	int[][] matrix;
	
	// n is the number of node
	public MyGraph(int n) {
		matrix = new int[n][n];
	}
	
    public void addEdge(int from, int to, int weight) {
    	matrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
    	matrix[from][to] = 0;
    }

    // 判断两个节点是否相邻
    public boolean hasEdge(int from, int to) {
    	return matrix[from][to] != 0;
    }

    // 返回一条边的权重
    public int weight(int from, int to) {
    	return matrix[from][to];
    }

    // 返回某个节点的所有邻居节点和对应权重
    public List<Edge> neighbors(int v){
    	List<Edge> res = new ArrayList<>();
    	for(int i = 0;i<matrix[v].length;i++) {
    		if(matrix[v][i] != 0) {
    			res.add(new Edge(i, matrix[v][i]));
    		}
    	}
    	return res;
    }
    
    
    public static void main(String[] args) {
    	/*
    	 
    	*/
    	
		MyGraph graph = new MyGraph(5);
		graph.addEdge(0, 1, 100);
		graph.addEdge(0, 2, 700);
		graph.addEdge(0, 4, 20);
		graph.addEdge(3, 1, 800);
		graph.addEdge(1, 0, 3);
		
		for(Edge node:graph.neighbors(0)) {
			System.out.println("neighbor:"+node.to+" weight:"+node.weight);
		}
		
		System.out.println(graph.hasEdge(3, 1)+" "+graph.weight(3, 1));
		graph.removeEdge(3, 1);
		System.out.println(graph.hasEdge(3, 1)+" "+graph.weight(3, 1));
	}

}
