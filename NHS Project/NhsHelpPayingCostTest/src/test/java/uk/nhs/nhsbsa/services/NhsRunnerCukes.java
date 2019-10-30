package uk.nhs.nhsbsa.services;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = false,
        plugin = {
                "pretty",
                "html:target\\test-report\\html.report",
                "junit:target\\test-report\\junit.report",
                "json:target\\test-report\\json.report",
        },
        snippets = SnippetType.CAMELCASE,
        features = {"src\\test\\resources\\nhsPayCheckerFeatures"},
        tags = {"@wip"}
)
public class NhsRunnerCukes {
}
