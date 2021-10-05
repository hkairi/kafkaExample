package formation.kafka.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

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

        // DEFINE OUR PRODUCER
        Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.CLIENT_ID_CONFIG, "producer_02");
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        KafkaProducer<String, Customer> producer = new KafkaProducer<>(producerProps);

        while (true) {
            ConsumerRecords<Integer, Customer> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<Integer, Customer> record : records) {
                Customer customer = record.value();

                System.out.println("--> TRANSACTION");
                // TELL DON'T ASK
                if (customer.amountExceeds(20000.0)) {
                    System.out.println("--> RISK");
                    producer.send(new ProducerRecord<String, Customer>("formation.kafka.risks", customer.getId(), customer));
                }

                producer.send(new ProducerRecord<String, Customer>("formation.kafka.transactions", customer.getId(), customer));

                System.out.println(record.value());
            }
        }
    }
}
