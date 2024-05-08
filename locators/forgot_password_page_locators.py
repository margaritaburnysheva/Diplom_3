from selenium.webdriver.common.by import By


class ForgotPasswordPageLocators:
    #локаторы в форме восстановления пароля /forgot-password
    EMAIL_FORGOT_PASSWORD_FORM = (By.XPATH, '//*[@class="text input__textfield text_type_main-default"]')  #поле ввода Email
    BUTTON_RECOVERY_FORGOT_PASSWORD_FORM = (By.XPATH, './/button[text()="Восстановить"]')  #кнопка "Восстановить"
