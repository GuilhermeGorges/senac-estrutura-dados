package buscagrafo;

public class Main {
        public static void main(String[] args){
            Grafo g = new Grafo();
            g.adicVertice(″A″); // 0 (início)
            g.adicVertice(″B″); // 1
            g.adicVertice(″C″); // 2
            g.adicVertice(″D″); // 3
            g.adicVertice(″E″); // 4
            g.adicVertice(″F″); // 5
            g.adicVertice(″G″); // 6
            g.adicAresta(0, 1, 50); // AB 50
            g.adicAresta(0, 3, 80); // AD 80
            g.adicAresta(1, 2, 60); // BC 60
            g.adicAresta(1, 3, 90); // BD 90
            g.adicAresta(2, 4, 40); // CE 40
            g.adicAresta(3, 2, 20); // DC 20
            g.adicAresta(3, 4, 70); // DE 70
            g.adicAresta(4, 1, 50); // EB 50
            g.adicAresta(5, 6, 20); // FG 20
            System.out.println(″Menor Caminho″);
            g.menorCaminho();
            System.out.println();
        } // final main()
    } // final classe ExemploMenorCaminho