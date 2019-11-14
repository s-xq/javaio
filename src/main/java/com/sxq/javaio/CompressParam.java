package com.sxq.javaio;

/**
 * Created by s-xq on 2019-11-14.
 */

public class CompressParam {

    private String zipFilePath;
    private String jpgFile;
    private String fileName;

    public CompressParam(String zipFilePath, String jpgFile, String fileName) {
        this.zipFilePath = zipFilePath;
        this.jpgFile = jpgFile;
        this.fileName = fileName;
    }

    public String getZipFilePath() {
        return zipFilePath;
    }

    public void setZipFilePath(String zipFilePath) {
        this.zipFilePath = zipFilePath;
    }

    public String getJpgFile() {
        return jpgFile;
    }

    public void setJpgFile(String jpgFile) {
        this.jpgFile = jpgFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"zipFilePath\":\"")
                .append(zipFilePath).append('\"');
        sb.append(",\"jpgFile\":\"")
                .append(jpgFile).append('\"');
        sb.append(",\"fileName\":\"")
                .append(fileName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
