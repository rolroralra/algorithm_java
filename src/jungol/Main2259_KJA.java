package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2259_KJA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int su=Integer.parseInt(br.readLine());
		int[][]arr=new int[6][2];
		for(int i=0; i<6; i++){
			String str=br.readLine();
			StringTokenizer stk=new StringTokenizer(str);
			arr[i][0]=Integer.parseInt(stk.nextToken());
			arr[i][1]=Integer.parseInt(stk.nextToken());
		}
		//방향이 4 (3 1 3 1) 2 식으로 두개씩 중복되는 경우가 작은 사각형이 생기는 부분이다.
		//중복되는 부분 4개 중에 가운데 두 수의 곱이 작은 사각형의 넓이가 되고 하나씩 나온 두 수 의 곱은 큰 사각형.
		//1 2 4 3 1 3 처럼 일렬로 안나오는 경우가 있으므로 %6사용함.
		int area=0;
		for(int i=0; i<6; i++){
			if(arr[i][0]==arr[(i+2)%6][0] &&arr[(i+1)%6][0]==arr[(i+3)%6][0]){
				area=arr[(i+4)%6][1]*arr[(i+5)%6][1]-arr[(i+1)%6][1]*arr[(i+2)%6][1];
				break;
			}
		}
		System.out.println(area*su);
	}
}
