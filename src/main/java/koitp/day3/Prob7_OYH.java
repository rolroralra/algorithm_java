package koitp.day3;
import java.util.*;
public class Prob7_OYH {
	static int k, n;
	static int[] prime;
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<Long> pp = new ArrayList<Long>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		prime = new int[k];
		for(int i=0; i<k; i++)
			prime[i] = sc.nextInt();
		
		pp.add((long)1);
		for(int i=0; i<k; i++)
			add(prime[i]);
		
		System.out.println(pp.get(n));
		sc.close();
	}
	
	static void add(int z) {
		long tmp = z;
		int size = pp.size();
		while(tmp <= MAX) {
			for(int i=0; i<size; i++) {
				long num = tmp * pp.get(i);
				if(size > n && num >= pp.get(n)) break;
				else if(tmp * pp.get(i) > MAX) break;
				else pp.add(tmp*pp.get(i));
			}
			tmp *= z;
		}
		Collections.sort(pp);
	}
}
