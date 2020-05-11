package koitp.day3;
import java.util.*;
public class Prob3_OYH {
	static int n;
	static int[] arr = {2, 3, 5, 7};
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<Long> spp = new ArrayList<Long>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		spp.add((long)1);
		add(arr);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			n = sc.nextInt();
			System.out.println(spp.get(n-1));
		}
		sc.close();
	}
	
	static void add(int[] z) {
		for(int i=0; i<z.length; i++) {
			long tmp = z[i];
			int size = spp.size();
			while(tmp <= MAX) {
				for(int j=0; j<size; j++) {
					if(tmp * spp.get(j) > MAX) break;
					else spp.add(tmp*spp.get(j));
				}
				tmp *= z[i];
			}
			Collections.sort(spp);
		}
	}
}