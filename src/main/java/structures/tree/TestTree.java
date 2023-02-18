package structures.tree;

import java.util.List;

public class TestTree {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("8"));

        list.add("16");
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("16"));
        list.add("17");
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("17"));

        list.add("18");
        list.add("19");
        list.add("20");
        list.add("21");
        System.out.println("The expected parent is 10. The actual parent is " + ((CustomTree) list).getParent("18"));
        System.out.println("The expected parent is 11. The actual parent is " + ((CustomTree) list).getParent("21"));

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTree) list).getParent("20"));
        list.remove("1");
        System.out.println("The expected parent is root. The actual parent is " + ((CustomTree) list).getParent("2"));
        System.out.println("Expected: true. Actual: " + list.add("30"));
        System.out.println("The expected parent is 2. The actual parent is " + ((CustomTree) list).getParent("30"));
        list.remove("2");
        System.out.println("Expected: true. Actual: " + list.add("30"));
        System.out.println("The expected parent is root. The actual parent is " + ((CustomTree) list).getParent("30"));

    }
}
