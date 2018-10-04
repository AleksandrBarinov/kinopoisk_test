package ru.kinopoisk.util;

import gherkin.formatter.model.Result;
import ru.kinopoisk.hooks.Hooks;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {
    @Override
    public void result(Result result){
        if (result.getStatus().equals("failed")){
            Hooks.makeScreenshot();
        }
        super.result(result);
    }
}