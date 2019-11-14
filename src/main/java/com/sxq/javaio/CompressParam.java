package com.sxq.javaio;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by s-xq on 2019-11-14.
 */

public class CompressParam {

    //要压缩的图片文件所在所存放位置
    public static String JPG_FILE_PATH = Paths.get("./10m.in.png").toString();

    //zip压缩包所存放的位置
    public static String ZIP_FILE = Paths.get("./out.zip").toString();

    //所要压缩的文件
    public static File JPG_FILE = null;

    //文件大小
    public static long FILE_SIZE = 0;

    //文件名
    public static String FILE_NAME = "";

    //文件后缀名
    public static String SUFFIX_FILE = "";

    static {

        File file = new File(JPG_FILE_PATH);

        JPG_FILE = file;

        FILE_NAME = file.getName();

        FILE_SIZE = file.length();

        SUFFIX_FILE = file.getName().substring(file.getName().indexOf('.'));
    }

    private String jpgFilePath = JPG_FILE_PATH;
    private String zipFile = ZIP_FILE;
    private File jpgFile = JPG_FILE;
    private String fileName = FILE_NAME;
    private long fileSize = FILE_SIZE;
    private String suffixFile = SUFFIX_FILE;


    public String getZipFile() {
        return zipFile;
    }

    public void setZipFile(String zipFile) {
        this.zipFile = zipFile;
    }

    public File getJpgFile() {
        return jpgFile;
    }

    public void setJpgFile(File jpgFile) {
        this.jpgFile = jpgFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getSuffixFile() {
        return suffixFile;
    }

    public void setSuffixFile(String suffixFile) {
        this.suffixFile = suffixFile;
    }

    public String getJpgFilePath() {
        return jpgFilePath;
    }

    public void setJpgFilePath(String jpgFilePath) {
        this.jpgFilePath = jpgFilePath;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"jpgFilePath\":\"")
                .append(jpgFilePath).append('\"');
        sb.append(",\"zipFile\":\"")
                .append(zipFile).append('\"');
        sb.append(",\"jpgFile\":")
                .append(jpgFile);
        sb.append(",\"fileName\":\"")
                .append(fileName).append('\"');
        sb.append(",\"fileSize\":")
                .append(fileSize);
        sb.append(",\"suffixFile\":\"")
                .append(suffixFile).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
