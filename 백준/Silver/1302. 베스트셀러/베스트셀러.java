import java.io.*;
import java.util.*;

public class Main {

    static class Book implements Comparable<Book>{
        String title;
        int sold;

        Book(String title, int sold){
            this.title = title;
            this.sold = sold;
        }

        @Override
        public int compareTo(Book o) {
            if (this.sold != o.sold) {
                return o.sold - this.sold;
            }
            return this.title.compareTo(o.title);
        }
    }

    public static void main(String[] args) throws IOException {
        // 오늘 팔린 책의 이름이 입력으로 들어올 때,
        // 가장 많이 팔린 책의 이름을 출력
        // 입력 첫 줄엔 총 책의 개수
        // 다음 줄부터는 책 이름이 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;

        HashMap<String, Integer> booksSold = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            booksSold.put(book, booksSold.getOrDefault(book, 0) + 1);
        }

        Book bestseller = booksSold.entrySet().stream()
                .map(e -> new Book(e.getKey(), e.getValue()))
                .min(Comparator.naturalOrder())
                .get();
//        위 코드를 풀어 쓰면 다음과 같다.
//
//        List<Book> bookList = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : booksSold.entrySet()) {
//            bookList.add(new Book(entry.getKey(), entry.getValue()));
//        }
//
//        Collections.sort(bookList);
//
//        Book bestseller = bookList.get(0);

        System.out.println(bestseller.title);

    }
}