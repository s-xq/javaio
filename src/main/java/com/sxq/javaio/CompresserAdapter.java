package com.sxq.javaio;

/**
 * Created by s-xq on 2019-11-14.
 */

public class CompresserAdapter {

    private Compresser compresser;

    public CompresserAdapter(Compresser compresser) {
        this.compresser = compresser;
    }

    public void compress(CompressParam param) {
        long beginTime = System.currentTimeMillis();
        try {
            compresser.compress(param);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Consume Time: %s\t%sms",
                compresser.getClass().getSimpleName(),
                endTime - beginTime));
    }
}
