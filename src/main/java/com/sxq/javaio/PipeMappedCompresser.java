package com.sxq.javaio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
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

public class PipeMappedCompresser implements Compresser {

    @Override
    public void compress(CompressParam param) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(param.getZipFile()));
        WritableByteChannel writableByteChannel = Channels.newChannel(fileOutputStream);
        Pipe pipe = Pipe.open();
        CompletableFuture.runAsync(() -> {
            try {
                runTaskMap(pipe, param);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ReadableByteChannel workerChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (workerChannel.read(buffer) >= 0) {
            buffer.flip();
            writableByteChannel.write(buffer);
            buffer.clear();
        }
    }

    private void runTaskMap(Pipe pipe, CompressParam param) throws Exception {
        WritableByteChannel writableByteChannel = pipe.sink();
        ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(writableByteChannel));
        WritableByteChannel out = Channels.newChannel(zos);
        for (int i = 0; i < 10; i++) {
            zos.putNextEntry(new ZipEntry(i + param.getSuffixFile()));
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(param.getJpgFilePath(), "r").getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, param.getFileSize());
            out.write(mappedByteBuffer);
        }
    }

}
