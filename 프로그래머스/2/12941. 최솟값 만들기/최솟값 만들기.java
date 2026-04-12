import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int sum = 0;

        // 배열의 크기 및 원소 숫자는 1000 이하의 자연수
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }

        return sum;
    }
}