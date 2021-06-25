package salesforce.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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

public class ApiTestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void beforeExecution(){
        System.out.println("-------------beforeExecution------------------");
    }

    @AfterTest
    public void afterExecution(){
        System.out.println("-----------afterExecution-------------");
    }
}