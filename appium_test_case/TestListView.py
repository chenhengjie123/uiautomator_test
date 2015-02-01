import os
from time import sleep

import unittest

from appium import webdriver
import appium

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)


class SimpleAndroidTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.4'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['app'] = PATH(
            '../app/chjapp/app/build/outputs/apk/app-debug.apk'
        )

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_find_element_in_list_view_with_scroll(self):
        # find element by using uiautomator's getChildByText() of UiScrollable
        # http://developer.android.com/tools/help/uiautomator/UiScrollable.html
        view_description = "lv_def"
        element_class = "android.widget.TextView"
        element_text = "test view15"

        list_view_locator = 'new UiScrollable(new UiSelector().description("{}"))'.format(view_description)
        element_locator = 'new UiSelector().className("{}"), "{}"'.format(element_class, element_text)
        uiautomator_string = '{}.getChildByText({});'.format(list_view_locator, element_locator)

        # test_data_15 = self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().description("lv_def")).getChildByText(new UiSelector().className("android.widget.TextView"), "test view15");')
        test_data_15 = self.driver.find_element_by_android_uiautomator(uiautomator_string)
        test_data_15.click()


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)