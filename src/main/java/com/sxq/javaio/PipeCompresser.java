package com.sxq.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by s-xq on 2019-11-14.
 */

public class PipeCompresser implements Compresser {

    @Override
    public void compress(CompressParam param) throws Exception {
        WritableByteChannel out = Channels.newChannel(new FileOutputStream(param.getZipFile()));
        Pipe pipe = Pipe.open();
        CompletableFuture.runAsync(() -> {
            try {
                runTask(pipe, param);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ReadableByteChannel readableByteChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate((int) param.getFileSize() * 10);
        while (readableByteChannel.read(buffer) >= 0) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    private void runTask(Pipe pipe, CompressParam param) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(pipe.sink()));
        WritableByteChannel out = Channels.newChannel(zos);
        for (int i = 0; i < 10; i++) {
            zos.putNextEntry(new ZipEntry(i + param.getSuffixFile()));
            FileChannel fileChannel = new FileInputStream(new File(param.getJpgFilePath())).getChannel();
            fileChannel.transferTo(0, param.getFileSize(), out);
            fileChannel.close();
        }
    }
}
