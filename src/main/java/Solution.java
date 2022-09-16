import java.util.Arrays;
import java.util.function.Function;

public class Solution
{

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    enum Direction {
        LEFT("L", 'L') {
            @Override
            Direction opposite() {
                return null;
            }

            {}},
        RIGHT("R", 'R') {
            @Override
            Direction opposite() {
                return null;
            }
        },
        UP("U", 'U') {
            @Override
            Direction opposite() {
                return null;
            }
        },
        DOWN("D", 'D') {
            @Override
            Direction opposite() {
                return null;
            }
        };

        Direction(String name, char character) {
            this.name = name;
            this.character = character;
        }

        final String name;
        final char character;

        abstract Direction opposite();
//        public Direction opposite() {
//            switch (this) {
//                case LEFT:
//                    return RIGHT;
//                case RIGHT:
//                    return LEFT;
//                case UP:
//                    return DOWN;
//                case DOWN:
//                    return UP;
//                default:
//                    return null;
//            }
//        }

        public int oppositeOrdinal() {
            return this.opposite().ordinal();
        }

        public static Direction of(int character) {
            return Arrays.stream(Direction.values()).filter(direction -> direction.character == character).findAny().orElse(null);
        }
    }

    class Position {
        int x;
        int y;
    }

    public int solution(String dirs) {
        int answer = 0;

        int[][][] isPassed = new int[11][11][Direction.values().length];

        int currX = 0;
        int currY = 0;

        for (char dir : dirs.toCharArray()) {
            Direction direction = Direction.of(dir);

            int nextX = currX + dx[direction.ordinal()];
            int nextY = currY + dy[direction.ordinal()];

            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }

            if (isPassed[currX + 5][currY + 5][direction.ordinal()] != 1 && isPassed[nextX + 5][nextY + 5][direction.oppositeOrdinal()] != 1) {
                isPassed[currX + 5][currY + 5][direction.ordinal()] = 1;
                isPassed[nextX + 5][nextY + 5][direction.oppositeOrdinal()] = 1;
                answer++;
            }

            currX = nextX;
            currY = nextY;
        }

        return answer;
    }


    public static void main(String[] args) throws Exception {

        System.out.println(new Solution().solution("ULURRDLLU"));
        System.out.println(new Solution().solution("LULLLLLLU"));

//        System.out.println(new Solution().solution(123));
//        System.out.println(new Solution().solution(1));
//        System.out.println(new Solution().solution(100_000_000));






    }


}