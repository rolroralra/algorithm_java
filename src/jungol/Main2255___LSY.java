package jungol;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2255___LSY {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[sc.nextInt()];
		boolean [] chk = new boolean[arr.length];
		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt()-1;
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			if(!chk[i]){
				int j = i;
				int cnt = 0;
				
				while(true){
					chk[j] = true;
					j = (int) arr[j];
					cnt++;
					if(j==i) break;
				}
				list.add((long) cnt);
			}
		}

		ArrayList<Long> num2 = new ArrayList<Long>(list);
		
		int cnt = list.size();
		long r=1;

		long temp;
		for(int i=0;i<cnt-1;i++){
			temp=num2.get(i);
			while(true){
				r=num2.get(i)%num2.get(i+1);
				if(r==0){
					num2.set(i+1, temp*list.get(i+1)/num2.get(i+1));
					break;
				}else{
					num2.set(i, num2.get(i+1));
					num2.set(i+1, r);
				}
			}
		}
		System.out.println(num2.get(cnt-1));
	}
}
