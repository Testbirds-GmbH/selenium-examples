/*
 * Copyright 2016 Testbirds GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * A simple Selenium example test with JUnit.
 *
 * @author testbirds
 */
public class SimpleExampleTest {

    /**
     * The WebDriver, used by the tests.
     */
    private WebDriver driver;

    /**
     * Setup before test.
     *
     * @throws MalformedURLException
     *             If the hub URL is malformed.
     */
    @Before
    public void beforeTest() throws MalformedURLException {
        // Request WebDriver instance from TeCh Selenium to start the VM.
        final URL hub = new URL("http://localhost:4444/wd/hub");
        final DesiredCapabilities capas = DesiredCapabilities.chrome();
        this.driver = new RemoteWebDriver(hub, capas);
    }

    /**
     * Test the title of our demo page.
     */
    @Test(timeout = 300000)
    public void testTitle() {
        driver.get("https://demo.testchameleon.com/");
        assertThat(driver.getTitle(), containsString("Gentellela Alela!"));
    }

    /**
     * Cleanup after test.
     */
    @After
    public void afterTest() {
        // Close the WebDriver instance to stop the VM.
        driver.quit();
    }
}
