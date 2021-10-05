package formation.kafka.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        Properties consumerProps = new Properties();
        consumerProps.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer_01");
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        consumerProps.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, Customer.class);
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "appD");
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<Integer, Customer> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Arrays.asList("formation.kafka.customers"));

        while (true) {
            ConsumerRecords<Integer, Customer> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<Integer, Customer> cust : records) {
                System.out.println(cust.value());
            }
        }
    }
}
