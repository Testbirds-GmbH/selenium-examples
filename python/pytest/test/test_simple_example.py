#!/usr/bin/env python
"""Simple Selenium WebDriver test that uses TestChameleon Selenium"""

import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

__author__ = "Testbirds GmbH"
__copyright__ = "Copyright 2017 Testbirds GmbH"
__credits__ = ["Testbirds GmbH"]

__license__ = "Apache License"
__version__ = "2.0"
__maintainer__ = "Testbirds GmbH"
__email__ = ""
__status__ = ""

class PythonPytestSimpleTest(unittest.TestCase):
    """A simple Selenium example test with Python and pytest."""

    def setUp(self):
        """Setup before test."""
        capas = DesiredCapabilities.FIREFOX
        self.driver = webdriver.Remote(desired_capabilities=capas)

    def test_title(self):
        """Test the title of our demo page."""
        self.driver.get("https://demo.testchameleon.com/")
        assert "Gentellela Alela!" in self.driver.title

    def tearDown(self):
        """Cleanup after test."""
        self.driver.quit()


if __name__ == "__main__":
    unittest.main()
