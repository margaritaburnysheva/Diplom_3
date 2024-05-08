import pytest
import requests
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

from constants import Constants
from helpers.helpers import Helpers
from pages.login_page import LoginPage


@pytest.fixture(scope="function", params=['chrome', 'firefox'])
def driver(request):
    if request.param == 'chrome':
        service = Service(ChromeDriverManager().install())
        chrome_options = webdriver.ChromeOptions()
        chrome_options.add_argument('--window-size=1920,1080')
        driver = webdriver.Chrome(service=service, options=chrome_options)
    elif request.param == 'firefox':
        options = webdriver.FirefoxOptions()
        options.add_argument('--window-size=1920,1080')
        driver = webdriver.Firefox(options=options)
    yield driver
    driver.quit()

@pytest.fixture(scope="function")
def user():
    helpers = Helpers()
    payload = helpers.generate_random_pass()
    response = requests.post(Constants.CREATE_USER_URL, data=payload)
    token = response.json()["accessToken"]
    user_data = {"email": payload["email"], "password": payload["password"]}
    yield user_data
    requests.delete(Constants.DELETE_USER_URL, headers={'Authorization': token})

@pytest.fixture(scope="function")
def login_user(driver, user):
    login_page = LoginPage(driver)
    login_page.user_login(user)
