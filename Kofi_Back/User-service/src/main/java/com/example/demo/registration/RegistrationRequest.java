package com.example.demo.registration;

import lombok.*;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String email;
    private final String password;
}
