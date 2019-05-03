package StepDefnitions;

import Utils.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.mustache.Value;

import javax.xml.ws.Response;

import java.security.Key;
import java.util.List;
import java.util.Map;

import static Driver.Driver.getDriver;
import static io.restassured.RestAssured.given;

public class GETRequestStepDef {
    Response response;

    //Background Pre-Definition Steps
    @Given("^A new Driver has been initialized$")
    public void a_new_driver_has_been_initialized() throws Throwable {
        getDriver().navigate().to(Constants.BASE_URI);
        getDriver().manage().window().maximize();
        String title = getDriver().getTitle();
        System.out.println(title + " is ");
    }

    @And("^Main page has loaded$")
    public void main_page_has_loaded() throws Throwable {
        String url = getDriver().getCurrentUrl();
        System.out.println("url is " + url);


    }

    @Then("^User sees the displayed Content$")
    public void user_sees_the_displayed_content() throws Throwable {
        System.out.println("Content Displayed");

    }
//Background Ends

    @Given("^The user accessed the BaseURI$")
    public void the_user_accessed_the_baseuri() throws Throwable {

    }

    @Then("^The following parameters are passed$")
    public void the_following_parameters_are_passed(DataTable arg1) throws Throwable {

        Map<String, String> table = arg1.asMap(String.class, String.class);
        given().
                param(table.get(0), table.get(0)).
                param(table.get(1), table.get(1)).
                param(table.get(2), table.get(2)).
                param(table.get(3), table.get(3)).
                when().
                get(Constants.GET_RESOURCES_PATH);
        System.out.println(response);
    }

    @Then("^Status code should be 200 with content of type JSON$")
    public void status_code_should_be_200_with_content_of_type_json() throws Throwable {

    }

    @And("^User sends GET request$")
    public void user_sends_get_request() throws Throwable {

    }
}
