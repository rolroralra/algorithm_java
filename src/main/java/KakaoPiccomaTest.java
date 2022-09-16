import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KakaoPiccomaTest {
    static {
//        System.setIn(KakaoPiccomaTest.class.getResourceAsStream("sample_input.txt"));
    }

    static int T;

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        String[] input = new String[]{"banana", "strawberry", "apple", "watermelon", "orange"};
        System.out.println(fn(input));

    }

    static List<String> fn(String[] input) {
        return Stream.concat(Arrays.stream(input), Stream.of("grape"))
                .sorted()
                .skip(1)
                .map(KakaoPiccomaTest::camelCase)
                .collect(Collectors.toList());
    }

    private static String camelCase(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);

        return new String(charArray);
    }
}
