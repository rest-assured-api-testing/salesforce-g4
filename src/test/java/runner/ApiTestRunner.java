package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = ("steps")
)
@Test
public class ApiTestRunner extends AbstractTestNGCucumberTests {


}
