package es.nextdigital.demo.model;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AccountMovement {
    public AccountMovement(BigDecimal quantity, AccountMovementType type) {
        this.quantity = quantity;
        this.type = type;
    }

    BigDecimal quantity;

    AccountMovementType type;
}
