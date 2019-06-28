package org.study.pcfdevcert.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt;

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zipcode is required")
    private String zip;
    @CreditCardNumber
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[1-2])([\\/])([0-9][0-9])$")
    private String ccExpiry;
    @Digits(integer = 3, fraction = 0, message = "Invalid CCV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacoList = new ArrayList<>();

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    public void addDesign(Taco design) {
        tacoList.add(design);
    }
}

//