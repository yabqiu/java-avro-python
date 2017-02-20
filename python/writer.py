import avro.schema
import json
from avro.datafile import DataFileWriter
from avro.io import DatumWriter

# schema = avro.schema.parse(open("../user-with-product.avsc", "rb").read())


def load_avsc_files(*avsc_files):
    all_schemas = avro.schema.Names()
    schemas = None
    for avsc_file in avsc_files:
        file_text = open(avsc_file).read()
        json_data = json.loads(file_text)
        schemas = avro.schema.make_avsc_object(json_data, all_schemas) #dd

    # print json.dumps(user_schema.to_json(avro.schema.Names()), indent=2)

    return schemas


schema = load_avsc_files("../product.avsc", "../user.avsc")

writer = DataFileWriter(open("../user-by-python.avro", "w"), DatumWriter(), schema, codec="snappy")
writer.append({'name': 'Yanbin', 'address': 'Chicago', 'products': [{'id': 3, 'name': 'Book3'}, {'id': 4, 'name': 'Book4'}]})
writer.append({'name': 'Unmi', 'address': 'Chicago', 'products': [{'id': 4, 'name': 'Book4'}, {'id': 5, 'name': 'Book5'}]})
writer.close()
