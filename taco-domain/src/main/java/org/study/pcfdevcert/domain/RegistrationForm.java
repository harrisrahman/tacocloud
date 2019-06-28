package org.study.pcfdevcert.domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;


@Data
public class RegistrationForm {

    private final String username;
    private final String password;
    private final String fullname;
    private final String phone;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public User toUser(PasswordEncoder passwordEncoder) {

        User user = new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
        return user;
    }
}
