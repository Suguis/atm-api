package es.nextdigital.demo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import es.nextdigital.demo.model.AccountMovement;
import es.nextdigital.demo.model.AccountMovementType;

public class AccountMovementsTest {
    @Test
    void adding_movements_gets_them() {
        var account = TestUtils.getTestAccount();
        var movement = new AccountMovement(BigDecimal.valueOf(5), AccountMovementType.DEPOSIT);

        account.addMovement(movement);

        assertTrue(account.getMovements().contains(movement));
    }

    @Test
    void movements_are_constistent_with_balance() {
        var account = TestUtils.getTestAccount();

        assertEquals(account.getMovements().stream().map(m -> m.getQuantity()).reduce(BigDecimal.ZERO, BigDecimal::add),
                account.getBalance());
    }
}
