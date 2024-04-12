Feature: Business Rules scenarios

 @business_rule @db_only
  Scenario: Verify genres
    Then  "name" column for "genres" table should have the following:
      | rap        |
      | pop        |
      | techno     |
      | rnb        |
      | house      |
      | classical  |
      | jazz       |
      | electronic |
      | dance      |
      | reggae     |
      | reggaeton  |

