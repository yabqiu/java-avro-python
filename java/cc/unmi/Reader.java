package cc.unmi;

import cc.unmi.data.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        DatumReader<User> userDatumReader = new SpecificDatumReader<>();
        DataFileReader<User> dataFileReader = new DataFileReader<>(new File("../user-by-python.avro"), userDatumReader);
        dataFileReader.forEach(System.out::println);
    }
}