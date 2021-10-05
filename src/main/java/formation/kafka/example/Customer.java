package formation.kafka.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
