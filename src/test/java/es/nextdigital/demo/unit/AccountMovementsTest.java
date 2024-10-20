package es.nextdigital.demo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.model.AccountMovement;
import es.nextdigital.demo.model.AccountMovementType;
import es.nextdigital.demo.model.Iban;

public class AccountMovementsTest {
    @Test
    void adding_movements_gets_them() {
        var account = new Account(new Iban("ES6621000418401234567891"));
        var movements = List.of(new AccountMovement(BigDecimal.valueOf(2.50), AccountMovementType.DEPOSIT),
                new AccountMovement(BigDecimal.valueOf(-1.00), AccountMovementType.TRANSFER));

        movements.forEach(m -> account.addMovement(m));

        var retrievedMovements = account.getMovements();
        assertEquals(new HashSet<>(movements), new HashSet<>(retrievedMovements));
    }

    @Test
    void movements_are_constistent_with_balance() {
        var account = new Account(new Iban("ES6621000418401234567891"));
        var movements = List.of(new AccountMovement(BigDecimal.valueOf(2.50), AccountMovementType.DEPOSIT),
                new AccountMovement(BigDecimal.valueOf(-1.00), AccountMovementType.TRANSFER));

        movements.forEach(m -> account.addMovement(m));

        assertEquals(movements.stream().map(m -> m.getQuantity()).reduce(BigDecimal.ZERO, BigDecimal::add),
                account.getBalance());
    }
}
