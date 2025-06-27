package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.length() < m) {
                continue;
            }

            countMap.put(input, countMap.getOrDefault(input, 0) + 1);
        }

        List<String> words = new ArrayList<>(countMap.keySet());
        words.sort((o1, o2) -> {
            if (Objects.equals(countMap.get(o1), countMap.get(o2))) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            } else {
                return countMap.get(o2) - countMap.get(o1);
            }
        });


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb =new StringBuilder();

        for (String word : words) {
            sb.append(word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
