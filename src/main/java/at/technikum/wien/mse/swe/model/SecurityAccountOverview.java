package at.technikum.wien.mse.swe.model;

import at.technikum.wien.mse.swe.MyAnnotation;

import java.math.BigDecimal;

/**
 * @author MatthiasKreuzriegler
 */
public class SecurityAccountOverview {

    @MyAnnotation(start = 40, length = 10, padding = "0")
    private String accountNumber;

    @MyAnnotation(start = 50, length = 2, padding = "")
    private RiskCategory riskCategory;

    @MyAnnotation(start = 52, length = 30, padding = "")
    private String lastName;

    @MyAnnotation(start = 82, length = 30, padding = "")
    private String firstName;

    @MyAnnotation(start = 112, length = 3, padding = "")
    private String currency;

    @MyAnnotation(start = 115, length = 17, padding = "")
    private BigDecimal balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public RiskCategory getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SecurityAccountOverview{" +
                "accountNumber='" + accountNumber + '\'' +
                ", riskCategory='" + riskCategory + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                '}';
    }
}
