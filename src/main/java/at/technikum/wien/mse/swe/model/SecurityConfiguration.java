package at.technikum.wien.mse.swe.model;

import at.technikum.wien.mse.swe.MyAnnotation;

import java.math.BigDecimal;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityConfiguration {

    @MyAnnotation(start = 40, length = 12, padding = "")
    private String isin;

    @MyAnnotation(start = 52, length = 2, padding = "")
    private RiskCategory riskCategory;

    @MyAnnotation(start = 54, length = 30, padding = "")
    private String name;

    @MyAnnotation(start = 84, length = 3, padding = "")
    private String currency;

    @MyAnnotation(start = 87, length = 10, padding = "")
    private BigDecimal balanceHighest;

    @MyAnnotation(start = 97, length = 10, padding = "")
    private BigDecimal balanceLowest;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public RiskCategory getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalanceHighest() {
        return balanceHighest;
    }

    public void setBalanceHighest(BigDecimal balanceHighest) {
        this.balanceHighest = balanceHighest;
    }

    public BigDecimal getBalanceLowest() {
        return balanceLowest;
    }

    public void setBalanceLowest(BigDecimal balanceLowest) {
        this.balanceLowest = balanceLowest;
    }

    @Override
    public String toString() {
        return "SecurityConfiguration{" +
                "isin='" + isin + '\'' +
                ", riskCategory='" + riskCategory + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", balanceHighest=" + balanceHighest +
                ", balanceLowest=" + balanceLowest +
                '}';
    }
}
