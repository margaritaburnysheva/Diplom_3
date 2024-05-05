from selenium.webdriver.common.by import By


class MainPageLocators:
    #локаторы на главной странице (до авторизации)
    LOGIN_BUTTON_MAIN_PAGE = (By.XPATH, '//*[contains(@class,"button_button_size_large")]') #кнопка "Войти в аккаунт" на главной

    #локаторы на главной странице (после авторизации)
    ORDER_BUTTON_MAIN_PAGE = (By.XPATH, '//*[@class="BurgerConstructor_basket__list__l9dp_"]//following::*[text()="Оформить заказ"]') #кнопка "Оформить заказ"

    #локаторы в конструкторе
    FIRST_BUN_LOCATOR = (By.XPATH, './/*[@alt="Флюоресцентная булка R2-D3"]') #Флюоресцентная булка R2-D3
    FIRST_SAUCE_LOCATOR = (By.XPATH, './/*[@alt="Соус Spicy-X"]') #Соус Spicy-X
    FIRST_FILLING_LOCATOR = (By.XPATH, './/*[@alt="Мясо бессмертных моллюсков Protostomia"]') #Мясо бессмертных моллюсков Protostomia
    FIRST_BUN_COUNTER = (By.XPATH, './/*[@href="/ingredient/61c0c5a71d1f82001bdaaa6d"]//child::*[@class="counter_counter__num__3nue1"]') #счетчик Флюоресцентная булка R2-D3
    FIRST_SAUCE_COUNTER = (By.XPATH, './/*[@href="/ingredient/61c0c5a71d1f82001bdaaa72"]//child::*[@class="counter_counter__num__3nue1"]') #счетчик Соус Spicy-X
    FIRST_FILLING_COUNTER = (By.XPATH, './/*[@href="/ingredient/61c0c5a71d1f82001bdaaa6f"]//child::*[@class="counter_counter__num__3nue1"]') #счетчик Мясо бессмертных моллюсков Protostomia
    INGREDIENT_DETAILS = (By.XPATH, './/*[text()="Детали ингредиента"]/../../..') #всплывающее окно "Детали ингредиента"
    INGREDIENT_DETAILS_CLOSE_BUTTON_LOCATOR = (By.XPATH, '/html/body/div/div/section[1]/div[1]/button') #кнопка-крестик в окне "Детали ингредиента"
    MODAL_WITH_ORDER_ID = (By.XPATH, './/*[text()="Ваш заказ начали готовить"]//ancestor::section') #окно с ID заказа
    ORDER_ID = (By.XPATH, './/*[@class="Modal_modal_opened__3ISw4 Modal_modal__P3_V5"]//parent::h2') #ID заказа
    BASKET_LOCATOR = (By.XPATH, './/*[@class="constructor-element constructor-element_pos_top"]') #локатор корзины
