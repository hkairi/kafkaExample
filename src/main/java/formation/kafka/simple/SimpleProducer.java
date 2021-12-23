package formation.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {

        public static void main(String[] args) {
            Properties producerProps = new Properties();
            producerProps.put(ProducerConfig.CLIENT_ID_CONFIG, "simple_producer_02");
            producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

            KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);
            producer.send(new ProducerRecord<>("formation.kafka.messages", "key-1", "Value-1"));
            producer.flush();
        }

}
