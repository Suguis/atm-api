package es.nextdigital.demo.model;

import java.math.BigDecimal;

public interface Card {
    public BigDecimal getLimit();

    public void withdraw(BigDecimal quantity) throws NotEnoughBalanceException;
}
