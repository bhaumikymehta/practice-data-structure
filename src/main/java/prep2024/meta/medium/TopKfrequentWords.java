package prep2024.meta.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKfrequentWords {

    public static String[] topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        List<String> candidates = new ArrayList<>(map.keySet());
        System.out.println(candidates);

        Collections.sort(candidates,
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        System.out.println(candidates.subList(0, k));
        // return candidates.subList(0, k);
        PriorityQueue<String> queue = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2))
                        ? w2.compareTo(w1)
                        : map.get(w1) - map.get(w2));

        for (String s : map.keySet()) {
            queue.add(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        System.out.println("queue:" + queue);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);

        System.out.println("res:" + res);
        return (String[]) res.toArray();
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        String[] result = topKFrequent(words, k);
        System.out.println(result);
    }

}
