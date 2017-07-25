package com.after_sunrise.cryptocurrency.bitflyer4j.entity.impl;

import com.after_sunrise.cryptocurrency.bitflyer4j.entity.CoinIn;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
public class CoinInImpl extends AbstractEntity<Long, CoinIn> implements CoinIn {

    @SerializedName("id")
    @VisibleForTesting
    Long key;

    @SerializedName("order_id")
    @VisibleForTesting
    String orderId;

    @SerializedName("currency_code")
    @VisibleForTesting
    String currency;

    @SerializedName("amount")
    @VisibleForTesting
    BigDecimal amount;

    @SerializedName("address")
    @VisibleForTesting
    String address;

    @SerializedName("tx_hash")
    @VisibleForTesting
    String hash;


    @SerializedName("status")
    @VisibleForTesting
    String status;

    @SerializedName("event_date")
    @VisibleForTesting
    ZonedDateTime eventDate;

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public ZonedDateTime getEventDate() {
        return eventDate;
    }

}
