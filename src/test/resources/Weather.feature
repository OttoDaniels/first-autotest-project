Feature: Weather forecast

  Scenario: Full weather info checks
    Given city ID is 12345

    When we are requesting weather forecast

    Then latitude is 39.31
    And longitude is -74.5
    And timezone is "America/New_York"
    And timezone offset is -18000

    And current weather data is:
      | dt         | 1646318698 |
      | sunrise    | 1646306882 |
      | sunset     | 1646347929 |
      | temp       | 282.21     |
      | feels_like | 278.41     |
      | pressure   | 1014       |
      | humidity   | 65         |
      | dew_point  | 275.99     |
      | uvi        | 2.55       |
      | clouds     | 40         |
      | visibility | 10000      |
      | wind_speed | 8.75       |
      | wind_deg   | 360        |
      | wind_gust  | 13.89      |

    And current weather details are:
      | id          | 802             |
      | main        | Clouds          |
      | description | scatteredclouds |
      | icon        | 03d             |

    And minutely weather data is:
      | dt            | 1646318700 |
      | precipitation | 0          |

    And hourly weather data is:
      | dt         | 1646316000 |
      | temp       | 281.94     |
      | feels_like | 278.49     |
      | pressure   | 1014       |
      | humidity   | 67         |
      | dew_point  | 276.16     |
      | uvi        | 1.49       |
      | clouds     | 52         |
      | visibility | 10000      |
      | wind_speed | 7.16       |
      | wind_deg   | 313        |
      | wind_gust  | 10.71      |
      | pop        | 0.03       |


    And hourly weather details are:
      | id          | 803          |
      | main        | Clouds       |
      | description | brokenclouds |
      | icon        | 04d          |



    And daily details are:
      | dt         | 1646326800 |
      | sunrise    | 1646306882 |
      | sunset     | 1646347929 |
      | moonrise   | 1646309880 |
      | moonset    | 1646352120 |
      | moon_phase | 0.03       |

    And detailed day's temperature is:
      | day        | 281.63 |
      | min        | 271.72 |
      | max        | 282.21 |
      | night      | 271.72 |
      | eve        | 277.99 |
      | morn       | 280.92 |
      | pressure   | 1016   |
      | humidity   | 55     |
      | dew_point  | 273.12 |
      | wind_speed | 9.29   |
      | wind_deg   | 3      |
      | wind_gust  | 16.48  |
      | clouds     | 49     |
      | pop        | 0.25   |
      | rain       | 0.11   |
      | uvi        | 3.38   |

    And daily feels like temperature is:
      | day   | 277.83 |
      | night | 264.72 |
      | eve   | 273.35 |
      | morn  | 277.66 |


    And daily weather details are:
      | id          | 500       |
      | main        | Rain      |
      | description | lightrain |
      | icon        | 10d       |




    And alerts are:
      | sender_name | NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania) |
      | event       | SmallCraftAdvisory                                                      |
      | start       | 1646344800                                                              |
      | end         | 1646380800                                                              |
      | description | ...SMALLCRAFTADVISaft.                                                  |
      | tags        |                                                                         |


