package avlthree;

import binarytree.Node;

public class AVLThree {

    private Node root;

    public AVLThree() {
        this.root = null;
    }

    public void insertBST(long id, Object element) {
        if (this.root == null) {
            this.root = new Node(id, element,null,null);
        } else {
            Node newNode = new Node(id, element, null,null);
            insert(this.root, newNode);
        }
    }

    public Node bstSearch(long id) {
        return search(this.root, id);
    }

    public void printThreeElementsByPreFixed() {
        preFixed(this.root);
    }

    public void printThreeElementsByPostFixed() {
        postFixed(this.root);
    }

    public void printThreeElementsBySymFixed() {
        symFixed(this.root);
    }

    public boolean bstRemove(long id) {
        Node current = this.root;
        Node parent = this.root;
        boolean leftSon = true;

        while (current.getId() != id) {
            parent = current;

            if (id < current.getId()) {
                leftSon = true;
                current = current.getLeft();
            } else {
                leftSon = false;
                current = current.getRight();
            }

            if (current == null) {
                return false;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == this.root) {
                this.root = null;
            } else {
                if (leftSon) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        } else {
            if (current.getRight() == null) {
                if (current == this.root) {
                    this.root = current.getLeft();
                } else {
                    if (leftSon) {
                        parent.setLeft(current.getLeft());
                    } else {
                        parent.setRight(current.getLeft());
                    }
                }
            } else {
                if (current.getLeft() == null) {
                    if (current == this.root) {
                        this.root = current.getRight();
                    } else {
                        if (leftSon) {
                            parent.setLeft(current.getRight());
                        } else {
                            parent.setRight(current.getRight());
                        }
                    }
                } else {
                    Node successor = getSucessor(current);
                    if (current == this.root) {
                        this.root = successor;
                    } else {
                        if (leftSon) {
                            parent.setLeft(successor);
                        } else {
                            parent.setRight(successor);
                        }
                    }
                    successor.setLeft(current.getLeft());
                }
            }
        }
        return true;
    }

    private Node getSucessor(Node eliminate) {
        Node successorParent = eliminate;
        Node successor = eliminate;
        Node current = eliminate.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != eliminate.getRight()) {
        }
        return successor;
    }

    private void insert(Node current, Node newNode) {
        if (current.getId() == newNode.getId()) {
        }

        if (newNode.getId() < current.getId()) {
            if(current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insert(current.getLeft(), newNode);
            }
        }

        if (newNode.getId() > current.getId()) {
            if(current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insert(current.getRight(), newNode);
            }
        }
    }

    private Node search(Node current, long id) {
        if (current == null) {
            return null;
        } else {
            if (id == current.getId()) {
                return current;
            } else {
                if (id < current.getId()) {
                    return search(current.getLeft(), id);
                } else {
                    return search(current.getRight(), id);
                }
            }
        }
    }

    private void preFixed(Node current) {
        if (current != null) {
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
            preFixed(current.getLeft());
            preFixed(current.getRight());
        }
    }

    private void postFixed(Node current) {
        if (current != null) {
            postFixed(current.getLeft());
            postFixed(current.getRight());
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
        }
    }

    private void symFixed(Node current) {
        if (current != null) {
            symFixed(current.getLeft());
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
            symFixed(current.getRight());
        }
    }
}
