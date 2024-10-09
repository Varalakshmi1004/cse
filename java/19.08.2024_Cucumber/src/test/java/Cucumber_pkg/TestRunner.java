package Cucumber_pkg;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/f2.feature",
		glue="Cucumber_pkg",
		tags="@search"		
		)


public class TestRunner {

}
