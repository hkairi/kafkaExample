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
    @JsonProperty
    private double amount;

    public Customer() {
    }

    public Customer(String id, String name, String accountId, String clientId, double amount) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
        this.clientId = clientId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getClientId() {
        return clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean exceedsLimit(Double amount) {
        return this.amount > amount;
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
}
