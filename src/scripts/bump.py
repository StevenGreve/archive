''' The code below will automatically execute the !d bump command every 2 hours to promote your server on disboard.org. '''

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome('C:\\Users\\Steve\\Desktop\\Python Projects\\Discord Bot\\bump bot\\chromedriver.exe')
driver.implicitly_wait(10)
driver.get('https://discord.com/login')

enter_email = driver.find_element_by_name('email').send_keys('enter your e-mail adress here')
enter_password = driver.find_element_by_name('password').send_keys('enter your password here')
driver.find_element_by_class_name("fullWidth-1orjjo").click()

time.sleep(5)

channel = driver.get('https://discord.com/channels/672079509264269357/733695865004359760')
chat = driver.find_element_by_xpath("//*[@id='app-mount']/div[2]/div/div[2]/div/div/div/div/div[2]/div/main/form/div/div/div/div/div[3]/div[2]/div")

def bump_message():
    chat.send_keys('!d bump')
    chat.send_keys(Keys.RETURN)
    time.sleep(7200)

while True:
    bump_message()
    