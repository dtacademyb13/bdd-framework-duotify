Feature: Album features


  Background:
    Given the user is on the login page
    And the user enters valid username and password
    And the user should be directed to the personal dashboard

 @softAssertions
  Scenario: Verify album details

    When the user clicks on the album "Cruel Summer"
    Then the album details should be the following
      | name      | Cruel Summer |
      | author    | Ace Of Base  |
      | songCount | 1            |


  @albumDetails
  Scenario: Verify album details
    When the user clicks on the album "Escape"
    Then the album should have the following info
      | name   | author           | songCount |
      | Escape | Enrique Iglesias | 5         |


  @allAlbums
    Scenario Outline: Verify all albums details
    When the user clicks on the album "<album>"
    Then the album should have the following info
      | name    | author   | songCount |
      | <album> | <artist> | <songCt>  |


    Examples:
      | album                | artist           | songCt |
      | Escape               | Enrique Iglesias | 5      |
      | Fenix                | Nicky Jam        | 1      |
      | Ultimatum            | Disclosure       | 1      |
      | Cruel Summer         | Ace Of Base      | 1      |
      | I am Sasha Fierce    | Beyonce          | 1      |
      | Oscillation          | Four Tet         | 1      |
      | Clouds               | Miguel Migs      | 1      |
      | Werk                 | Maya Jane Coles  | 1      |





  Scenario: Exceptions demo
    Given I have some pre-requisites
#
#  Scenario: Verify album songs details
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on the album "Escape"
#    Then the album songs should have the following info
#      | Escape                    | Enrique Iglesias | 2:56 |
#      | Hero                      | Enrique Iglesias | 2:56 |
#      | Maybe                     | Enrique Iglesias | 2:56 |
#      | Don't Turn Off The Lights | Enrique Iglesias | 2:56 |
#      | Escapar                   | Enrique Iglesias | 2:56 |
#  @album
#  Scenario: Verify album songs details
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on the album "Werk"
#    Then the album songs should have the following info
#      | Whirls                    | Maya Jane Coles | 2:56 |