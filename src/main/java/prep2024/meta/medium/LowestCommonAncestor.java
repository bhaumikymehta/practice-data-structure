package prep2024.meta.medium;

import java.util.HashSet;
import java.util.Set;

//Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class LowestCommonAncestor {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null)
            return null;
        Node startP = p;
        Node startQ = q;

        Set<Node> set = new HashSet<>();
        while (startP.parent != null) {
            set.add(startP);
            startP = startP.parent;
        }

        while (startQ.parent != null) {
            if (set.contains(startQ)) {
                return startQ;
            }

            startQ = startQ.parent;
        }
        return startQ;

    }
}
