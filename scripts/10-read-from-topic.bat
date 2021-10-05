./bin/windows/kafka-console-consumer.bat \
  --topic kafka.training.customers \
  --bootstrap-server localhost:9092 \
  --property print.key=true \
  --property key.separator="-" \
  --partition 0 \
  --offset 0
