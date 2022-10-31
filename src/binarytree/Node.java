package binarytree;

public class Node {
    private long id;
    private Object element;
    private Node left;
    private Node right;
    public Node(long id, Object elemento, Node left, Node right)
    {
        this.id = id;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
    public void setId(long id) // método para alterar o identificador do nó
    {
        this.id = id;
    }
    public long getId() // método para receber o identificador do nó
    {
        return this.id;
    }
    public void setElemento(Object elemento) // método para alterar o elemento
    {
        this.elemento = elemento;
    }
    public Object getElemento() // método para receber o objeto contido no No
    {
        return elemento;
    }
    public void setEsq(No esq) // método que altera o filho esquerdo
    {
        this.esq = esq;
    }
    public No getEsq() // método que recebe o filho esquerdo do nó
    {
        return esq;
    }
    public void setDir(No dir) // método que altera o filho direito
    {
        this.dir = dir;
    }
    public No getDir() // método que recebe o filho direito do nó
    {
        return dir;
    }
}
