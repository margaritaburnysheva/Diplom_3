import string
import random

import pytest
import requests
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager

from constants import Constants
from locators.login_page_locators import LoginPageLocators
from locators.main_page_locators import MainPageLocators
from pages.login_page import LoginPage


@pytest.fixture(scope="function", params=['chrome', 'firefox'])
def driver(request):
    if request.param == 'chrome':
        service = Service(ChromeDriverManager().install())
        chrome_options = webdriver.ChromeOptions()
        chrome_options.add_argument('--window-size=1920,1080')
        driver = webdriver.Chrome(service=service, options=chrome_options)
        yield driver
        driver.quit()
    elif request.param == 'firefox':
        options = webdriver.FirefoxOptions()
        options.add_argument('--window-size=1920,1080')
        driver = webdriver.Firefox(options=options)
        yield driver
        driver.quit()

@pytest.fixture(scope="function")
def user():
    def generate_random_string(length):
        letters = string.ascii_lowercase
        random_string = ''.join(random.choice(letters) for i in range(length))
        return random_string

    email = generate_random_string(10) + '@yandex.ru'
    password = generate_random_string(10)
    name = generate_random_string(10)
    payload = {
        "email": email,
        "password": password,
        "name": name
    }
    response = requests.post(Constants.CREATE_USER_URL, data=payload)
    token = response.json()["accessToken"]
    user_data = {"email": email, "password": password}
    yield user_data
    requests.delete(Constants.DELETE_USER_URL, headers={'Authorization': token})

@pytest.fixture(scope="function")
def login_user(driver, user):
    login_page = LoginPage(driver)
    login_page.open_page(driver, Constants.LOGIN_PAGE_URL)
    login_page.add_text_to_element(LoginPageLocators.EMAIL_INPUT_FORM_LOGIN, user["email"])
    login_page.add_text_to_element(LoginPageLocators.PASSWORD_INPUT_FORM_LOGIN, user["password"])
    login_page.click_to_element(LoginPageLocators.LOGIN_BUTTON_LOGIN_PAGE)
    login_page.find_element_with_wait(MainPageLocators.ORDER_BUTTON_MAIN_PAGE)
    return login_user
