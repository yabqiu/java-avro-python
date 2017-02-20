###Data exchange between Java and Python via Apache Avro

#####Compile multiple schema files into Java domain objects

```bash
java -jar avro-tools-1.8.1.jar compile schema product.avsc user.avsc java
```

#####Python prerequisite, dependencies

```bash
pip install avro
brew install snappy
pip install python-snappy
```
