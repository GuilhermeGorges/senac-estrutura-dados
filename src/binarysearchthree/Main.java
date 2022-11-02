package binarysearchthree;

public class Main {
    public static void main(String[] args) {

        BinarySearchThree bst = new BinarySearchThree();
        bst.insertBST(88, "element");
        bst.insertBST(70, "element");
        bst.insertBST(75, "element");
        bst.insertBST(99, "element");
        bst.insertBST(110, "element");
        bst.insertBST(105, "element");
        bst.insertBST(119, "element");
        bst.insertBST(80, "element");
        bst.insertBST(67, "element");
        bst.insertBST(59, "element");
        bst.insertBST(72, "element");
        bst.insertBST(91, "element");
        bst.insertBST(90, "element");
        bst.insertBST(95, "element");
        bst.insertBST(69, "element");

        bst.insertBST(77, "Additional element");

        System.out.println("Print Three Elements by Pre Fixed");
        bst.printThreeElementsByPreFixed();

        System.out.println("\nPrint Three Elements by Post Fixed");
        bst.printThreeElementsByPostFixed();

        System.out.println("\nPrint Three Elements Symmetric Fixed");
        bst.printThreeElementsBySymFixed();
    }
}
