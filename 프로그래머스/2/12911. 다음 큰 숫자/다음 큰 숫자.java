import java.util.*;

class Solution {
    public int solution(int n) {

        int bitN = Integer.bitCount(n);
        int bigNumber = n + 1;
        while (Integer.bitCount(bigNumber) != bitN) {
            bigNumber++;
        }
        return bigNumber;
    }
}