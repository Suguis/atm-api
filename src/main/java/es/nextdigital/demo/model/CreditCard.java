package es.nextdigital.demo.model;

import java.math.BigDecimal;

import lombok.Getter;

public class CreditCard implements Card {

    @Getter
    private Account account;

    @Getter
    private BigDecimal limit;

    public CreditCard(Account account, BigDecimal limit) {
        this.account = account;
        this.limit = limit;
    }

    @Override
    public void withdraw(BigDecimal quantity) throws NotEnoughBalanceException {
        if (quantity.compareTo(getLimit()) == 1)
            throw new NotEnoughBalanceException();

        account.addMovement(new AccountMovement(quantity.negate(), AccountMovementType.WITHDRAWAL));
    }
}
