var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

describe('basic test', function () {
	var driver;
	it('should get the driver', function (done) {
		driver = new webdriver.Builder()
		.forBrowser('chrome')
		.usingServer('http://localhost:4444/wd/hub')
		.build();
		expect(driver).not.toBeNull();
		done();
	});

	it('should be on correct page', function (done) {
		driver.get('https://demo.testchameleon.com/');
		driver.getTitle().then(function(title) {
			expect(title).toBe('Gentellela Alela! |');
			// Jasmine waits for the done callback to be called before proceeding to next specification.
			done();
		});
		driver.quit();
	// Increase the timeout limit since the virtual machines need some time to bootup
	}, 99999999);
});
