package es.nextdigital.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Iban {
    private String value;

    public Iban(String value) {
        this.value = value;
    }
}
