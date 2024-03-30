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

  @test
  Scenario: Cucumber Data Table as List

    When I pass the following user information
      | duotech9999           |
      | Duotech               |
      | Academy               |
      | duotech2029@gmail.com |
      | duotech2024           |

#    single column represents List
