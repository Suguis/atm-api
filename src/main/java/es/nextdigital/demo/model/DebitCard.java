package es.nextdigital.demo.model;

import java.math.BigDecimal;

import lombok.Getter;

public class DebitCard implements Card {

    @Getter
    private Account account;

    public DebitCard(Account account) {
        this.account = account;
    }

    @Override
    public BigDecimal getLimit() {
        return account.getBalance();
    }

    @Override
    public void withdraw(BigDecimal quantity) throws NotEnoughBalanceException {
        if (quantity.compareTo(getLimit()) == 1)
            throw new NotEnoughBalanceException();

        account.addMovement(new AccountMovement(quantity.negate(), AccountMovementType.WITHDRAWAL));
    }
}
