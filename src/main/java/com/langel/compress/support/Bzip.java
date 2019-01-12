package com.langel.compress.support;

import com.langel.compress.Compress;
import com.langel.compress.Decompress;
import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 10:24 PM
 **/
public class Bzip implements Compress, Decompress {
    @Override
    public byte[] compress(byte[] val) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            BZip2CompressorOutputStream bcos = new BZip2CompressorOutputStream(out);
            bcos.write(val);
            bcos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new byte[0];
        }
        return out.toByteArray();

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
                return decompress(val);
            }
            decompress(val);
        }
        return new byte[0];
    }
}
