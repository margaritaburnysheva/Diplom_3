import allure

from pages.main_page import MainPage
from pages.personal_account_page import PersonalAccountPage


class TestPersonalAccount:
    @allure.title('Проверка перехода по клику на "Личный кабинет"')
    @allure.description('Кликнуть на "Личный кабинет", проверить, что открылась страница с данными пользователя и кнопкой "Выход"')
    def test_click_on_personal_account_button(self, driver, login_user):
        main_page = MainPage(driver)
        result = main_page.check_click_on_personal_account_button(driver)
        assert result == 'Выход', \
            'Не открылся профиль пользователя с кнопкой "Выход"'

    @allure.title('Проверка перехода по клику по ссылке "История заказов"')
    @allure.description('Кликнуть по ссылке "История заказов", проверить, что открылась страница с заказами пользователя')
    def test_click_on_order_history_button(self, driver, login_user):
        personal_account_page = PersonalAccountPage(driver)
        result = personal_account_page.check_click_on_order_history_button(driver)
        assert result == "page", \
            'Не отображается история заказов пользователя'

    @allure.title('Проверка перехода по клику на "Выход"')
    @allure.description('Кликнуть на "Выход", проверить, что открылась страница с кнопкой "Войти"')
    def test_logout(self, driver, login_user):
        personal_account_page = PersonalAccountPage(driver)
        result = personal_account_page.check_logout(driver)
        assert result == "Войти", \
            'Пользователь не разлогинился'
