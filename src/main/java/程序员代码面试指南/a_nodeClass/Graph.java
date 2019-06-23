package 程序员代码面试指南.a_nodeClass;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-15 10:53
 **/
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public static Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        if (matrix == null || matrix.length == 0){
            return graph;
        }
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int len = matrix[0].length;
            int weight = len == 3 ? matrix[i][2] : 1;
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(fromNode,toNode,weight);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            fromNode.edges.add(newEdge);
            toNode.in++;
            graph.edges.add(newEdge);
        }
        return graph;
    }

    private static class Node{
        int value;
        int in;
        int out;
        ArrayList<Edge> edges;
        ArrayList<Node> nexts;

        public Node(int value){
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.edges = new ArrayList<>();
            this.nexts = new ArrayList<>();
        }
    }

    private static class Edge{
        Node from;
        Node to;
        int weight;

        public Edge(Node from,Node to,int weight){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        public Edge(Node from,Node to){
            this(from,to,1);
        }
    }
}
