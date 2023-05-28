package ru.yandex.praktikum.pageobjects;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String email;
    private String password;
}

