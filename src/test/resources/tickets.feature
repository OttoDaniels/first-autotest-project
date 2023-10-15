Feature: Air Ticket Booking

  Scenario: Successfull ticket booking
    Given airports:
      | from | RIX |
      | to   | JFC |
    And passenger info is:
      | first_name | random |
      | last_name  | Otto   |

    And flight info is:
      | discount        | ccccc      |
      | passenger_count | 2          |
      | child_count     | 1          |
      | luggage_count   | 3          |
      | flight_date     | 12-05-2018 |
      | seat_number     | 13         |

    And home page is opened

    When we are selecting airport

    Then selected airports appears on the passenger info page

    When we are filling in passenger info
    And requesting price
    Then airports and price appears in flight details

    When we are confirming reservation
    And selecting seat number
    Then selected seat number appears
    When we are confirming reservation after seat selection
    Then successfull registration message appears

    When we are requesting all reservations via API
    Then current reservation exists in the list
    And all data are stored correctly
