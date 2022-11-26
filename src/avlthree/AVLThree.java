package avlthree;

public class AVLThree {

    private Node root;

    public void insertAVL(long id, Object elemento) {
        Node newNode = new Node(id,elemento,null,null);
        insert(root, newNode);
    }

    private void insert(Node current, Node newNode) {
        if (current == null) {
            this.root = newNode;
            return;
        }

        if (newNode.getId() < current.getId()) {
            if(current.getLeft() == null) {
                current.setLeft(newNode);
                newNode.setParent(current);
                evaluateBalancing(current);
            } else {
                insert(current.getLeft(),newNode);
            }
        } else {
            if (newNode.getId() > current.getId()) {
                if(current.getRight() == null) {
                    current.setRight(newNode);
                    newNode.setParent(current);
                    evaluateBalancing(current);
                } else {
                    insert(current.getLeft(),newNode);
                }
            } else {
                return;
            }
        }
    }

    private void evaluateBalancing(Node current) {
        calculateBalancing(current);
        long b = current.getB();
        if (b == -2) {
            if (height(current.getLeft().getLeft()) >= height(current.getLeft().getRight())) {
                current = rightRotation(current);
            }else{
                current = doubleRightRotation(current);
            }
        } else {
            if (b == 2) {
                if (height(current.getRight().getRight()) >= height(current.getRight().getLeft())) {
                    current = leftRotation(current);
                }else{
                    current = doubleLeftRotation(current);
                }
            }
        }
        if (current.getParent() != null) {
            evaluateBalancing(current.getParent());
        }else{
            this.root = current;
        }
    }

    private void calculateBalancing(Node node) {
        node.setB(height(node.getRight()) - height(node.getLeft()));
    }

    private long height(Node current) {
        if (current == null) {
            return -1;
        }
        if ((current.getLeft() == null) && (current.getRight() == null)) {
            return 0;
        } else {
            if (current.getLeft() == null) {
                return 1 + height(current.getRight());
            } else {
                if (current.getRight() == null) {
                    return 1 + height(current.getLeft());
                } else {
                    return 1 + Math.max(height(current.getLeft()), height(current.getRight()));
                }
            }
        }
    }

    private Node leftRotation(Node initial) {
        Node right = initial.getRight();
        right.setParent(initial.getParent());
        initial.setRight(right.getLeft());
        if (initial.getRight() != null) {
            initial.getRight().setParent(initial);
        }
        right.setLeft(initial);
        initial.setParent(right);
        if (right.getParent() != null) {
            if (right.getParent().getRight() == initial) {
                right.getParent().setRight(right);
            } else if (right.getParent().getLeft() == initial) {
                right.getParent().setLeft(right);
            }
        }
        calculateBalancing(initial);
        calculateBalancing(right);
        return right;
    }

    private Node rightRotation(Node initial) {
        Node left = initial.getLeft();
        left.setParent(initial.getParent());
        initial.setLeft(left.getRight());
        if (initial.getLeft() != null) {
            initial.getLeft().setParent(initial);
        }
        left.setRight(initial);
        initial.setParent(left);
        if (left.getParent() != null) {
            if (left.getParent().getRight() == initial) {
                left.getParent().setRight(left);
            } else if (left.getParent().getLeft() == initial) {
                left.getParent().setLeft(left);
            }
        }
        calculateBalancing(initial);
        calculateBalancing(left);
        return left;
    }

    private Node doubleRightRotation(Node initial)  {
        initial.setLeft(leftRotation(initial.getLeft()));
        return rightRotation(initial);
    }
    
    private Node doubleLeftRotation(Node initial)  {
        initial.setRight(rightRotation(initial.getRight()));
        return leftRotation(initial);
    }
}
