package es.nextdigital.demo.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.model.AccountMovement;
import es.nextdigital.demo.model.AccountMovementType;
import es.nextdigital.demo.model.Iban;

@Repository
public class AccountRepositoryExample implements AccountRepository {

    private Map<Iban, Account> accounts;

    public AccountRepositoryExample() {
        this.accounts = new HashMap<>();

        var account = new Account(new Iban("ES6621000418401234567891"));
        var movements = List.of(new AccountMovement(BigDecimal.valueOf(2.50), AccountMovementType.DEPOSIT),
                new AccountMovement(BigDecimal.valueOf(-1.00), AccountMovementType.TRANSFER));
        movements.forEach(m -> account.addMovement(m));

        accounts.put(account.getIban(), account);
    }

    @Override
    public Optional<Account> get(Iban iban) {
        return Optional.ofNullable(accounts.get(iban));
    }

    @Override
    public void save(Account account) {
        this.accounts.put(account.getIban(), account);
    }

}
