import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자연수 N이 주어질 때, 1 ~ N까지 이어붙힌 수는 몇 자리 수인지 출력
        // 단, 1 <= N <= 100_000_000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long totalDigits = 0;
        long digits = 1;       // 현재 자릿수
        long rangeStart = 1;   // 구간 시작 (1, 10, 100, ...)

        while (rangeStart <= n) {
            long rangeEnd = rangeStart * 10 - 1; // 구간 끝 (9, 99, 999, ...)
            long count = Math.min(rangeEnd, n) - rangeStart + 1; // 실제 포함되는 숫자 개수
            totalDigits += count * digits;

            digits++;
            rangeStart *= 10;
        }

        System.out.println(totalDigits);
    }
}