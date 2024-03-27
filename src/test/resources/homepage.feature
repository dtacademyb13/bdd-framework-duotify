Feature: Music Streaming App Homepage
  As a music lover, I want to be able to access and explore music easily through a music streaming app.
  The homepage of the app should display 9 albums on the main page and
  have a left sidebar with links to Search, Browse, Your Music, and Edit User profile options.

  @homepage
  Scenario: User opens the app and sees the welcome message
    Given the user is on the homepage of the music streaming app
    Then the user should see the welcome message