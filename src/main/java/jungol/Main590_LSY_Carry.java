package jungol;

import java.util.Scanner;

public class Main590_LSY_Carry {
	boolean bool;
	
	public Main590_LSY_Carry() {
		bool = true;
		Scanner sc = new Scanner(System.in);
		dice(sc.nextInt());
	}//생성자
	
	public static void main(String[] args) {
		new Main590_LSY_Carry();//생성자호출
	}//메인
	
	public void dice(int n){
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = 1;
		}
		
		while(bool){
			printLine(num);//출력
			nextLine(num);//배열변화
		}
	}
	
	public void printLine(int[] num){
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}
	
	public void nextLine(int[] num){
		int[] c = new int[num.length];
		c[c.length-1] = 1;
		for (int i = num.length-1; i >0; i--) {
			if(num[i]+c[i]==7) c[i-1] = 1;
		}
		for (int i = 0; i < c.length; i++) {
			num[i] = num[i]+c[i];
			if(num[i]==7){
				if(i==0){
					bool = false;
					return;
				}else{
					num[i] = num[i-1];
				}
			}
		}
	}
}
