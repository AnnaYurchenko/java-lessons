package java.edu.lessons.part1.interfaces;

import java.math.BigDecimal;

public interface Snowboard extends Comparable<Snowboard>, Sellable {

    float getSnowboardLength();

    String getSnowboardFlex();

    String getSnowboardShape();

    BigDecimal getSnowboardPrice();

}
