package pti;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(555, "555");
        binaryTree.insert(333, "333");
        binaryTree.insert(111, "111");
        binaryTree.insert(444, "444");
        binaryTree.insert(888, "888");
        binaryTree.insert(999, "999");

        System.out.println("Left size: " + binaryTree.getLeftCount());
        System.out.println("Right size: " + binaryTree.getRightCount());

        System.out.println("\nPrint Three Elements By Depth");
        binaryTree.printThreeElementsByIndentingByDepth();

        binaryTree.printTree();
    }
}
