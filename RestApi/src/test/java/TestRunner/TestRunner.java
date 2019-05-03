package TestRunner;


import cucumber.api.cli.Main;


public class TestRunner {

    public static void main(String[] args) {

        Main.main(new String[]
                {"--threads", "4",
                        "-g", "stepDefinitions",
                        "-p", "html:target/cucumber-parallel-report",
                        "-p", "json:target/cucumber-parallel-report/raportJmecher.json",
                        "-m",
                        "src/test/java/Features/"}
        );
    }
}