package com.after_sunrise.cryptocurrency.bitflyer4j.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
public interface Execution {

    Long getId();

    String getSide();

    BigDecimal getPrice();

    BigDecimal getSize();

    ZonedDateTime getTimestamp();

    String getBuyOrderId();

    String getSellOrderId();

}
