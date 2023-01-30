package dijkstra;
class Fork {
    private final int MAX_VERTICES = 20;
    private final int INFINITO = 1000000;
    private Vertex vertexList[];
    private int matrix[][];
    private int numVertex;
    private int numFechados;
    private DistanciaEstimada menor[];
    private int verticeAtual;
    private int distParaAtual;

    public void addVertex(String label) {
        vertexList[numVertex] = new Vertex(label);
        numVertex++;
    }

    public void addEdge(int begin, int end, int weight) {
        matrix[begin][end] = weight;
        matrix[end][begin] = weight;
    }
    
    public Fork() {
        vertexList = new Vertex[MAX_VERTICES];
        matrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertex = 0;
        numFechados = 0;
        for (int y = 0; y < MAX_VERTICES; y++) {
            for (int x = 0; x < MAX_VERTICES; x++) {
                matrix[x][y] = INFINITO;
            }
        }
        menor = new DistanciaEstimada[MAX_VERTICES];
    }

    private int pegaMinimo() {
        int minimo = INFINITO;
        int indice = 0;
        for (int j=1;j<numVertex;j++) {
            if (!vertexList[j].getVisited() && menor[j].getDistancia()<minimo) {
                minimo = menor[j].getDistancia();
                indice = j;
            }
        }
        return indice;
    }

    private void ajustaMenor() {
        int coluna = 1;
        while (coluna < numVertex) {
            if (vertexList[coluna].getVisited()) {
                coluna++;
                continue;
            }
            int atualParaMargem = matrix[verticeAtual][coluna];
            int inicioParaMargem = distParaAtual+atualParaMargem;
            int menorDistancia = menor[coluna].getDistancia();
            if (inicioParaMargem < menorDistancia) {
                menor[coluna].setPaiVertice(verticeAtual);
                menor[coluna].setDistancia(inicioParaMargem);
            }
            coluna++;
        }
    }
    private void mostraMenor() {
        for(int j=0;j<numVertex;j++) {
            System.out.print(vertexList[j].getLabel() + "=");
            if (menor[j].getDistancia() == INFINITO) {
                System.out.print("inf");
            } else {
                System.out.print(menor[j].getDistancia());
            }
            String pai = (String) vertexList[menor[j].getPaiVertice()].getLabel();
            System.out.print("(" + pai + ") ");
        }
        System.out.println("");
    }

    public void menorCaminho() {
        int inicio = 0;
        vertexList[inicio].wasVisited();
        numFechados = 1;
        for (int j=0;j<=numVertex;j++) {
            int distancia = matrix[inicio][j];
            menor[j] = new DistanciaEstimada(inicio,distancia);
        }
        while( numFechados < numVertex ) {
            int indiceParaMinimo = pegaMinimo();
            int minimaDistancia = menor[indiceParaMinimo].getDistancia();
            if(minimaDistancia == INFINITO) {
                System.out.println("Existem vértices não endereçados");
                break;
            } else {
                verticeAtual = indiceParaMinimo;
                distParaAtual = menor[indiceParaMinimo].getDistancia();
            }
            vertexList[verticeAtual].wasVisited();
            numFechados++;
            ajustaMenor();
        }
        mostraMenor();
        numFechados = 0;
        for(int j=0; j<numVertex; j++) {
            vertexList[j].wasNotVisited();
        }
    }

}