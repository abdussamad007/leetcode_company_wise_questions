package DataStructures.Disjoint;

public class DisjSets {

    private int[] s;
    private final int DEFALUT_VALUE = -1;

    public DisjSets(int numElements) {
        s = new int[numElements];
        for (Integer item : s) {
            item = DEFALUT_VALUE;
        }
    }

    public int find(int index) {
        if (s[index] == DEFALUT_VALUE) {
            return index;
        }
        return find(s[index]);
    }
}
