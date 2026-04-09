import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 오늘 팔린 책의 이름이 입력으로 들어올 때,
        // 가장 많이 팔린 책의 이름을 출력
        // 입력 첫 줄엔 총 책의 개수
        // 다음 줄부터는 책 이름이 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        String bestseller = "";

        HashMap<String, Integer> booksSold = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            booksSold.put(book, booksSold.getOrDefault(book, 0) + 1);
            if (booksSold.get(book) > max ||
                    (booksSold.get(book) == max && book.compareTo(bestseller) < 0)) {
                max = booksSold.get(book);
                bestseller = book;
            }
        }

        System.out.println(bestseller);

    }
}