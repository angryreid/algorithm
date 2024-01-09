package emma;

public class BloomFilter<T> {
    private int bitSize; // 二进制大小
    private int hashSize; // 哈希函数大小
    private long[] bits; // 8 * size

    /**
     *
     * @param n 数据大小
     * @param p 错误率 (0 , 1)
     */
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p>= 1) {
            throw new IllegalArgumentException("错误的 n 或 p");
        }
        double ln2 = Math.log(2);
        bitSize = (int) (- (n * Math.log(p)) / (ln2 * ln2)); // 计算二进制大小
        hashSize = (int) (bitSize * ln2 / n); // 计算哈希函数大小
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE]; // 初始化位数组
        System.out.println(bitSize + " " + hashSize);
    }

    /**
     * 添加一个新元素
     * @param value
     */
    public boolean put (T value) {
        nullCheck(value); // 检查值是否为null
        int hash1 = value.hashCode(); // 计算哈希值1
        int hash2 = hash1 >>> 16; // 计算哈希值2
        boolean result = false;
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2); // 计算组合哈希值
            if (combinedHash < 0) {
                combinedHash = ~combinedHash; // 如果组合哈希值为负数，取反
            }
            int index = combinedHash % bitSize; // 计算索引
            if(set(index)) result = true; // 设置位数组的指定索引为1
        }
        return result;
    }

    /**
     * 检查值是否存在
     * @param value
     * @return true -> 存在, false -> 不存在
     */
    public boolean contains(T value) {
        nullCheck(value); // 检查值是否为null
        int hash1 = value.hashCode(); // 计算哈希值1
        int hash2 = hash1 >>> 16; // 计算哈希值2
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2); // 计算组合哈希值
            if (combinedHash < 0) {
                combinedHash = ~combinedHash; // 如果组合哈希值为负数，取反
            }
            int index = combinedHash % bitSize; // 计算索引
            if (!get(index)) return false; // 如果位数组的指定索引为0，返回false
        }
        return true;
    }

    private void nullCheck(T value) {
        if (value == null) {
            throw new IllegalArgumentException("值不能为null"); // 如果值为null，抛出异常
        }
    }

    /**
     * 设置位数组的指定索引为1
     * @param index
     */
    private boolean set(int index) {
        long chunk = bits[index / Long.SIZE]; // 获取位数组的指定块
        int pointer = index % Long.SIZE; // 计算指针位置
        int bitValue = 1 << pointer; // 计算位值
        bits[index / Long.SIZE] = chunk | bitValue; // 使用位运算符OR设置位数组的指定索引为1
        return (chunk & bitValue) == 0; // 如果原来的位值为0，返回true，否则返回false
    }

    /**
     * 获取位数组的指定索引的值，1返回true，0返回false
     * @param index
     * @return
     */
    private boolean get(int index) {
        long chunk = bits[index / Long.SIZE]; // 获取位数组的指定块
        int pointer = index % Long.SIZE; // 计算指针位置
        long value = chunk & ( 1 << pointer ); // 使用位运算符AND获取位数组的指定索引的值
        return value != 0; // 如果位值为1，返回true，否则返回false
    }
}