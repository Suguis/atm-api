package es.nextdigital.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

public class Account {
    @Getter
    Iban iban;

    @Getter
    BigDecimal balance;

    List<AccountMovement> movements = new ArrayList<>();

    public Account(Iban iban) {
        this.iban = iban;
        this.balance = BigDecimal.ZERO;
    }

    public void addMovement(AccountMovement movement) {
        movements.add(movement);
        balance = balance.add(movement.getQuantity());
    }

    public List<AccountMovement> getMovements() {
        return Collections.unmodifiableList(movements);
    }
}
