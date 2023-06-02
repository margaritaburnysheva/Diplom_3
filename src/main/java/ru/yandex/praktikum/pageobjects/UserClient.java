package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends UserRest {
    private static final String CREATE_USER_URI = "https://stellarburgers.nomoreparties.site/api/auth/register";
    private static final String LOGIN_USER_URI = "https://stellarburgers.nomoreparties.site/api/auth/login";
    private static final String DELETE_AND_PATCH_USER_URI = "https://stellarburgers.nomoreparties.site/api/auth/user";

    @Step("Create user")
    public void createUser(User user) {
        given()
                .spec(getBaseReqSpec())
                .body(user)
                .when()
                .post(CREATE_USER_URI);
    }

    @Step("Login with user credentials")
    public ValidatableResponse loginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseReqSpec())
                .body(userCredentials)
                .when()
                .post(LOGIN_USER_URI)
                .then();
    }

    @Step("Delete user")
    public void deleteUser(String token) {
        given()
                .spec(getBaseReqSpec())
                .header("Authorization", token)
                .when()
                .delete(DELETE_AND_PATCH_USER_URI);
    }
}
