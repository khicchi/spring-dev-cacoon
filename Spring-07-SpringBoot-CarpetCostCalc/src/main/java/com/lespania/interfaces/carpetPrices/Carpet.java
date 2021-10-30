package com.lespania.interfaces.carpetPrices;
import com.lespania.enums.City;

import java.math.BigDecimal;

public interface Carpet {

    BigDecimal getSqFtPrice(City city);
}
