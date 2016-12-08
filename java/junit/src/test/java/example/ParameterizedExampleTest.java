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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * The Selenium example test with JUnit.
 *
 * @author testbirds
 */
@RunWith(Parameterized.class)
public class ParameterizedExampleTest {

    /**
     * The capabilities.
     */
    private final DesiredCapabilities capas;

    /**
     * The web driver.
     */
    private WebDriver driver;

    /**
     * Data for parametrized testcase.
     *
     * @return the test data collection
     */
    @Parameters(name = "{index}: {0}")
    public static Collection<DesiredCapabilities> data() {
        final List<DesiredCapabilities> tests = new ArrayList<DesiredCapabilities>();
        DesiredCapabilities capas = new DesiredCapabilities();
        capas.setCapability("tech_os", "{\"family\":\"WIN\", \"version\":\"6.1 SP1\", \"arch\":\"X86\"}");
        capas.setCapability("tech_software", "[{\"name\":\"firefox\",\"version\":\"46\",\"arch\":\"\"}]");
        capas.setBrowserName(BrowserType.FIREFOX);
        tests.add(capas);

        capas = new DesiredCapabilities();
        capas.setCapability("tech_os", "{\"family\":\"WIN\", \"version\":\"6.1 SP1\", \"arch\":\"X86\"}");
        capas.setCapability("tech_software", "[{\"name\":\"chrome\",\"version\":\"\",\"arch\":\"\"},"
                + "{\"name\":\"selenium-chrome-driver\",\"version\":\"\",\"arch\":\"\"}]");
        capas.setBrowserName(BrowserType.CHROME);
        tests.add(capas);

        capas = DesiredCapabilities.edge();
        tests.add(capas);

        capas = DesiredCapabilities.internetExplorer();
        tests.add(capas);

        capas = DesiredCapabilities.chrome();
        tests.add(capas);

        capas = DesiredCapabilities.firefox();
        capas.setCapability("marionette", true);
        tests.add(capas);

        return tests;
    }

    /**
     * Instantiates a new selenium example test.
     *
     * @param capas
     *            the capabilities
     */
    public ParameterizedExampleTest(final DesiredCapabilities capas) {
        this.capas = capas;
    }

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
        driver.quit();
    }
}
