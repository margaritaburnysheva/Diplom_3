from selenium.webdriver.common.by import By


class OrderFeedListPageLocators:
    #локаторы на странице "Лента заказов"
    TITLE_ORDER_FEED_LIST_LOCATOR = (By.XPATH, './/h1[text()="Лента заказов"]') #заголовок "Лента заказов"
    TOTAL_ORDER_COUNTER = (By.XPATH, './/*[text()="Выполнено за все время:"]//following-sibling::*') #счетчик "Выполнено за все время"
    TODAY_ORDER_COUNTER = (By.XPATH, './/*[text()="Выполнено за сегодня:"]//following-sibling::*') #счетчик "Выполнено за сегодня"
    FIRST_ORDER_LOCATOR = (By.XPATH, './/*[@class="OrderFeed_contentBox__3-tWb"]/ul/li[1]') #локатор первого заказа в ленте заказов
    FIRST_ORDER_DETAILS_LOCATOR = (By.XPATH, './/*[@class="App_App__aOmNj"]/section[2]') #локатор модального окна с деталями первого заказа
    ORDERS_IN_PROCESSING_LOCATOR = (By.XPATH, './/*[contains(@class,"text text_type_digits-default")]//parent::*[contains(@class,"OrderFeed_orderListReady")]') #локатор заказов "В работе"
