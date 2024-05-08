from selenium.webdriver.common.by import By


class HeaderLocators:
    #локаторы в хедере
    CONSTRUCTOR_LOCATOR = (By.XPATH, './/*[text()="Конструктор"]')  #кнопка "Конструктор"
    ORDER_FEED_LIST_LOCATOR = (By.XPATH, './/*[text()="Лента Заказов"]')  #кнопка "Лента заказов"
    PERSONAL_ACCOUNT = (By.XPATH, '//*[text()="Личный Кабинет"]')  #кнопка "Личный кабинет"
