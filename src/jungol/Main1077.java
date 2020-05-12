package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1077 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int totalWeight = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];
        int[][] maxValue = new int[n + 1][totalWeight + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 무게 입력
            arr[i][1] = Integer.parseInt(st.nextToken());   // 가치 입력
        }

        //int quotient;
        //int max;
        int currentWeight;
        int currentValue;
        //int interResult;
        for (int i = 1; i <= n; i++) {
            currentWeight = arr[i][0];
            currentValue = arr[i][1];
            for (int w = 1; w <= totalWeight; w++) {
                if (currentWeight > w) {
                    maxValue[i][w] = maxValue[i - 1][w];
                }
                else {
                    //quotient = w / currentWeight;
                    //max = 0;
/*                  for (int d = 0; d <= quotient; d++) {
                        interResult = maxValue[i - 1][w - currentWeight * d] + d * currentValue;
                        if (interResult > max) {
                            max = interResult;
                        }
                    }*/
                    maxValue[i][w] = Math.max(maxValue[i][w - currentWeight] + currentValue, maxValue[i - 1][w]);
                }
            }
        }
        System.out.println(maxValue[n][totalWeight]);

        /*System.out.println();
        for (int i = 0; i < totalWeight + 1; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n-----------------------------------------------------------");
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totalWeight + 1; j++) {
                System.out.printf("%4d", maxValue[i][j]);
            }
            System.out.println();
        }*/
    }


}