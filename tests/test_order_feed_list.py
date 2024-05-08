import allure

from pages.header_page import HeaderPage
from pages.main_page import MainPage
from pages.order_feed_list_page import OrderFeedListPage
from pages.personal_account_page import PersonalAccountPage


class TestOrderFeedList:
    @allure.title('Проверка открытия окна с деталями заказа по клику на заказ')
    @allure.description('На странице "Лента заказов" кликнуть на заказ, проверить, что отобразится модальное окно с деталями заказа')
    def test_click_to_order_and_view_details(self, driver):
        order_feed_list_page = OrderFeedListPage(driver)
        result = order_feed_list_page.check_click_to_order_and_view_details()
        assert 'opened' in result, \
            'Не отображается окно с деталями заказа по клику на заказ'

    @allure.title('Проверка отображения заказов из раздела "История заказов" на странице "Лента заказов"')
    @allure.description('Авторизоваться, создать заказ, проверить, что его заказы из раздела "История заказов" отображаются на странице "Лента заказов"')
    def test_check_orders_from_history_on_order_feed_list(self, driver, login_user):
        main_page = MainPage(driver)
        main_page.check_create_order()
        header_page = HeaderPage(driver)
        header_page.check_click_on_personal_account_button()
        personal_account_page = PersonalAccountPage(driver)
        result_history = personal_account_page.get_order_from_history()
        order_feed_list_page = OrderFeedListPage(driver)
        result_list = order_feed_list_page.get_orders_numbers_from_feed_list()
        assert result_history in result_list, \
            'Заказ из раздела "История заказов" не отображается на странице "Лента заказов"'

    @allure.title('Проверка увеличения счетчика "Выполнено за все время" при оформлении заказа')
    @allure.description('Авторизоваться, узнать значение счетчика "Выполнено за все время", создать заказ, проверить, что увеличился счетчик')
    def test_check_total_counter_increases(self, driver, login_user):
        order_feed_list_page = OrderFeedListPage(driver)
        first = order_feed_list_page.check_total_order_counter()
        main_page = MainPage(driver)
        main_page.check_create_order()
        second = order_feed_list_page.check_total_order_counter()
        assert int(second) > int(first), \
            'При создании заказа не увеличивается счетчик "Выполнено за все время"'

    @allure.title('Проверка увеличения счетчика "Выполнено за сегодня" при оформлении заказа')
    @allure.description('Авторизоваться, узнать значение счетчика "Выполнено за сегодня", создать заказ, проверить, что увеличился счетчик')
    def test_check_today_counter_increases(self, driver, login_user):
        order_feed_list_page = OrderFeedListPage(driver)
        first = order_feed_list_page.check_today_order_counter()
        main_page = MainPage(driver)
        main_page.check_create_order()
        second = order_feed_list_page.check_today_order_counter()
        assert int(second) > int(first), \
            'При создании заказа не увеличивается счетчик "Выполнено за сегодня"'

    @allure.title('Проверка отображения заказа в разделе "В работе"')
    @allure.description('Авторизоваться, создать заказ, проверить, что номер заказа отображается в блоке "В работе" на странице "Лента заказов"')
    def test_check_order_in_processing_list(self, driver, login_user):
        main_page = MainPage(driver)
        main_page.check_create_order()
        order_feed_list_page = OrderFeedListPage(driver)
        result = order_feed_list_page.get_order_list_processing()
        order = main_page.get_order_number()
        assert order in result, \
            'Номер оформленного заказа не отображается в списке "В работе"'
