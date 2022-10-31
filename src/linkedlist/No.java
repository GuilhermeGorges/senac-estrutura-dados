package linkedlist;

public class No {

    private No proximo;
    private Object elemento;

    public No(Object elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
}
