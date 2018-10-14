/**
 * Data-Structures-in-Java
 * Graph.java
 */
package graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Custom implementation of Graph Data Structure
 *
 * @author WissenSolutions
 */
public class Graph<T> {
    private static final Logger logger = LoggerFactory.getLogger(Graph.class);
    private Map<Node<T>,Node<T>> connectedComponents = new HashMap<>();

    public Node<T> addVertex(T data){
        Node<T> newNode = new Node<>(data);
        if(connectedComponents.containsKey(newNode)){
            throw new IllegalStateException("This node/vertex is already added");
        }
        connectedComponents.put(newNode,newNode);
        return newNode;

    }

    public void addEdge(T first, T second){
        Node<T> firstNode = findVertex(first);
        Node<T> secondNode = findVertex(second);
        //If the node is not added, First create node
        if(firstNode == null ){
            firstNode = addVertex(first);
        }
        if(secondNode == null ){
            secondNode = addVertex(second);
        }
        //Adding each node as mutually connected
        firstNode.connectedNodeList.add(secondNode);
        secondNode.connectedNodeList.add(firstNode);

    }

    public void addOneWayEdge(T first, T second){
        Node<T> firstNode = findVertex(first);
        Node<T> secondNode = findVertex(second);
        //If the node is not added, First create node
        if(firstNode == null ){
            firstNode = addVertex(first);
        }
        if(secondNode == null ){
            secondNode = addVertex(second);
        }

        firstNode.connectedNodeList.add(secondNode);


    }

    public void printGraph(){
        connectedComponents.keySet().forEach(iTVertex -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Vertex=").append(iTVertex);
            List<Node<T>> connectedNodes = iTVertex.connectedNodeList;
            sb.append("\n Connectors are : \n");

            connectedNodes.forEach(item-> sb.append(item).append(","));
            logger.info("{}",sb.toString());
        });
    }

    private Node<T> findVertex(T element){
       Node<T> nodeKey =  new Node<>(element);
       return connectedComponents.get(nodeKey);
    }

    public class Node<T>{
        private T data;
        private List<Node<T>> connectedNodeList;
        private boolean visited;

        public Node(T iData) {
            data = iData;
            connectedNodeList = new ArrayList<>();
        }

        @Override
        public boolean equals(Object other){
            if(other.getClass().isAssignableFrom(Node.class)){
                Node<T> otherNode = (Node<T>) other;
                if(this.data.equals(otherNode.data)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode(){
            return data.hashCode();
        }

        @Override
        public String toString() {
            return data.toString();
        }

        public List<Node<T>> getConnectedNodeList() {
            return connectedNodeList;
        }

        public T getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean iVisited) {
            visited = iVisited;
        }
    }
//    class Edge<T>{
//        private Node<T> firstNode;
//        private Node<T> secondNode;
//
//        public Edge(Node<T> iFirstNode, Node<T> iSecondNode) {
//            firstNode = iFirstNode;
//            secondNode = iSecondNode;
//        }
//
//        public void addEdge(Node<T> iFirstNode, Node<T> iSecondNode){
//            Edge<T> edge = new Edge<>(iFirstNode,iSecondNode);
//            iFirstNode.connectedNodeList.add(iSecondNode);
//            iSecondNode.connectedNodeList.add(iFirstNode);
//        }
//        @Override
//        public boolean equals(Object otherObject){
//            if(otherObject.getClass().isAssignableFrom(Edge.class)){
//                Edge<T> otherEdge = (Edge<T>) otherObject;
//                if(otherEdge.firstNode.equals(firstNode) && otherEdge.secondNode.equals(secondNode)){
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public int hashCode(){
//            return firstNode.hashCode()+secondNode.hashCode();
//        }
//    }
}