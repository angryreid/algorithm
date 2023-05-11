package emma;

public class BloomFilter<T> {
    private int bitSize; // binary size
    private int hashSize; // hash function size
    private long[] bits; // 8 * size
    /**
     *
     * @param n data size
     * @param p error rate (0 , 1)
     */
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p>= 1) {
            throw new IllegalArgumentException("Wrong n or p");
        }
        double ln2 = Math.log(2);
        bitSize = (int) (- (n * Math.log(p)) / (ln2 * ln2));
        hashSize = (int) (bitSize * ln2 / n);
        System.out.println(bitSize + " " + hashSize);
    }
    /**
     * To add a  new ele
     * @param value
     */
    public void put (T value) {

    }

    /**
     * If value existing or not.
     * @param value
     * @return true -> existing, false -> not existing
     */
    public boolean contains(T value) {
        return true;
    }
}
