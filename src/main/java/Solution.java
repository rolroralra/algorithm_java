
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine(), 2);

            for (int j = 0; j < i; j++) {
                if (Long.bitCount(arr[i] ^ arr[j]) < M) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private final List<Character> openCharacters = Arrays.asList('{', '(', '[');
    private final List<Character> closedCharacters = Arrays.asList('}', ')', ']');

    private final Map<Character, Character> characterMap = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');

    }};

    private final Stack<Character> stack = new Stack<>();

    public boolean solution(String s) {
        try {
            stack.clear();
            s.chars().forEach(code -> process((char) code));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void process(Character code) {
        if (isOpenCharacter(code)) {
            addStack(code);
        } else if (isClosedCharacter(code)) {
            checkAndPopStack(code);
        } else {
            throw new IllegalArgumentException("Invalid Character :" + code);
        }
    }

    private void checkAndPopStack(Character code) {
        assert isClosedCharacter(code);

        Character peekCode = stack.peek();
        Character expectedClosedCode = characterMap.getOrDefault(peekCode, null);

        if (code.equals(expectedClosedCode)) {
            stack.pop();
        } else {
            throw new IllegalArgumentException("Invalid Order");
        }
    }

    private boolean isOpenCharacter(Character code) {
        return openCharacters.contains(code);
    }

    private boolean isClosedCharacter(Character code) {
        return closedCharacters.contains(code);
    }

    private void addStack(Character code) {
        assert isOpenCharacter(code);

        stack.add(code);
    }
}
