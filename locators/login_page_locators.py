from selenium.webdriver.common.by import By


class LoginPageLocators:
    #локаторы на странице авторизации (входа в личный кабинет)
    EMAIL_INPUT_FORM_LOGIN = (By.XPATH, './/label[text() = "Email"]/following-sibling::input')  #поле ввода "Email"
    PASSWORD_INPUT_FORM_LOGIN = (By.XPATH, './/label[text() = "Пароль"]/following-sibling::input')  #поле ввода "Пароль"
    LOGIN_BUTTON_LOGIN_PAGE = (By.XPATH, './/button[text()="Войти"]')  #кнопка "Войти"
    LINK_REGISTRATION = (By.XPATH, './/*[@href="/register"]')  #ссылка "Зарегистрироваться"
    LINK_PASSWORD_RECOVERY = (By.XPATH, './/*[@href="/forgot-password"]')  #ссылка "Восстановить пароль"
