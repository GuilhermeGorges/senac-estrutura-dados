package buscagrafo;

class Grafo // implementação da classe Grafo
{
    private final int MAX_VERTICES = 20; // número máximo de vértices
    private final int INFINITO = 1000000; // número muito grande
    private Vertice listaVertice[]; // lista de vértices
    private int matriz[][]; // matriz adjacente
    private int numVertices; // número atual de vértices
    private int numFechados; // número de vértices com distância fechada
    private DistanciaEstimada menor[]; // vetor com o caminho mais curto
    private int verticeAtual; // vértice atual
    private int distParaAtual; // distância para o vértice atual

    public Grafo() { // construtor da clase Grafo
        listaVertice = new Vertice[MAX_VERTICES]; // cria a lista de vértices
        matriz = new int[MAX_VERTICES][MAX_VERTICES]; // cria a matriz adjacente
        numVertices = 0; // inicia número de vértices como 0
        numFechados = 0; // inicia com nenhum vértice fechado
        for (int y = 0; y < MAX_VERTICES; y++) { // inicia matriz com valor infinito
            for (int x = 0; x < MAX_VERTICES; x++) {
                matriz[x][y] = INFINITO;
            }
        }
        menor = new DistanciaEstimada[MAX_VERTICES];
    }
    private int pegaMinimo() { // pega o índice com a menor distância
        int minimo = INFINITO; // inicia o mínimo
        int indice = 0;
        for (int j=1;j<numVertices;j++) { // acessa cada vértice
            if (!listaVertice[j].getVisitado() && menor[j].getDistancia()<minimo)

            {
// se for menor que o anterior, marca como menor
                minimo = menor[j].getDistancia();
                indice = j;
            }
        }
        return indice;
    } // final pegaMinimo
    private void ajustaMenor() { // ajusta o vetor com os caminhos mais curtos
        int coluna = 1; // pula o vértice inicial
        while (coluna < numVertices) { // percorre as colunas
            if (listaVertice[coluna].getVisitado()) {
// se vértice já está fechado, pula a coluna
                coluna++;
                continue;
            }
// calcula a distância para uma entrada de menor[]
            int atualParaMargem = matriz[verticeAtual][coluna];
            int inicioParaMargem = distParaAtual+atualParaMargem;
            int menorDistancia = menor[coluna].getDistancia();
            if (inicioParaMargem < menorDistancia) {
                menor[coluna].setPaiVertice(verticeAtual);
                menor[coluna].setDistancia(inicioParaMargem);
            }
            coluna++;
        }
    } // final ajustaMenor
    private void mostraMenor() { // mostra o menor caminho encontrado
        for(int j=0;j<numVertices;j++) { // mostra o conteúdo de menor[]
            System.out.print(listaVertice[j].getRotulo() + ″=″);
            if (menor[j].getDistancia() == INFINITO) {
                System.out.print(″inf″);
            }else{
                System.out.print(menor[j].getDistancia());
            }
            String pai = (String) listaVertice[menor[j].getPaiVertice()].
                    getRotulo()
            System.out.print(″(″ + pai + ″) ″);
        }
        System.out.println(″″);
    } // final mostraMenor
    public void menorCaminho() { // encontra o menor caminho
        int inicio = 0; // começa pelo vértice 0
        listaVertice[inicio].foiVisitado(); // primeiro vértice marcado como fechado
        numFechados = 1; // inclui o vértice inicial como fechado
        for(int j=0;j<=numVertices;j++) { // transfere as distâncias para o vetor menor
// distância armazenada na matriz de adjacências
            int distancia = matriz[inicio][j];
// pai recebe inicio=0 e a distância
            menor[j] = new DistanciaEstimada(inicio,distancia);
        }
        while( numFechados < numVertices ) { // até que todos os vértices estejam fechados
// sempre trata o mínimo do vetor menor
            int indiceParaMinimo = pegaMinimo();
// pega a distância mínima
            int minimaDistancia = menor[indiceParaMinimo].getDistancia();
            if(minimaDistancia == INFINITO) { // existe vértice não encontrado
// só ocorre quando todos os vértices alcançáveis são fechados
// e ainda existem vértices
                System.out.println(″Existem vértices não endereçados″);
                break; // termina o loop while
            } else { // vai redefinir o verticeAtual
// passa a ser o vértice mais próximo a ser fechado
                verticeAtual = indiceParaMinimo;
                distParaAtual = menor[indiceParaMinimo].getDistancia(); // distância mínima
            }
            listaVertice[verticeAtual].foiVisitado(); // marca vértice atual como fechado
            numFechados++; // incrementa o número de vértices fechados
            ajustaMenor();
        }
        mostraMenor(); // mostra o conteúdo de menor[]
        numFechados = 0;
// limpa o número de vértices fechados para a próxima busca
        for(int j=0; j<numVertices; j++) // reset flags
            listaVertice[j].naoFoiVisitado();
    } // final método menorCaminho


}