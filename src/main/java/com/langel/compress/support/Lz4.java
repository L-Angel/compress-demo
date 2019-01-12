package com.langel.compress.support;

import com.langel.compress.Compress;
import com.langel.compress.Decompress;
import net.jpountz.lz4.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 10:16 PM
 **/
public class Lz4 implements Compress, Decompress {
    @Override
    public byte[] compress(byte[] val) {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        LZ4Compressor compressor = factory.fastCompressor();
        LZ4BlockOutputStream compressedOutput = new LZ4BlockOutputStream(
                byteOutput, 2048, compressor);
        try {
            compressedOutput.write(val);
            compressedOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return byteOutput.toByteArray();

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

    @Override
    public byte[] decompress(byte[] val) {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        LZ4FastDecompressor decompresser = factory.fastDecompressor();
        LZ4BlockInputStream lzis = new LZ4BlockInputStream(
                new ByteArrayInputStream(val), decompresser);
        try {
            int count;
            byte[] buffer = new byte[2048];
            while ((count = lzis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            lzis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new byte[0];
        }
        return baos.toByteArray();
    }

    @Override
    public byte[] decompressMulti(byte[] val, int num) {
        while (num-- >= 0) {
            if (num <= 0) {
                decompress(val);
            }
            decompress(val);
        }
        return new byte[0];
    }
}
