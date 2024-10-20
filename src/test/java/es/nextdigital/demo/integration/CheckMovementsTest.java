package es.nextdigital.demo.integration;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;

import es.nextdigital.demo.repository.AccountRepository;
import es.nextdigital.demo.unit.TestUtils;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CheckMovementsTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void checking_movements_gets_all_of_them() {
        var account = TestUtils.getTestAccount();
        accountRepository.save(account);

        given().get("/accounts/" + account.getIban().getValue() + "/movements").then().assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void checking_movements_of_unexisting_account_gives_not_found() {
        given().get("/accounts/" + "ES12345" + "/movements").then().assertThat()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}