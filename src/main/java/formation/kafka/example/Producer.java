package formation.kafka.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {

        Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.CLIENT_ID_CONFIG, "producer_01");
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        KafkaProducer<Integer, Customer> producer = new KafkaProducer<>(producerProps);

        Customer c = new Customer();
        c.setId("1");
        c.setName("Ichigo");

        Integer key = 0;
        producer.send(new ProducerRecord<Integer, Customer>("formation.kafka.customers", key, c));
        producer.close();
    }
}
