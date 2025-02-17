package prep2024.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * We have a search engine that spreads requests out to N handlers. Each handler returns a sorted list of
 *  results with consistent sorting rules used by each handler. Write an algorithm that merges all sorted
 * lists into a single list.
> Ex. I/O: merge(iterators) -> ["A", "B", "C", "D"]
 */
public class MergeIterator {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "C", "E");
        List<String> list2 = Arrays.asList("B", "D", "F");
        List<String> list3 = Arrays.asList("G", "H", "I");

        List<Iterator<String>> iterators = new ArrayList<>();
        iterators.add(list1.iterator());
        iterators.add(list2.iterator());
        iterators.add(list3.iterator());

        List<String> merged = merge(iterators);
        System.out.println(merged); // Output: [A, B, C, D, E, F, G, H, I]
    }

    public static List<String> merge(List<Iterator<String>> iterators) {
        List<String> merged = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (int i = 0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext()) {
                Node node = new Node(iterators.get(i).next(), i);
                minHeap.offer(node);
            }
        }
        System.out.println(minHeap);

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            merged.add(node.getValue());
            System.out.println("value :" + node.getValue());
            System.out.println("index :" + node.getIndex());
            if (iterators.get(node.getIndex()).hasNext()) {
                minHeap.offer(new Node(iterators.get(node.getIndex()).next(), node.getIndex()));
            }
        }

        // System.out.println(merged);

        return merged;
    }

}

class Node implements Comparable<Node> {

    String value;
    int index;

    @Override
    public int compareTo(Node other) {
        return this.value.compareTo(other.value);
    }

    public Node(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
