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
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE]; // Long.Size = 64
        System.out.println(bitSize + " " + hashSize);
    }
    /**
     * To add a  new ele
     * @param value
     */
    public void put (T value) {
        nullCheck(value);
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            set(index);
        }
    }

    /**
     * If value existing or not.
     * @param value
     * @return true -> existing, false -> not existing
     */
    public boolean contains(T value) {
        nullCheck(value);
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            if (!get(index)) return false;
        }
        return true;
    }

    private void nullCheck(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
    }

    /**
     * Set bits index as 1
     * @param index
     */
    private void set(int index) {
        long chunk = bits[index / Long.SIZE];
        int pointer = index % Long.SIZE;
        bits[index / Long.SIZE] = chunk | (1 << pointer);
    }

    /**
     * Get bits index value and reture true for 1, false for 0
     * @param index
     * @return
     */
    private boolean get(int index) {
        long chunk = bits[index / Long.SIZE];
        int pointer = index % Long.SIZE;
        long value = chunk & ( 1 << pointer );
        return value != 0;
    }
}
