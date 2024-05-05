from selenium.webdriver.common.by import By


class ResetPasswordPageLocators:
    # локаторы в форме сброса пароля /reset-password
    SAVE_BUTTON_RESET_PASSWORD_FORM_LOCATOR = (By.XPATH, './/button[text()="Сохранить"]') #кнопка "Сохранить"
    SHOW_PASSWORD_ICON_LOCATOR = (By.XPATH, './/*[contains(@class,"input__icon")]') #кнопка показать/скрыть пароль
    EMAIL_RESET_PASSWORD_FORM_LOCATOR = (By.XPATH, '//*[text()="Пароль"]/..') #поле "Email"