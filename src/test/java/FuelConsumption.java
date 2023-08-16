import model.Vehicle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FuelConsumption {
    @Test

    public void fuelConsumption() {
        double routeRange = 2456;
        Vehicle plane = new Vehicle();
        plane.setFuelConsumptionPer100KM(40.1);
        plane.setType("Plane");
        plane.calcFuelConsumption(routeRange);

        Vehicle train = new Vehicle();
        train.setFuelConsumptionPer100KM(20.5);
        train.setType("Train");
        train.calcFuelConsumption(routeRange);

        Vehicle car = new Vehicle();
        car.setType("Car");
        car.setFuelConsumptionPer100KM(9);
        car.calcFuelConsumption(routeRange);
    }

}
