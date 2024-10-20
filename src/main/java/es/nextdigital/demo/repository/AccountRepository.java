package es.nextdigital.demo.repository;

import java.util.Optional;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.model.Iban;

public interface AccountRepository {

    public Optional<Account> get(Iban iban);

    public void save(Account account);
}
