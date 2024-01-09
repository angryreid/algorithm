package emma.dp;

public class _II_2707_Extra_Characters_In_A_String {
    public int minExtraChar(String s, String[] dictionary) {
      int n = s.length(); // Get the length of the string
      int[] d = new int[n + 1]; // Create an array of size n+1
      Arrays.fill(d, Integer.MAX_VALUE); // Fill the array with the maximum integer value

      // Create a map to store each word in the dictionary and its frequency
      Map<String, Integer> map = new HashMap<String, Integer>();
      for (String str : dictionary) {
        map.put(str, map.getOrDefault(str, 0) + 1); // If the word is already in the map, increment its frequency. Otherwise, add it to the map with a frequency of 1.
      }

      d[0] = 0; // Initialize the first element of the array to 0

      // Iterate over the string
      for (int i = 1; i <= n; i++) {
        d[i] = d[i - 1] + 1; // Increment the current element of the array by 1

        // Iterate over the substring from the current index to the beginning of the string
        for (int j = i - 1; j >= 0; j--) {
          // If the substring is in the map (i.e., it's a word in the dictionary)
          if (map.containsKey(s.substring(j, i))) {
            // Update the current element of the array to the minimum of its current value and the value of the array at the index of the start of the substring
            d[i] = Math.min(d[i], d[j]);
          }
        }
      }

      return d[n]; // Return the last element of the array, which represents the minimum number of extra characters needed to make the string a concatenation of words in the dictionary
    }
}
