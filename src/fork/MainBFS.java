package fork;

public class MainBFS {
    public static void main(String[] args) {
        Fork f = new Fork();
        f.addVertex("A");
        f.addVertex("B");
        f.addVertex("C");
        f.addVertex("D");
        f.addVertex("E");
        f.addVertex("F");
        f.addVertex("G");
        f.addEdge(0,1);
        f.addEdge(0,2);
        f.addEdge(0,3);
        f.addEdge(1,4);
        f.addEdge(4,6);
        f.addEdge(2,5);
        f.addEdge(2,3);

        System.out.print("BFS - Vertices visitados: ");
        f.breadthFirstSearch();
        System.out.println();
        f.printEdgeMatrix();
    }
}
