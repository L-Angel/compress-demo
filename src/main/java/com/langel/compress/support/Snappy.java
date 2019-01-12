package com.langel.compress.support;

import com.langel.compress.Compress;
import com.langel.compress.Decompress;

import java.io.IOException;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 9:47 PM
 **/
public class Snappy implements Compress, Decompress {
    public byte[] compress(byte[] val) {
        try {
            return org.xerial.snappy.Snappy.compress(val);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @Override
    public byte[] compressMulti(byte[] val, int num) {
        while (num-- >= 0) {
            if (num <= 0) {
                return compress(val);
            }
            compress(val);
        }
        return new byte[0];
    }

    public byte[] decompress(byte[] val) {
        try {
            return org.xerial.snappy.Snappy.uncompress(val);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @Override
    public byte[] decompressMulti(byte[] val, int num) {
        while (num-- >= 0) {
            if (num <= 0) {
                return decompress(val);
            }
            decompress(val);
        }
        return new byte[0];
    }
}
