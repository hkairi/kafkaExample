package formation.kafka.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;

    @JsonProperty
    private String accountId;

    @JsonProperty
    private String clientId;

    public boolean amountExceeds(double limit) {
        return this.amount > limit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty
    private double amount;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
