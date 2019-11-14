package com.sxq.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by s-xq on 2019-11-14.
 */

public class BufferCompresser implements Compresser {

    @Override
    public void compress(CompressParam param) throws Exception {
        File zipFile = new File(param.getZipFile());
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zos);
        for (int i = 0; i < 10; i++) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(param.getJpgFile()));
            zos.putNextEntry(new ZipEntry(param.getFileName() + i));
            int temp = 0;
            while ((temp = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(temp);
            }
        }
    }
}
