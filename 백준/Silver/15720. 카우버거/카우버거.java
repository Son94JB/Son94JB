import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 원래 가격과 할인 후 최소가 되는 가격(최대로 할인된 가격) 출력
        // 할인은 버거, 음료, 사이드 하나씩 시켜야 10%를 각각의 가격에서 해준다
        // 원래 가격은 각 가격을 배열로 담아서 sum
        // 최소 가격은 최대 몇 개를 세트로 묶을 수 있는지 보고 그만큼 각 가격에서 큰 순으로 할인 해주면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 : 버거 개수, 음료 개수, 사이드 개수
        //      : 각 버거 가격
        //      :각 음료 가격
        //      : 각 사이드 가격
        // 조건 : 100의 배수이고 10000 이하의 수
        int b = Integer.parseInt(st.nextToken());  // burger
        int d = Integer.parseInt(st.nextToken());  // drink
        int s = Integer.parseInt(st.nextToken());  // side dish

        int[] burger = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] drink = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sideDish = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(burger);
        Arrays.sort(drink);
        Arrays.sort(sideDish);

        int minSet;
        int totalCost = 0;
        int discountedCost = 0;

        minSet = Math.min(b, Math.min(d, s));

        totalCost += Arrays.stream(burger).sum();
        totalCost += Arrays.stream(drink).sum();
        totalCost += Arrays.stream(sideDish).sum();

        discountedCost = totalCost;

        System.out.println(totalCost);

        for (int i = 0; i < minSet; i++) {
            // 할인 가격 빼주기
            discountedCost -= burger[b - 1 - i]/10;
            discountedCost -= drink[d - 1 - i]/10;
            discountedCost -= sideDish[s - 1 - i]/10;

        }

        System.out.println(discountedCost);
    }
}