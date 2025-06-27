package algorithm;

public class WrapperClass {

	public static void main(String[] args) {
		
		String s1 = "ABC";					// "ABC" String 객체가 literal pool(상수 풀)
		String s2 = "ABC";					// 상수 풀에 이미 있는 객체를 가져다 줌
		String s3 = new String("ABC");		// 새 객체 생성
		String s4 = new String("ABC");		// 새 객체 생성
		System.out.println(s1 == s2);	// true
		System.out.println(s3 == s4);	// false
										

										// Compiler가 인식하는 코드!
		Integer a = 128;				// Integer a = Integer.valueOf(128);
		Integer b = 128;				// Integer b = Integer.valueOf(128);
		Integer c = 127;				// Integer c = Integer.valueOf(127);	
		Integer d = 127;				// Integer d = Integer.valueOf(127);
		Integer e = Integer.valueOf(127);
		int f = a;						// int f = a.intValue();
		
		System.out.println(a == b);		// false
		System.out.println(c == d);		// true
		System.out.println(c == e);		// true
		System.out.println(a == f);		// true
		
		//	c == d 가 false임을 통해.. AutoBoxing은 생성자 new Integer(..)로 하는 것이 아니라..
		// 	Integer.valueOf(..) 함수를 이용한다는 것을 추론할 수 있다.
		//	a == b 는 true임에 반해, c == d 는 false.
		// 	이것은... Integer.valueOf(..) 함수는 -128 ~ 127 사이의 값에 대해서는 cache값을 이용하기 때문이다.
		// 	Import 되면서 바로 static Area에 Integer Class static member들 메모리에 할당이 되는데. 
		//	이때 이미 -128 ~ 127사이의 Integer.valueOf(..) 리턴 객체들을 cache값에 저장!
	}
}
