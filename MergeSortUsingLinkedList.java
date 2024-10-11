import java.io.File;
import java.util.Scanner;

public class MergeSortUsingLinkedList {

    private Node head = null;
    private int size;

    MergeSortUsingLinkedList() {
        this.size = 0;
    }

    /// create Node class
    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
            size++;
        }

    }

    /// Value add in linked list end point
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node currNode = head;

            while (currNode.link != null) {
                currNode = currNode.link;
            }
            currNode.link = newNode;

        }
    }

    /// Value get from linked list index wise
    public int get(int data) {
        if (data == 0) {
            return head.data;
        } else {
            int n = 0;
            Node current = head;
            while (n < data) {
                current = current.link;
                n++;
            }
            return current.data;
        }
    }

    /// Value set in linked list index wise
    public void set(int index, int data) {

        if (index == 0) {
            Node Update = head;
            Update.data = data;
        } else {
            int n = 0;
            Node ptr = head;
            Node ptr1 = head;

            while (n < index) {
                ptr = ptr1;
                ptr1 = ptr.link;
                n++;
            }
            ptr1.data = data;

        }
    }

    // Merge Sorting method
    public static void mergeSort(MergeSortUsingLinkedList list, int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;

            mergeSort(list, s, mid);
            mergeSort(list, mid + 1, e);

            merge(list, s, mid, e);
        }

    }

    // Merge Method
    public static void merge(MergeSortUsingLinkedList list, int s, int mid, int e) {
        int l = mid - s + 1;
        int r = e - mid;

        MergeSortUsingLinkedList list1 = new MergeSortUsingLinkedList();
        MergeSortUsingLinkedList list2 = new MergeSortUsingLinkedList();

        /// Copy value in List1
        int k = s;
        for (int i = 0; i < l; i++) {
            list1.add(list.get(k));
            k++;
        }

        /// Copy Value in List 2
        k = mid + 1;
        for (int j = 0; j < r; j++) {
            list2.add(list.get(k));
            k++;
        }

        int i = 0;
        int j = 0;
        k = s;

        /// Merge Linked list and Sorting Data
        while (i < l && j < r) {
            if (list1.get(i) < list2.get(j)) {
                list.set(k, list1.get(i));
                i++;
            } else {
                list.set(k, list2.get(j));
                j++;
            }
            k++;
        }

        while (i < l) {
            list.set(k, list1.get(i));
            k++;
            i++;
        }

        while (j < r) {
            list.set(k, list2.get(j));
            k++;
            j++;
        }

    }

    /// MAIN METHOD
    public static void main(String[] args) {
        MergeSortUsingLinkedList list = new MergeSortUsingLinkedList();

        // Read From Text File
        try {
            File file = new File(
                    "E:/Engineering/Coding/JAVA CODE/Repeat Practice/Linked List in Java/LinkedList/input.txt");

            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                int num = Integer.parseInt(input.next());

                list.add(num);
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        System.err.println();
        System.out.print("After Apply merge sort: ");

        Node curr = list.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.link;
        }
        System.out.println();
        System.out.println();

        mergeSort(list, 0, list.size - 1);

        System.out.print("Before Apply merge sort: ");

        Node ptr = list.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.link;
        }

        System.out.println();
        System.out.println();
    }
}
