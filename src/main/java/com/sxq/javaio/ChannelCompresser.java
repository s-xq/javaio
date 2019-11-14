package com.sxq.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by s-xq on 2019-11-14.
 */

public class ChannelCompresser implements Compresser {

    @Override
    public void compress(CompressParam param) throws Exception {
        File zipFile = new File(param.getZipFile());
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        WritableByteChannel writableByteChannel = Channels.newChannel(zos);
        for (int i = 0; i < 10; i++) {
            FileChannel fileChannel = new FileInputStream(param.getJpgFile()).getChannel();
            zos.putNextEntry(new ZipEntry(i + param.getSuffixFile()));
            fileChannel.transferTo(0, param.getFileSize(), writableByteChannel);

        }
    }
}
