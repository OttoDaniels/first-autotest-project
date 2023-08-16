import model.Market;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MarketOverview {

    @Test //Annotation enters with @
    public void creatingAndUsingOwnObject() {
        Market danielShop = new Market();
        danielShop.setMarketLabel("Daniel's Shop");
        danielShop.setDoors(4);
        danielShop.setArea(1200);
        danielShop.setEmployees(10);
        danielShop.setCashDesk(4);
        danielShop.setDiscount(true);

        danielShop.showShopOverview();

//        Market danielShop2 = new Market();
//        danielShop2.setMarketLabel("Daniel's Shop2");
//        danielShop2.setDoors(4);
//        danielShop2.setArea(800);
//        danielShop2.setEmployees(10);
//        danielShop2.setCashDesk(4);
//        danielShop2.setDiscount(true);
//
//        danielShop2.showShopOverview();
//
//        Market danielShop3 = new Market();
//        danielShop3.setMarketLabel("Daniel's Shop3");
//        danielShop3.setDoors(4);
//        danielShop3.setArea(600);
//        danielShop3.setEmployees(10);
//        danielShop3.setCashDesk(4);
//        danielShop3.setDiscount(true);
//
//        ArrayList<Market> allShops = new ArrayList<>(); //ArrayList - список магазинов
//        allShops.add(danielShop); // adding first shop
//        allShops.add(danielShop2); //adding second shop
//        allShops.add(danielShop3); // adding third shop
//        showTotalOverview(allShops);
    }

//    public void showTotalOverview(ArrayList<Market> markets) { //provide method with a list of shops
//        BigDecimal totalArea = BigDecimal.ZERO; //set starting point of area is 0
//
//        for (Market market : markets) { //2 shops, 2 loops
//            System.out.println("adding area of: " + market.getMarketLabel());
//            totalArea = totalArea.add(BigDecimal.valueOf(market.getArea()));
//        }
//
//        System.out.println("Total area of shops: " + totalArea);
//    }
}
