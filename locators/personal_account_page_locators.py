from selenium.webdriver.common.by import By


class PersonalAccountPageLocators:
    # локаторы в Личном кабинете
    LOGOUT_BUTTON = (By.XPATH, './/button[text()="Выход"]')  #кнопка "Выход"
    CONSTRUCTOR_BUTTON = (By.XPATH, './/*[text()="Конструктор"]')  #кнопка "Конструктор"
    ORDER_HISTORY_BUTTON = (By.XPATH, './/*[text()="История заказов"]') #кнопка "История заказов"
    PERSONAL_ACCOUNT_CONTENT_BOX = (By.XPATH, './/*[@class="Account_contentBox__2CPm3"]//child::*') #информация в личном кабинете в блоке справа (данные юзера или список заказов в истории)
    ORDER_LOCATOR = (By.XPATH, './/*[@class="text text_type_digits-default"]') #локатор заказа в истории
