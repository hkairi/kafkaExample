echo "Downloading Apache Kafka 2.8.0 ..."
curl https://archive.apache.org/dist/kafka/2.8.0/kafka_2.12-2.8.0.tgz -o kafka-broker.tgz
echo "Done."

echo "unarchiving Apache Kafka 2.8.0..."
tar -xvf kafka-broker.tgz
echo "Done."

echo "removing tzg file"
rm kafka-broker.tgz
echo "Done."
