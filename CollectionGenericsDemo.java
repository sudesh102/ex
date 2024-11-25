import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionGenericsDemo {
    public static void main(String[] args) {
        // Demonstration of ArrayList with Generics
        System.out.println("ArrayList Example:");
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Apple"); // Duplicate element

        System.out.println("Elements in ArrayList:");
        for (String fruit : stringList) {
            System.out.println(fruit);
        }

        // Demonstration of HashSet with Generics
        System.out.println("\nHashSet Example:");
        HashSet<Integer> numberSet = new HashSet<>();
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(30);
        numberSet.add(20); // Duplicate element

        System.out.println("Elements in HashSet (duplicates not allowed):");
        for (Integer number : numberSet) {
            System.out.println(number);
        }

        // Demonstration of HashMap with Generics
        System.out.println("\nHashMap Example:");
        HashMap<Integer, String> idNameMap = new HashMap<>();
        idNameMap.put(1, "John");
        idNameMap.put(2, "Alice");
        idNameMap.put(3, "Bob");

        System.out.println("Elements in HashMap:");
        for (Integer key : idNameMap.keySet()) {
            System.out.println("ID: " + key + ", Name: " + idNameMap.get(key));
        }

        // Demonstration of using Generics with a custom method
        System.out.println("\nGeneric Method Example:");
        printElements(stringList);
        printElements(numberSet);
    }

    // Generic method to print elements of a collection
    public static <T> void printElements(Iterable<T> collection) {
        System.out.println("Printing elements:");
        for (T element : collection) {
            System.out.println(element);
        }
    }
}
