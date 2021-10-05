.bin/windows/kafka-console-consumer.bat \
  --topic kafka.training.transactions \
  --bootstrap-server localhost:9092 \
  --from-beginning \
  --property print.key=true \
  --property key.separator="-"
