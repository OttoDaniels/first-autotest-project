import model.Country;
import org.junit.jupiter.api.Test;

public class CountryOverview {

    @Test
    public void creatingCountryOverview() {
        Country latvia = new Country();
        latvia.setName("Latvia");
        latvia.setCountryCode("+371");
        latvia.setFlagColor("red white red");
        latvia.setArea(64589000);
        latvia.setPopulation(1884000);
        latvia.setSeaBorder(true);

        latvia.countryProperties();
    }

}
