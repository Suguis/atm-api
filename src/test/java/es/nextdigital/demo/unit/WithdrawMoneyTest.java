package es.nextdigital.demo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import es.nextdigital.demo.model.NotEnoughBalanceException;

public class WithdrawMoneyTest {

    @Test
    void can_withdraw_money_on_debit_card_with_enough_balance() throws NotEnoughBalanceException {
        var card = TestUtils.getTestDebitCard();
        var initialBalance = card.getAccount().getBalance();
        var balanceToExtract = BigDecimal.valueOf(1.00);

        card.withdraw(balanceToExtract);

        assertEquals(initialBalance.subtract(balanceToExtract), card.getAccount().getBalance());
    }

    @Test
    void withdrawing_money_on_debit_card_with_not_enough_balance_throws() throws NotEnoughBalanceException {
        var card = TestUtils.getTestDebitCard();
        var balanceToExtract = card.getAccount().getBalance().add(BigDecimal.valueOf(1.00));

        assertThrows(NotEnoughBalanceException.class, () -> card.withdraw(balanceToExtract));
    }

    @Test
    void can_withdraw_money_on_credit_card_with_enough_balance() throws NotEnoughBalanceException {
        var card = TestUtils.getTestCreditCard(BigDecimal.valueOf(500.00));
        var initialBalance = card.getAccount().getBalance();
        var balanceToExtract = BigDecimal.valueOf(100.00);

        card.withdraw(balanceToExtract);

        assertEquals(initialBalance.subtract(balanceToExtract), card.getAccount().getBalance());
    }

    @Test
    void withdrawing_money_on_credit_card_with_not_enough_balance_throws() throws NotEnoughBalanceException {
        var card = TestUtils.getTestCreditCard(BigDecimal.valueOf(500.00));
        var balanceToExtract = BigDecimal.valueOf(1000.00);

        assertThrows(NotEnoughBalanceException.class, () -> card.withdraw(balanceToExtract));
    }
}
