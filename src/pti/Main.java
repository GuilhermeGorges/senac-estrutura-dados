package pti;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(555, "H");
        binaryTree.insert(333, "J");
        binaryTree.insert(111, "D");
        binaryTree.insert(444, "J");
        binaryTree.insert(888, "E");
        binaryTree.insert(999, "C");



        System.out.println("Left size: " + binaryTree.getLeftCount());

        System.out.println("Right size: " + binaryTree.getRightCount());

        System.out.println("\nPrint Three Elements By Depth");
        binaryTree.printThreeElementsByIndentingByDepth();

    }
}
