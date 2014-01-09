Feature: pytweet app

  Scenario: App name in homepage
    Given the app is running
     When I go to the homepage
     Then I see the app name is "PyTweet"

  Scenario: Creating a new user
    Given the app is running
     When I create a new account "tweetie" with password "bird"
     Then I should see a message "Successfully created account tweetie"

  Scenario: Cannot create user with the same name
    Given the app is running
      And there's an account "joe" with password "abc"
     When I create a new account "joe" with password "fail!"
     Then I should see a message "There&#39;s already an user with the name of joe"
