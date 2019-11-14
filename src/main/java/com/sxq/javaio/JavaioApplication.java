package com.sxq.javaio;

import java.nio.file.Paths;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaioApplication {

    public static void main(String[] args) {
        //        SpringApplication.run(JavaioApplication.class, args);
        Compresser[] compressers = new Compresser[] {new NoBufferCompresser()};
        CompressParam compressParam = new CompressParam(
                Paths.get("./target/pic.out.png").toString(),
                Paths.get("./10m.in.png").toString(),
                Paths.get("temp.png").toString());
        for (Compresser compresser : compressers) {
            try {
                CompresserAdapter compresserAdapter = new CompresserAdapter(compresser);
                compresserAdapter.compress(compressParam);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
