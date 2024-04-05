Feature: Examples of cucumber features


  Scenario:  Cucumber parameter examples
    Given  I have 100 cucumbers in my belly
    And I also have 3000000000 tomatoes
    And I have a cucumber of type 'mexican'
    When I add 100.5 more
    Then I should have 200.5 cucumbers
    And I should have also have some squashes
    And I should have also have some cherries
    And I should have also have some berries
    And I ate some bananas
    And I ate no banana
    And I pass this SQL query
    """
    FROM employees e
-- to get title of current job_id
  JOIN jobs j
    ON e.job_id = j.job_id
-- to get name of current manager_id
  LEFT JOIN employees m
    ON e.manager_id = m.employee_id
-- to get name of current department_id
  LEFT JOIN departments d
    ON d.department_id = e.department_id
-- to get name of manager of current department
-- (not equal to current manager and can be equal to the employee itself)
  LEFT JOIN employees dm
    ON d.manager_id = dm.employee_id
-- to get name of location
  LEFT JOIN locations l
    ON d.location_id = l.location_id
  LEFT JOIN countries c
    ON l.country_id = c.country_id
  LEFT JOIN regions r
    ON c.region_id = r.region_id
-- to get job history of employee
  LEFT JOIN job_history jh
    ON e.employee_id = jh.employee_id
-- to get title of job history job_id
  LEFT JOIN jobs jj
    ON jj.job_id = jh.job_id
-- to get namee of department from job history
  LEFT JOIN departments dd
    ON dd.department_id = jh.department_id

    """
#   And I have another step


  Scenario: Cucumber Data Table as List

    When I pass the following user information
      | duotech9999           |
      | Duotech               |
      | Academy               |
      | duotech2029@gmail.com |
      | duotech2024           |

#    single column represents List


  Scenario: Cucumber Data Table as Map

    When I pass the following user information map
      | username  | duotech9990           |
      | firstName | Duotech               |
      | lastName  | Academy               |
      | email     | duotech2067@gmail.com |
      | password  | duotech2024           |

#    two columns represent Map



  Scenario: Cucumber Data Table as List of lists

    When I pass the following user information list of lists
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |


#    table can be represented as List<List<String>>



  Scenario: Cucumber Data Table as List of maps

    When I pass the following user information list of maps
      | firstName   | lastName | birthDate  |
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |


#    table can be represented as List<Map<String, String>> where the first row values are used as keys



  Scenario: Cucumber Data Table as map with value as list

    When I pass the following user information map with value as list

     | 1 | Annie M. G. | Schmidt  | 1911-03-20 |
     | 2 | Roald       | Dahl     | 1916-09-13 |
     | 3  | Astrid      | Lindgren | 1907-11-14 |

#    table can be represented as Map<String, List<String>>



  Scenario: Cucumber Data Table common mistakes

    When I pass the following user information as a list
#        DON'T DO THIS
      | duotech9999 | Duotech | Academy | duotech2029@gmail.com | duotech2024 |

  @test
  Scenario Outline: Cucumber Scenario Outline Demo

    Given I have <count> cucumbers and "<fruit>"
    When I sell <portion> of the cucumbers
    Then I should have <finalAmount> left

    Examples:
      | count | fruit   | portion | finalAmount |
      | 10    | apples  | 2       | 8           |
      | 20    | bananas | 5       | 15          |
      | 3     | kiwis   | 3       | 0           |




   @sharingData
  Scenario: Sharing data
    Given I have 100 cucumbers
    When I sell 73  cucumbers
    Then I should have the correct amount left

@demo
  Scenario: Exceptions demo
  #  Example of a duplicate step definition exception
  Given I have some pre-requisites
    When I perform some action
    Then I should have the expected result
#  Example of an ambiguous step definition exception
   When I sell 5 bananas
   And I sell 5000000000 bananas
  When I consume lots of "cucumbers"
  And I consume lots of tomatoes


