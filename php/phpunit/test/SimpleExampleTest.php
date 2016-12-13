<?php
// Copyright 2016 Testbirds GmbH
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

 /**
  * A simple example Selenium test with PHPUnit.
  *
  * @author testbirds
  */
class SimpleExampleTest extends PHPUnit_Framework_TestCase {

	/**
	 * @var \RemoteWebDriver The WebDriver, used by the tests.
	 */
	protected $webDriver;

	/**
	 * Setup before test.
	 */
	public function setUp()
	{
		// use capabilities to specifiy OS, software packages and browser
		$tech_os = '{"family":"WIN", "version":"6.1 SP1", "arch":"X86"}';
		$tech_software ='[{"name":"chrome","version":"","arch":""}]';
		$capabilities = array(
			\WebDriverCapabilityType::BROWSER_NAME => 'chrome',
			'tech_os' => $tech_os,
			'tech_software' => $tech_software
		);

		// higher timeout due to time required for starting the VM
		$connection_timeout_in_ms = 300000;
		$request_timeout_in_ms = 300000;
		// request WebDriver instance from TeCh Selenium to start the VM
		$this->driver = RemoteWebDriver::create(
			'http://localhost:4444/wd/hub', $capabilities,
			$connection_timeout_in_ms, $request_timeout_in_ms);
	}

	/**
	 * Test if the title of our demo page is correct.
	 */
	public function testTitle()
	{
		$this->driver->get('https://demo.testchameleon.com/');
		$this->assertContains('Gentellela Alela!', $this->driver->getTitle());
	}

	/**
	 * Cleanup after test.
	 */
	public function tearDown()
	{
		$this->driver->quit();
	}
}
?>
