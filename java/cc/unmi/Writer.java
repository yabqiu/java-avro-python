package cc.unmi;

import cc.unmi.data.Product;
import cc.unmi.data.User;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Writer {
    public static void main(String[] args) throws IOException {

        User user = User.newBuilder()
            .setName("Yanbin")
            .setAddress("Chicago")
            .setProducts(Arrays.asList(
                Product.newBuilder().setId(1).setName("Book1").build(),
                Product.newBuilder().setId(2).setName("Book2").build()
            )).build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(userDatumWriter);
        dataFileWriter.setCodec(CodecFactory.snappyCodec());
        dataFileWriter.create(user.getSchema(), new File("../user-by-java.avro"));
        dataFileWriter.append(user);

        user.setName("Unmi");
        user.getProducts().forEach(product -> {
            product.setId(product.getId() + 2);
            product.setName("Book" + (Integer.parseInt(product.getName().toString().substring(4)) + 2));
        });
        dataFileWriter.append(user);
        dataFileWriter.close();
    }
}