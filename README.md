###Data exchange between Java and Python via Apache Avro

This project demostrates exchange data between Java and Python via Apache Avro, bidirection. That means there are

1. Java writer  -->  Python reader
2. Python writer  -->  Java reader

And writers compress data with snappy codec.

#####Compile multiple schema files into Java domain objects

```bash
java -jar avro-tools-1.8.1.jar compile schema product.avsc user.avsc java
```

#####Python prerequisite, dependencies

For whom working on Mac platform, we can use following commands to install needs.

```bash
pip install avro
brew install snappy
pip install python-snappy
```
By default, the official Python library doesn't support snappy, so we need to install snappy dependency.
