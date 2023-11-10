package com.wolters_kluwer.automation_framework;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
	glue = "com.wolters_kluwer.automation_framework.step_definitions", 
	plugin = {
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
			})
public class TestRunner {

}
