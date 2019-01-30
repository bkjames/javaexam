package ama01;
import java.util.*;

public class A09_CopyListWithRandomPointer {

    
    public RandomLinkedList copy (RandomLinkedList head) {
        if (head == null) {
            return null;
        }
        Map<RandomLinkedList, RandomLinkedList> map = new HashMap<RandomLinkedList, RandomLinkedList>();
        RandomLinkedList p = head;
        RandomLinkedList cloneNode = new RandomLinkedList(head.value);
        map.put(head, cloneNode);
        while (p != null) {
            if (p.next != null) {
                if (map.containsKey(p.next)) {
                    cloneNode.next = map.get(p.next);
                } else {
                    RandomLinkedList newNode = new RandomLinkedList(p.next.value);
                    map.put(p.next, newNode);
                    cloneNode.next = newNode;
                }
            }
            if (p.random != null) {
                if (map.containsKey(p.random)) {
                    cloneNode.random = map.get(p.random);
                } else {
                    RandomLinkedList newNode = new RandomLinkedList(p.random.value);
                    map.put(p.random, newNode);
                    cloneNode.next = newNode;}
            }
            p = p.next;
            cloneNode = cloneNode.next;
        }
        return map.get(head);
    }

    private static RandomLinkedList createList (int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        RandomLinkedList head = new RandomLinkedList(arr[0]);
        RandomLinkedList last = head;
        List<RandomLinkedList> list = new ArrayList<RandomLinkedList>(arr.length);
        list.add(last);
        for (int i = 1; i < arr.length; i++) {
            RandomLinkedList node = new RandomLinkedList(arr[i]);
            last.next = node;
            last = node;
            list.add(node);
        }

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int rand = Math.abs(random.nextInt()) % (arr.length+1);
            if (rand != arr.length) {
                list.get(i).random = list.get(rand);
            }
        }
        return head;
    }

    private static void print (RandomLinkedList head) {
        List<Integer> values = new ArrayList<Integer>();
        List<String> list = new ArrayList<String>();
        while (head != null) {
            values.add(head.value);
            if (head.random != null) {
                list.add(head.value + " ---> " + head.random.value);
            }
            head = head.next;
        }
        list.add(0, Arrays.toString(values.toArray(new Integer[values.size()])));

        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
        System.out.println();
    }


    private static class RandomLinkedList {
        int value;
        RandomLinkedList random;
        RandomLinkedList next;

        public RandomLinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        A09_CopyListWithRandomPointer copyListWithRandomList = new A09_CopyListWithRandomPointer();
        int[] arr = new int[]{1,2,3};
        RandomLinkedList head = createList(arr);
        print(head);
        print(copyListWithRandomList.copy(head));
    }
}