package dijkstra;

class Main {
    public static void main(String[] args){
        Fork f = new Fork();
        f.addVertex("A"); // 0 (início)
        f.addVertex("B"); // 1
        f.addVertex("C"); // 2
        f.addVertex("D"); // 3
        f.addVertex("E"); // 4
        f.addVertex("F"); // 5
        f.addVertex("G"); // 6
        f.addEdge(0, 1, 50); // AB 50
        f.addEdge(0, 3, 80); // AD 80
        f.addEdge(1, 2, 60); // BC 60
        f.addEdge(1, 3, 90); // BD 90
        f.addEdge(2, 4, 40); // CE 40
        f.addEdge(3, 2, 20); // DC 20
        f.addEdge(3, 4, 70); // DE 70
        f.addEdge(4, 1, 50); // EB 50
        f.addEdge(5, 6, 20); // FG 20
        System.out.println("Menor Caminho");
        f.menorCaminho();
        System.out.println();
    }
}