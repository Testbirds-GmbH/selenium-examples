#--
# Copyright 2016 Testbirds GmbH
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#++

require "selenium/webdriver"
require "test/unit"

# A simple example Selenium test with Test::Unit.
#
# Author:: testbirds
class RubySimpleTest < Test::Unit::TestCase

    # Setup before test.
    def setup
        # use capabilities to specifiy the browser
        capabilities = {
          :javascriptEnabled => TRUE,
          :platform => 'ANY',
          :browserName => 'chrome',
          :version => ''
        }

        # higher timeout to give the VM enough time to get ready 
        client = Selenium::WebDriver::Remote::Http::Default.new
        client.timeout = 300 # in seconds

        # request WebDriver instance from TeCh Selenium to start the VM
        @driver = Selenium::WebDriver.for(:remote,
            :url => "http://localhost:4444/wd/hub",
            :desired_capabilities => capabilities,
            :http_client => client)
    end

    # Test if the title of our demo page is correct.
    def test_title
        @driver.navigate.to "https://demo.testchameleon.com/"
        assert(@driver.title.include? "Gentellela Alela!")
    end

    # Cleanup after test.
    def teardown
        @driver.quit
    end
end
