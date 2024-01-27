# Culenium

Cucumber + Selenium project.

## Features

[Culenium](src/features/Culenium.feature)

## Run Configurations

* Service Tests (Cucumber)
  * VM arguments: -ea
  * Class: CucumberIT
  * Run Unit Tests first

* Service Tests (Cucumber - WIP)
  * VM arguments: -ea -Dcucumber.filter.tags="@WIP"
  * Class: CucumberIT
  * Run Unit Tests first

* Unit Tests
  * All in src/test/java
