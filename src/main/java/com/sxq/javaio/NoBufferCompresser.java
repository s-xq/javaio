package com.sxq.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by s-xq on 2019-11-14.
 */

public class NoBufferCompresser implements Compresser {

    @Override
    public void compress(CompressParam param) throws Exception {
        File zipFile = new File(param.getZipFilePath());
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        for (int i = 0; i < 10; i++) {
            InputStream input = new FileInputStream(param.getJpgFile());
            zos.putNextEntry(new ZipEntry(new ZipEntry(param.getFileName() + i)));
            int temp = 0;
            while ((temp = input.read()) != -1) {
                zos.write(temp);
            }
        }
    }
}
