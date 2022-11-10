package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.Lotto;
import store.LottoMachine;

import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest extends NsTest {

    @DisplayName("중복되지 않은 1~45 범위의 숫자 6개 생성")
    @Test
    void case1_pick_random_unique_numbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
            LottoMachine lottoMachine = LottoMachine.getInstance();
            Method method = LottoMachine.class.getDeclaredMethod("extractRandomNumbers");
            method.setAccessible(true);

            assertThat(method.invoke(lottoMachine)).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("랜덤 숫자 6개 로또 객체로 바꾸기")
    @Test
    void case2_convert_numbers_to_lotto() {
        try {
            Class<Lotto> result = Lotto.class;
            LottoMachine lottoMachine = LottoMachine.getInstance();
            Method method = LottoMachine.class.getDeclaredMethod("convertLotto", List.class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoMachine,List.of(1,2,3,4,5,6))).isInstanceOf(result);
        }catch (Exception ignored){
        }
    }

    @Override
    protected void runMain() {
    }
}