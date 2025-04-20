package algorithm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LowerUpperBoundTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = List.of(1, 2, 3, 3, 3, 4, 5, 6, 7, 8);
    }

    @DisplayName("LowerUpperBound.lowerBound() 테스트")
    @Test
    void lowerBound() {
        assertAll(
            () -> assertThat(LowerUpperBound.lowerBound(list, 3))
                .isEqualTo(2),
            () -> assertThat(LowerUpperBound.lowerBound(list, 0))
                .isZero(),
            () -> assertThat(LowerUpperBound.lowerBound(list, 9))
                .isEqualTo(-11)
        );
    }

    @DisplayName("LowerUpperBound.upperBound() 테스트")
    @Test
    void upperBound() {
        assertAll(
            () -> assertThat(LowerUpperBound.upperBound(list, 3))
                .isEqualTo(5),
            () -> assertThat(LowerUpperBound.upperBound(list, 0))
                .isZero(),
            () -> assertThat(LowerUpperBound.upperBound(list, 9))
                .isEqualTo(-11)
        );
    }
}