Feature:Get Feature

  Background: User is on the main Page
    Given A new Driver has been initialized
    And Main page has loaded
    Then User sees the displayed Content

  Scenario:
    Given The user accessed the BaseURI
    Then The following parameters are passed
      | key                                     | location                | radius | type       | keyword |
      | AIzaSyBXvxsZKeww6vEkG_lGHToVOfTuWbnn6ns | -33.8670522,151.1957362 | 1500   | restaurant | cruise  |
    And User sends GET request
    Then Status code should be 200 with content of type JSON


