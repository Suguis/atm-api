package es.nextdigital.demo.unit;

import java.math.BigDecimal;
import java.util.List;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.model.AccountMovement;
import es.nextdigital.demo.model.AccountMovementType;
import es.nextdigital.demo.model.CreditCard;
import es.nextdigital.demo.model.DebitCard;
import es.nextdigital.demo.model.Iban;

public class TestUtils {
    public static Account getTestAccount() {
        var account = new Account(new Iban("ES6621000418401234567891"));
        var movements = List.of(new AccountMovement(BigDecimal.valueOf(2.50), AccountMovementType.DEPOSIT),
                new AccountMovement(BigDecimal.valueOf(-1.00), AccountMovementType.TRANSFER));
        movements.forEach(m -> account.addMovement(m));
        return account;
    }

    public static DebitCard getTestDebitCard() {
        var account = getTestAccount();
        return new DebitCard(account);
    }

    public static CreditCard getTestCreditCard(BigDecimal limit) {
        var account = getTestAccount();
        return new CreditCard(account, limit);
    }
}
