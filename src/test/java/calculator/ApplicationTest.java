package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void customDelimiterTest() {
        assertSimpleTest(() -> {
            run("//;\n1;2");
            assertThat(output()).contains("결과: 3");
        });
    }




    @Test
    void exceptionTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수는 입력할 수 없습니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
