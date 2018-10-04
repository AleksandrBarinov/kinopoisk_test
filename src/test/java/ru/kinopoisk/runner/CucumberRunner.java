package ru.kinopoisk.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/java/ru/kinopoisk/tests"}, glue = {"ru.kinopoisk"},
    plugin = {"ru.kinopoisk.util.AllureReporter"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}