package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import model.weather.*;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;
    //  private WeatherDetails currentWeatherDetails;

    @Given("city ID is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude) {
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect latitude!");
    }

    @Then("longitude is {double}")
    public void longitude_check(double longtitude) {
        Assertions.assertEquals(longtitude, response.getLon(), "Incorrect longtitude!");
    }

    @Then("timezone is {string}")
    public void timezone_check(String timezone) {
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect timezone!");
    }

    @Then("timezone offset is {int}")
    public void timezone_offset_check(int offset) {
        Assertions.assertEquals(offset, response.getTimezoneOffset(), "Incorrect offset!");
    }

    @Then("current weather data is:")
    public void current_weather_data_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect daytime (dt)!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect sunrise time!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect sunset time!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect temperature!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getCurrent().getFeelsLike(), "Incorrect feels like temperature!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dewPoint")), response.getCurrent().getDewPoint(), "Incorrect dew point!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect uvi!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect clouds data!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect visibility data");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Incorrect wind speed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindSpeed(), "Incorrect wind speed!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Incorrect wind gust!");

    }

    @Then("current weather details are:")
    public void current_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect current weather details id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(1).getMain(), "Incorrect current weather details main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(2).getDescription(), "Incorrect current weather details description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(3).getIcon(), "Incorrect current weather details icon!");

    }

    @Then("minutely weather data is:")
    public void minutely_weather_data_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutely().get(0).getDt(), "Incorrect minutely dt!");
        Assertions.assertEquals(Double.parseDouble(params.get("precipitation")), response.getMinutely().get(1).getPrecipitation(), "Incorrect minutely precipitation!");

    }
    @Then("hourly weather data is:")
    public void hourly_weather_data_check(Map<String, String>params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourly().get(0).getDt(), "Incorrect hourly weather dt");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourly().get(1).getDt(), "Incorrect hourly weather temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourly().get(2).getDt(), "Incorrect hourly weather feels like");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourly().get(3).getDt(), "Incorrect hourly weather pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourly().get(4).getDt(), "Incorrect hourly weather humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourly().get(5).getDt(), "Incorrect hourly weather dewpoint");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourly().get(6).getDt(), "Incorrect hourly weather uvi");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourly().get(7).getDt(), "Incorrect hourly weather clouds");
        Assertions.assertEquals(Long.parseLong(params.get("visibility")), response.getHourly().get(8).getDt(), "Incorrect hourly weather visibility");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourly().get(9).getDt(), "Incorrect hourly wind speed");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_deg")), response.getHourly().get(10).getDt(), "Incorrect hourly wind deg");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourly().get(11).getDt(), "Incorrect hourly wind gust");
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getHourly().get(12).getPop(), "Incorrect hourly pop!");
    }
    @Then("hourly weather details are:")
    public void hourly_weather_details_check(Map<String,String>params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getHourly().get(0).getWeather().get(0), "Incorrect hourly weather deatils id!");
        Assertions.assertEquals(params.get("main"), response.getHourly().get(0).getWeather().get(1), "Incorrect hourly weather deatils main!");
        Assertions.assertEquals(params.get("description"), response.getHourly().get(0).getWeather().get(2), "Incorrect hourly weather deatils description!");
        Assertions.assertEquals(params.get("icon"), response.getHourly().get(0).getWeather().get(3), "Incorrect hourly weather deatils icon!");
    }
    @Then("daily details are:")
    public void daily_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDaily().get(0).getDt(), "Incorrect daily dt");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDaily().get(1).getSunrise(), "Incorrect daily sunrise");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDaily().get(2).getSunset(), "Incorrect daily sunset");
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDaily().get(3).getMoonrise(), "Incorrect daily moonrise");
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDaily().get(4).getMoonset(), "Incorrect daily moonset");
        Assertions.assertEquals(Double.parseDouble(params.get("moonphase")), response.getDaily().get(5).getMoonPhase(), "Incorrect daily moonphase");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getDaily().get(8).getPressure(), "Incorrect daily pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getDaily().get(8).getHumidity(), "Incorrect daily humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getDaily().get(8).getDewPoint(), "Incorrect daily humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getDaily().get(8).getWindSpeed(), "Incorrect daily wind speed");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_deg")), response.getDaily().get(8).getWindDeg(), "Incorrect daily wind deg");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getDaily().get(8).getWindGust(), "Incorrect daily wind deg");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getDaily().get(10).getClouds(), "Incorrect daily clouds");
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getDaily().get(10).getPop(), "Incorrect daily pop");
        Assertions.assertEquals(Double.parseDouble(params.get("rain")), response.getDaily().get(10).getRain(), "Incorrect daily rain");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getDaily().get(10).getUvi(), "Incorrect daily uvi");
    }
    @Then("detailed day's temperature is:")
    public void check_detailed_daily_weather_info(Map<String, String> params){
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDaily().get(6).getTemp().getDay(), "Inccorect daily day temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("min")), response.getDaily().get(6).getTemp().getMin(), "Incorrect daily min temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("max")), response.getDaily().get(6).getTemp().getMax(), "Incorrect daily max temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDaily().get(6).getTemp().getNight(), "Incorrect daily night temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDaily().get(6).getTemp().getEve(), "Incorrect daily evening temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDaily().get(6).getTemp().getMorn(), "Incorrect daily morning temperature");
    }
    @Then("daily feels like temperature is:")
    public void check_daily_feels_like_temp(Map<String, String> params){
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDaily().get(7).getFeelsLike().getDay(), "Incorrect daily day's feels like temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDaily().get(7).getFeelsLike().getNight(), "Incorrect daily night's feels like temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDaily().get(7).getFeelsLike().getEve(), "Incorrect daily evening feels like temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDaily().get(7).getFeelsLike().getMorn(), "Incorrect daily morning feels like temperature");
    }
    @Then("daily weather details are:")
    public void check_daily_weather_details(Map<String, String> params){
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getDaily().get(9).getWeatherDetails().getId(), "Incorrect daily weather details id");
        Assertions.assertEquals((params.get("main")), response.getDaily().get(9).getWeatherDetails().getMain(), "Incorrect daily weather details main");
        Assertions.assertEquals((params.get("description")), response.getDaily().get(9).getWeatherDetails().getDescription(), "Incorrect daily weather details main");
        Assertions.assertEquals((params.get("icon")), response.getDaily().get(9).getWeatherDetails().getIcon(), "Incorrect daily weather details main");
    }
    @Then("alerts are:")
    public void check_weather_alerts(Map<String,String> params){
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName(), "Incorrect sender name");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(1).getEvent(), "Incorrect event");
        Assertions.assertEquals(Long.parseLong(params.get("start")), response.getAlerts().get(1).getStart(), "Incorrect start");
        Assertions.assertEquals(Long.parseLong(params.get("end")), response.getAlerts().get(2).getEnd(), "Incorrect end");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(3).getDescription(), "Incorrect description");
        Assertions.assertEquals(params.get("tags"), response.getAlerts().get(4).getTags(), "Incorrect tags");
    }


}
