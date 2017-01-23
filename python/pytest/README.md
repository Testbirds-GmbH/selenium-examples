# Python pytest Example Project

This folder contains an example Python project that uses Selenium and pytest to perform automated web tests on virtual machines that run on TestChameleon™.

## Requirements

To be able to execute these examples you need

* Python (2.x or 3.x)
* and optionally the virtualenv package

as well as a running instance of TestChameleon™ Selenium (simply follow [this setup](https://confluence.testbirds.com/display/TED/Setup)).

## Setup

### Setup a virtual environment (optional)
Create a virtual environment for the version of python that you want to use (with the `-p` switch) and activate it

e.g. for python3 and bash execute
```bash
virtualenv -p python3 venv
source venv/bin/activate
```

### Install dependencies

Navigate to this folder and run

```bash
pip install -r requirements.txt
```

to install all dependencies

## Test Execution

Navigate to this folder and run

```bash
pytest
```
