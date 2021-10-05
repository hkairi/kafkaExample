.bin/windows/kafka-console-producer.bat \
  --topic kafka.training.transactions \
  --bootstrap-server localhost:9092 \
  --property parse.key=true \
  --property key.separator=":"
