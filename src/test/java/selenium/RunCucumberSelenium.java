package selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hallur
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"src/test/resources/selenium"})
public class RunCucumberSelenium {
}
