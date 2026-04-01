import java.io.*;
import java.util.*;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) throws IOException {
        // 주어지는 수들의
        // 1. 산술평균값
        // 2. 중앙값
        // 3. 최빈값, 여러 개라면 그 중 두 번째로 작은 값
        // 4. 범위(최댓값과 최솟값의 차이) 출력

        // 입력값은 총 수의 수 n, 그리고 n개의 줄에 걸쳐 수를 입력받는다.
        // 단, n은 항상 홀수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int avg;
        int mid;
        int msv;
        int rng;

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        avg = (int) round((double) sum / n);
        mid = nums[n/2];
        if (n > 1) {
            msv = MostSeenValue(nums);
        } else {
            msv = nums[0];
        }

        if (n > 1) {
            rng = nums[nums.length - 1] - nums[0];
        } else {
            rng = 0;
        }

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(msv);
        System.out.println(rng);
    }

    // 최빈값 구하기
    public static int MostSeenValue(int[] arr) {
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(freqMap.values());

        // 최빈값 리스트 (오름차순 정렬된 arr 기준이므로 순서 보장)
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }

        // 최빈값이 여러 개면 두 번째로 작은 값
        if (modes.size() > 1) {
            return modes.get(1);
        }
        return modes.get(0);
    }
}