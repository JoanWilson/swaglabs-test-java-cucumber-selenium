package br.ce.joanwilson.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features/",
        glue = "br.ce.joanwilson",
        tags = "@funcionais",
        plugin = {
                "pretty",
                "html:target/report-html",
                "json:target/report.json"
        },
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class Runner {
}
