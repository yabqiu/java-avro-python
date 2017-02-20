from avro.datafile import DataFileReader
from avro.io import DatumReader

reader = DataFileReader(open("../user-by-java.avro", "rb"), DatumReader())
for user in reader:
    print(user)
reader.close()
