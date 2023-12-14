package co.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\customers.feature",
                 glue="co.stepDefinition",
                 dryRun=false,monochrome=true,
                 plugin= {"pretty","html:test-output/repto.html"}
                )
public class RunnerClass {

}
