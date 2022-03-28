package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/features"}
            ,glue={"stepdefinitions","utility"}
            ,plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt",
            "html:target/cucumber-reports/raw-cucumber-html-report.html",
            "json:target/report.json"}, tags=("@apitest or uitest")
    )
   public class RunnerTest {

}

