package jungol;

import java.util.Scanner;

public class Main1239_SYM_XOR {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if(num > 10) System.exit(1);
		String s1 = s.next();
		s.close();
		
		int stop = -1;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < num * 6; i += 6) {
			String comp = s1.substring(i, i + 6);
			
			String stemp = null;
			int repetition = 0;
			
			int temp = Integer.valueOf(comp, 2);
			if(repcount(Integer.toBinaryString(temp ^ 0b000000)) <= 1)
			{
				stemp = "A";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b001111)) <= 1)
			{
				stemp = "B";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b010011)) <= 1)
			{
				stemp = "C";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b011100)) <= 1)
			{
				stemp = "D";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b100110)) <= 1)
			{
				stemp = "E";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b101001)) <= 1)
			{
				stemp = "F";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b110101)) <= 1)
			{
				stemp = "G";
				repetition++;
			}
			if(repcount(Integer.toBinaryString(temp ^ 0b111010)) <= 1)
			{
				stemp = "H";
				repetition++;
			}
			
			if(repetition != 1){stop = i/6+1; break;}
			sb.append(stemp);
		}

		if(stop == -1){System.out.println(sb.toString());}
		else{System.out.println(stop);}
	}

	public static int repcount(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				cnt++;
			}
		}
		return cnt;
	}
}
