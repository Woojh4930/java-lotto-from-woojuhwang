package user;

import store.Lotto;
import store.LottoMachine;

import java.util.List;
import java.util.regex.Pattern;

public class Customer {
    private static final String NUMERIC_ERROR = "[ERROR] 숫자를 입력해 주시기 바랍니다.";
    private static final String NUMBER_OF_PURCHASES_PHRASE = "개를 구매했습니다.\n";

    private List<Lotto> lotteries;
    private int pay;

    public Customer(String readline) {
        validateNumeric(readline);
        int pay = Integer.parseInt(readline);
        lotteries = buyLotteries(pay);
        this.pay = pay;
    }

    private List<Lotto> buyLotteries(int pay) {
        return LottoMachine.getInstance().pickLotteries(pay);
    }

    private void validateNumeric(String readline) {
        if (Pattern.matches("^\\d", readline)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    public String toLottoString() {
        int numberOfPurchases = lotteries.size();
        StringBuilder currentLotteries = new StringBuilder(numberOfPurchases + NUMBER_OF_PURCHASES_PHRASE);
        while (numberOfPurchases > 0) {
            currentLotteries.append(lotteries.get(numberOfPurchases - 1)).append("\n");
            numberOfPurchases--;
        }
        return currentLotteries.toString();
    }
}
