package com.sxq.javaio;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaioApplication {

    public static void main(String[] args) {
        //        SpringApplication.run(JavaioApplication.class, args);
        Compresser[] compressers = new Compresser[] {
                new NoBufferCompresser(),
                new BufferCompresser(),
                new ChannelCompresser(),
                new MappedCompresser(),
                new PipeCompresser()
        };
        CompressParam compressParam = new CompressParam();
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
