package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        plugin = {"pretty","summary","json:target/cucumber-reports/cucumber-html-reports/report.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

       // tags = "@iPhoneCheckout_test"
        //tags = " @dailyDeals_test"
       // tags = "@camerasBrand_test"
       // tags = "@findbooksStores_test"
       // tags = "@careers_test"
      // tags = "@filtering_test"
       // tags = "@productRemoved_test"
       // tags = " @policies_test"
       // tags = "@ukdomainprice_test"
       //tags = "@eBayratecard_test"
)

public class RunnerTest {
}
