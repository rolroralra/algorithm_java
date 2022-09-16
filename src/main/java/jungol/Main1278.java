package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1278 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());   // 보석의 개수 입력
        int upperBoundOfWeight = Integer.parseInt(st.nextToken());  // 최대 무게 제한 입력
        int[][] arr = new int[n][2];    // 보석의 무게와 가치가 저장될 배열
        int[][] maxValue = new int[n][upperBoundOfWeight + 1];  // 2차원 Dynamic Table

        for (int i = 0; i < n; i++) {    // 사용자 입력
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 보석의 무게 입력
            arr[i][1] = Integer.parseInt(st.nextToken());   // 보석의 가치 입력
        }
        // Dynamic Table 첫번째 row 초기화 (첫번째 보석만 이용)
        int boundary = arr[0][0] <= upperBoundOfWeight ? arr[0][0] : upperBoundOfWeight + 1;
        for (int i = 0; i < boundary; i++) {
            maxValue[0][i] = 0;
        }
        for (int i = boundary; i <= upperBoundOfWeight; i++) {
            maxValue[0][i] = arr[0][1];
        }

        for (int i = 1; i < n; i++) {        // 두번째 보석부터 끝까지~~~
            int currentWeight = arr[i][0];  // 현재 보석 무게
            int currentValue = arr[i][1];   // 현재 보석 가치
            for (int w = 0; w <= upperBoundOfWeight; w++) {
                if (currentWeight <= w) {    // 현재 보석 한 개를 넣을 수 있는 경우
                    maxValue[i][w] = Math.max(maxValue[i - 1][w],
                            maxValue[i - 1][w - currentWeight] + currentValue);
                }
                else {  // 현재 보석을 하나도 넣을 수 없는 경우
                    maxValue[i][w] = maxValue[i - 1][w];
                }
            }
        }
        System.out.println(maxValue[n - 1][upperBoundOfWeight]);
    }
}
