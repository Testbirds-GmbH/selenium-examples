# PHP PHPUnit Example Project

This folder contains an example PHP project that uses Selenium and PHPUnit to perform automated web tests on virtual machines that run on TestChameleon™.

## Requirements

You need

* PHP 7

as well as a running instance of TestChameleon™ Selenium (simply follow [this setup](https://confluence.testbirds.com/display/TED/Setup)).

## Usage

### Setup

Navigate into the folder and run

```
sudo apt-get install php-xml
sudo apt-get install php-curl
wget https://getcomposer.org/installer
php installer
php composer.phar install
```

to install the necessary dependencies with [Composer](https://getcomposer.org/)

### Test Execution

Now you can run the test with

```
vendor/bin/phpunit test/SimpleExampleTest.php
```
