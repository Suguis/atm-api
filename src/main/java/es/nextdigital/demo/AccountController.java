package es.nextdigital.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.nextdigital.demo.model.AccountMovement;
import es.nextdigital.demo.model.Iban;
import es.nextdigital.demo.repository.AccountRepository;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{iban}/movements")
    public ResponseEntity<List<AccountMovement>> getCart(@PathVariable String iban) {
        return accountRepository.get(new Iban(iban)).map(account -> ResponseEntity.ok(account.getMovements()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
