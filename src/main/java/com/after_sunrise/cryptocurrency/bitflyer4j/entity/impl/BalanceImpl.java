package com.after_sunrise.cryptocurrency.bitflyer4j.entity.impl;

import com.after_sunrise.cryptocurrency.bitflyer4j.entity.Balance;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * @author takanori.takase
 * @version 0.0.1
 */
public class BalanceImpl extends AbstractEntity<String, Balance> implements Balance {

    @SerializedName("currency_code")
    @VisibleForTesting
    String key;

    @SerializedName("amount")
    @VisibleForTesting
    BigDecimal amount;

    @SerializedName("available")
    @VisibleForTesting
    BigDecimal available;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public BigDecimal getAvailable() {
        return available;
    }

}
