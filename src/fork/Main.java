package fork;

public class Main {
    public static void main(String[] args) {
        Fork f = new Fork();
        f.addVertex("A");
        f.addVertex("B");
        f.addVertex("C");
        f.addVertex("D");
        f.addEdge(0,1);
        f.addEdge(0,2);
        f.addEdge(0,3);
        f.addEdge(2,3);
    }
}
