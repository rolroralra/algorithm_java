package jungol;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
  
public class Main2460_Priority {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        long priority1 = 0;
        long priority2 = 0;
        long priority3 = 0;
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempA = Integer.parseInt(st.nextToken());
            int tempB = Integer.parseInt(st.nextToken());
            int tempC = Integer.parseInt(st.nextToken());
            result1 += tempA;
            result2 += tempB;
            result3 += tempC;
            priority1 += convert(tempA);
            priority2 += convert(tempB);
            priority3 += convert(tempC);
        }
  
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(result1);
        al.add(result2);
        al.add(result3);
        ArrayList<Long> pri = new ArrayList<Long>();
        pri.add(priority1);
        pri.add(priority2);
        pri.add(priority3);
  
        int max = Collections.max(al);
        
        ArrayList<Integer> maxAl = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if (al.get(i) == max) {
                maxAl.add(i);
            }
        }
  
        int maxCount =  maxAl.size();
        if (maxCount == 1) {
            System.out.println((maxAl.get(0) + 1) + " " + max);
        } else {
            int index = 0;
            long maxPri = pri.get(maxAl.get(index));
            for (int i = 1; i < maxCount; i++) {
                long temp = pri.get(maxAl.get(i));
                if (temp > maxPri) {
                    maxPri = temp;
                    index = maxAl.get(i);
                } else if (temp == maxPri) {
                    System.out.println(0 + " " + max);
                    return;
                }
            }
            System.out.println((index + 1) + " " + max);
        }
  
    }// end main
  
    private static long convert(long i) {
        if (i == 1) {
            return i;
        } else if (i == 2) {
            return 1100 * i;
        } else {
            return 100000000 * i;
        }
    }
}// end class