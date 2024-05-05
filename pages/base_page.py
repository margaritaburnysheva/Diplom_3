from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from seletools.actions import drag_and_drop


class BasePage:
    def __init__(self, driver):
        self.driver = driver

    def find_element_with_wait(self, locator):
        (WebDriverWait(self.driver, 15).until(
            expected_conditions.visibility_of_element_located(locator)))
        return self.driver.find_element(*locator)

    def click_to_element(self, locator):
        (WebDriverWait(self.driver, 15).until(
            expected_conditions.element_to_be_clickable(locator)))
        self.driver.find_element(*locator).click()

    def add_text_to_element(self, locator, text):
        self.find_element_with_wait(locator).send_keys(text)

    def get_text_from_element(self, locator):
        return self.find_element_with_wait(locator).text

    def open_page(self, driver, url):
        driver.get(url)

    def get_element_attribute(self, locator, attribute):
        return self.find_element_with_wait(locator).get_attribute(attribute)

    def add_ingredients_to_basket(self, driver, basket_locator, ingredient_locator):
        basket = self.find_element_with_wait(basket_locator)
        ingredient = self.find_element_with_wait(ingredient_locator)
        return drag_and_drop(driver, ingredient, basket)

    def switch_to_window(self, locator, num):
        new_window = self.driver.window_handles[num]
        self.driver.switch_to.window(new_window)
        return self.find_element_with_wait(locator)
