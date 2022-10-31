package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private No mainNode;
    private long length;



    public LinkedList() {
        this.mainNode = null;
        this.length = 0;
    }

    public void addFirst(final Object element) {
        No newNode = new No(element, null);
        newNode.setProximo(this.mainNode);
        this.mainNode = newNode;
        this.length++;
    }

    public Object removeFirst() {
        if (this.isEmpty()) {
            return false;
        }

        No mainNodeCopy = this.mainNode;
        this.mainNode = mainNodeCopy.getProximo();
        this.length--;
        return mainNodeCopy.getElemento();
    }

    public boolean isEmpty() {
        return mainNode == null;
    }

    @Override
    public String toString() {
        return "LinkedList {" +
                " mainNodeElement= " + mainNode.getElemento() +
                '}';
    }

    public List<Object> showList() {
        No mainNodeCopy = this.mainNode;
        List<Object> nodeList = new ArrayList<>();

        while (mainNodeCopy != null) {
            nodeList.add(mainNodeCopy.getElemento());
            mainNodeCopy = mainNodeCopy.getProximo();
        }
        return nodeList;
    }

    public void clearList() {
        while (this.mainNode != null) {
            this.mainNode = this.mainNode.getProximo();
            this.length--;
        }
    }

    public Object findByIndex(long index) {
        if (this.isEmpty() || index > this.length) {
            return null;
        }

        No mainNodeCopy = this.mainNode;

        while ((index > 0) && (mainNodeCopy != null)) {
            if (index == 1) {
                return mainNodeCopy.getElemento();
            }
            index--;
            mainNodeCopy = mainNodeCopy.getProximo();
        }
        return null;
    }

}
