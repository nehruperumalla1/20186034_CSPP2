import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author     : Nehru Perumalla.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    //
    /**
     * Set Integer Array.
     */
    private int[] set;
    /**
     * { Size Variable }.
     */
    private int size;
    /**
     * TEN Integer Variable.
     */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    Set() {
        set = new int[TEN];
        size = 0;
    }
    /**
     * { Contains Method }.
     *
     * @param      item  The item
     *
     * @return     { Returns Boolean }
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "{";
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                str += set[i] + ", ";
            }
            str += set[size - 1];
        }
        str += "}";
        return str;
    }

    public int max() {
        int max =set[0];
        for (int i = 0; i < size; i++) {
            if(max < set[i]) {
                max = set[i];
            }
        }
        return max;
    }
    /**
     * { Add Method }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!(contains(item))) {
            if (size >= set.length) {
                resize();
            }
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    if (set[i] < item && set[i+1] > item) {
                        add(i+1, item);
                        break;
                    } else if (item > max()) {
                        add(size, item);
                        break;
                    } else {
                        add(0, item);
                        break;
                    }
                }
            } else {
                set[size] = item;
                size += 1;
            }
        }
    }

    public Set subSet(int sele, int eele) {
        Set subset = new Set();
        if (sele < eele) {
            Set trail = new Set();
            trail.headSet(eele);
            for (int i = 0; i < trail.size(); i++) {
                if(set[i] >= sele) {
                    subset.add(set[i]);
                }
            }
        }
        System.out.println(subset);
        return subset;
    }

    public Set headSet(int element) {
        Set headset = new Set();
        for (int i = 0; i < size; i++) {
            if(set[i] < element) {
                headset.add(set[i]);
            }
        }
        return headset;
    }

    public int last() {
        if (size > 0) {
            return max();
        }
        System.out.println("Set Empty Exception");
        return 0;
    }


    public void add(final int index, final int item) {
        for (int i = size - 1; i >= index; i--) {
            set[i + 1] = set[i];
        }
        set[index] = item;
        size += 1;
    }
    /**
     * { Size Method }.
     *
     * @return     { Returns Integer Value }
     */
    public int size() {
        return size;
    }

    /**
     * { Add Method }.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        if (items.length + size >= set.length) {
            resize();
        }
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * { Get Method }.
     *
     * @param      index  The index
     *
     * @return     { Returns Integer }
     */
    public int get(final int index) {
        if (index < size && index >= 0) {
            return set[index];
        }
        return -1;
    }
    /**
     * { Intersection Method }.
     *
     * @param      sett  The sett
     *
     * @return     { Returns Set }
     */
    public Set intersection(final Set sett) {
        int count = 0;
        Set resultset = new Set();
        if (this.size() != 0 && sett.size() != 0) {
            for (int i = 0; i < size; i++) {
                count = 0;
                for (int j = 0; j < sett.size(); j++) {
                    if (sett.get(j) == set[i]) {
                        count += 1;
                    }
                }
                if (count >= 1) {
                    resultset.add(get(i));
                }
            }
        }
        return resultset;
    }
    /**
     * { retainAll Elements Method }.
     *
     * @param      items  The items
     *
     * @return     { Returns Set }
     */
    public Set retainAll(final int[] items) {
        Set retainset = new Set();
        retainset.addAll(items);
        return intersection(retainset);
    }
    /**
     * { Cartesian product of Arrays }.
     *
     * @param      set1  The set 1
     *
     * @return     { Returns Integer 2D Array }
     */
    public int[][] cartesianProduct(final Set set1) {
        int k = 0;
        int[][] cartesian = new int[set1.size() * size][2];
        if (set1.size() > 0 && size > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < set1.size(); j++) {
                    cartesian[k][0] = get(i);
                    cartesian[k][1] = set1.get(j);
                    k += 1;
                }
            }
            return cartesian;
        }
        return null;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { Returns Integer }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { Resize Method }.
     */
    public void resize() {
        set = Arrays.copyOf(set, set.length * 2);
    }






}
