package salesforce.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.ReportingUtil;

/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

@CucumberOptions(
 glue = {"src/test/java/salesforce"}  ,
 features = {"src/test/resources/features"}
 )
public class ApiTestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void beforeExecution(){
        System.out.println("-------------beforeExecution------------------");
    }

    @AfterTest
    public void afterExecution(){
        System.out.println("-----------afterExecution-------------");
    }

    @AfterSuite
    public void generateReport(){
        ReportingUtil.generateReport();
    }
}
