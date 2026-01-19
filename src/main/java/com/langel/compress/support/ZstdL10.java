package com.langel.compress.support;

import com.langel.compress.Compress;
import com.langel.compress.Decompress;

/**
 * @author Rick(lonelyangel.jcw @ gmail.com)
 * created 2026/1/19 11:11
 **/
public class ZstdL10 implements Compress, Decompress {

    public byte[] compress(byte[] val) {
        return com.github.luben.zstd.Zstd.compress(val, 10);

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
        return com.github.luben.zstd.Zstd.decompress(val, val.length * 5);
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
