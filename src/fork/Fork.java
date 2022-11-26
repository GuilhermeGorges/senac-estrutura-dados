package fork;

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
        numVertex++;
        vertexList[numVertex] = new Vertex(label);
    }
    public void addEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
        }
    public void displayVertex(int v) {
    }
}
