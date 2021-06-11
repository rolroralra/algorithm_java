package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Eratosthenes {
	private final int MAX_NUMBER;
	private final int SIEVE_LIST_SIZE;
	private final List<Byte> SIEVE;

	public Eratosthenes(int MAX_NUMBER) {
		this.MAX_NUMBER = MAX_NUMBER;
		SIEVE_LIST_SIZE = (MAX_NUMBER + Byte.SIZE - 1) / Byte.SIZE;
		SIEVE = new ArrayList<>(SIEVE_LIST_SIZE);
		IntStream.range(0, SIEVE_LIST_SIZE).forEach((i) -> SIEVE.add((byte) -1));

		setComposite(0);
		setComposite(1);

		for (int i = 2; i * i <= MAX_NUMBER; i++) {
			if (isComposite(i)) {
				continue;
			}

			for (int j = i * i; j <= MAX_NUMBER; j += i) {
				setComposite(j);
			}
		}
	}

	private void setPrime(int number) {
		if (number < 0 || number > MAX_NUMBER) {
			return;
		}

		SIEVE.set(number / Byte.SIZE, (byte) (SIEVE.get(number / Byte.SIZE) | (1 << (number % Byte.SIZE))));
	}

	private void setComposite(int number) {
		if (number < 0 || number > MAX_NUMBER) {
			return;
		}

		SIEVE.set(number / Byte.SIZE, (byte) (SIEVE.get(number / Byte.SIZE) & ~(1 << (number % Byte.SIZE))));
	}

	public boolean isPrime(int number) {
		if (number < 0 || number > MAX_NUMBER) {
			throw new RuntimeException(String.format("Number must be in range [%d, %d]", 0, MAX_NUMBER));
		}

		return (SIEVE.get(number / Byte.SIZE) & (1 << (number % Byte.SIZE))) != 0;
	}

	public boolean isComposite(int number) {
		return !isPrime(number);
	}


	public static void main(String[] args) {
		// ArrayList로 구현
		ArrayList<Boolean> primeList;
		
		// 사용자로부터의 콘솔 입력
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		// n <= 1 일 때 종료 
		if(n <= 1) return;

		Eratosthenes eratosthenes = new Eratosthenes(n);

		// n+1만큼 할당
		primeList = new ArrayList<>(n+1);
		// 0번째와 1번째를 소수 아님으로 처리 
		primeList.add(false);
		primeList.add(false);
		// 2~ n 까지 소수로 설정
		for (int i = 2; i <= n; i++) {
			primeList.add(i, true);
		}
		
		// 2 부터  ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for (int i = 2; i * i <= n; i++){
			if (primeList.get(i)){
				for (int j = i; i * j <= n; j++) {
					primeList.set(i * j, false);
				}
				/*for (int j = i * i; j <= n; j += i) {
					primeList.set(j, false);
				}*/
			}
		}




		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i <= n; i++){
//			if (primeList.get(i) == true){
//				sb.append(i);
//				sb.append(",");
//			}
			if (eratosthenes.isPrime(i)) {
				sb.append(i).append(",");
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		
		String str = new String(sb);
		System.out.println(str);
	}
}

