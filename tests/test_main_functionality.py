import allure
import pytest

from locators.main_page_locators import MainPageLocators
from pages.header_page import HeaderPage
from pages.main_page import MainPage
from pages.order_feed_list_page import OrderFeedListPage


class TestMainFunctionality:
    @allure.title('Проверка перехода по клику на "Конструктор"')
    @allure.description('На странице авторизации кликнуть по ссылке "Конструктор", проверить, что отобразится кнопка "Войти в аккаунт"')
    def test_switch_from_personal_account_click_constructor(self, driver):
        header_page = HeaderPage(driver)
        header_page.check_click_to_constructor()
        main_page = MainPage(driver)
        result = main_page.get_text_from_login_button_main_page()
        assert result == 'Войти в аккаунт', \
            'Ошибка при переходе из Личного кабинета по клику на "Конструктор"'

    @allure.title('Проверка перехода по клику по ссылке "Лента Заказов"')
    @allure.description('На странице авторизации кликнуть по ссылке "Лента Заказов", проверить, что отобразится заголовок "Лента заказов"')
    def test_switch_from_personal_account_click_order_feed_list(self, driver):
        header_page = HeaderPage(driver)
        header_page.check_click_to_order_feed_list()
        order_feed_list_page = OrderFeedListPage(driver)
        result = order_feed_list_page.get_text_from_title_order_feed_list()
        assert result == 'Лента заказов', \
            'Ошибка при переходе по клику на "Лента Заказов"'

    @allure.title('Проверка отображения деталей по клику на ингредиент')
    @allure.description('На главной странице кликнуть на ингредиент, проверить, что отобразится всплывающее окно с деталями')
    @pytest.mark.parametrize('ingredient',
                             [MainPageLocators.FIRST_BUN_LOCATOR,
                              MainPageLocators.FIRST_SAUCE_LOCATOR,
                              MainPageLocators.FIRST_FILLING_LOCATOR])
    def test_click_to_ingredient_and_open_ingredient_details(self, driver, ingredient):
        main_page = MainPage(driver)
        result = main_page.check_click_to_ingredient(ingredient)
        assert 'opened' in result, \
            'По клику на ингредиент не появляется всплывающее окно'

    @allure.title('Проверка закрытия окна с деталями ингредиента')
    @allure.description('Проверить, что по клику на крестик закрывается всплывающее окно с деталями')
    def test_click_to_close_button_on_ingredient_details(self, driver):
        main_page = MainPage(driver)
        result = main_page.check_click_close_button_on_ingredient_details()
        assert 'opened' not in result, \
            'По клику на крестик не закрывается всплывающее окно'

    @allure.title('Проверка увеличения счетчика ингредиента при добавлении ингредиента в корзину')
    @allure.description('Добавить ингредиент в корзину, проверить, что увеличился счетчик ингредиента')
    @pytest.mark.parametrize('ingredient, cnt, result_count',
                             [[MainPageLocators.FIRST_BUN_LOCATOR, MainPageLocators.FIRST_BUN_COUNTER, '2'],
                              [MainPageLocators.FIRST_SAUCE_LOCATOR, MainPageLocators.FIRST_SAUCE_COUNTER, '1'],
                              [MainPageLocators.FIRST_FILLING_LOCATOR, MainPageLocators.FIRST_FILLING_COUNTER, '1']])
    def test_add_ingredient_and_counter_increases(self, driver, ingredient, cnt, result_count):
        main_page = MainPage(driver)
        result = main_page.check_add_ingredient_and_counter_increases(ingredient, cnt)
        assert result == result_count, \
            'При добавлении ингредиента в корзину не увеличивается счетчик'

    @allure.title('Проверка создания заказа авторизованным пользователем')
    @allure.description('Авторизоваться, создать заказ, проверить, что открылось окно с номером заказа')
    def test_create_order_by_authorized_user(self, driver, login_user):
        main_page = MainPage(driver)
        result = main_page.check_create_order()
        assert 'opened' in result, \
            'Ошибка при оформлении заказа авторизованным пользователем'
