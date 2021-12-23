package formation.kafka.example;

import formation.kafka.serdes.JsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class JsonProducer {
    public static void main(String[] args) {
        Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.CLIENT_ID_CONFIG, "producer_01");
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        // producer acks
        producerProps.put(ProducerConfig.ACKS_CONFIG, "all"); // strongest producing guarantee
        producerProps.put(ProducerConfig.RETRIES_CONFIG, "3");
        producerProps.put(ProducerConfig.LINGER_MS_CONFIG, "1");
        // leverage idempotent producer from Kafka 0.11 !
        producerProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true"); // ensure we don't push duplicates

        KafkaProducer<String, Customer> producer = new KafkaProducer<>(producerProps);

        Customer c = new Customer("1", "ichigo", "AAXXOIJ", "SN00XXI", 250000.00);

        producer.send(new ProducerRecord<String, Customer>("formation.kafka.customers", c.getClientId(), c));
        producer.close();
    }
}
