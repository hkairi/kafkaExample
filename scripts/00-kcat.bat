kcat -b localhost:9092 -t formation.kafka.customers \
  -C \
  -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\nTimestamp: %T\tPartition: %p\tOffset: %o\n--\n'
