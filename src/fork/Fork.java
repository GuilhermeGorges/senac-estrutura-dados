package fork;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Fork {

    private final int MAX_VERTEX = 20;
        private Vertex vertexList[];
        private int matrix[][];
        private int numVertex;

    public Fork() {
        vertexList = new Vertex[MAX_VERTEX];
        matrix = new int[MAX_VERTEX][MAX_VERTEX];
        numVertex = 0;
        for(int y=0; y<MAX_VERTEX; y++) {
            for(int x=0; x<MAX_VERTEX; x++) {
                matrix[x][y] = 0;
            }
        }
    }

    public void addVertex(String label) {
        vertexList[numVertex] = new Vertex(label);
        numVertex++;
    }
    public void addEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    }
    public void showVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }
    public void depthFirstSearch() {
        Stack<Integer> stack = new Stack<>();
        vertexList[0].wasVisited();
        showVertex(0);
        stack.push(0);
        while( !stack.isEmpty() ) {
            int v = catchUnvisitedVertex( (int) stack.peek());
            if(v == -1) {
                stack.pop();
            }else{
                vertexList[v].wasVisited();
                showVertex(v);
                stack.push(v);
            }
        }
        for(int j=0; j<numVertex; j++){
            vertexList[j].wasNotVisited();
        }
    }
    private int catchUnvisitedVertex(int v) {
        for(int j=0; j<numVertex; j++) {
            if(matrix[v][j]==1 && !vertexList[j].getVisited()) {
                return j;
            }
        }
        return -1;
    }
}
