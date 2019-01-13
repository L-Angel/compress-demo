package com.langel.compress.support;

import com.github.luben.zstd.ZstdInputStream;
import com.github.luben.zstd.ZstdOutputStream;
import com.langel.compress.Compress;
import com.langel.compress.Decompress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/13 3:14 AM
 **/
public class ZstdStream implements Compress, Decompress {

    @Override
    public byte[] compress(byte[] val) {
        ByteArrayInputStream is = new ByteArrayInputStream(val);
        ByteArrayOutputStream out = new ByteArrayOutputStream(512);
        try (ZstdOutputStream zout = new ZstdOutputStream(out)) {
            byte[] buf = new byte[512];
            int len = -1;
            while ((len = is.read(buf)) > 0) {

                zout.write(buf, 0, len);
            }

            zout.flush();
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public byte[] compressMulti(byte[] val, int num) {
        while (num-- >= 0) {
            if (num >= 0) {
                return compress(val);
            }
            compress(val);
        }
        return new byte[0];
    }

    @Override
    public byte[] decompress(byte[] val) {
        InputStream is = new ByteArrayInputStream(val);
        ByteArrayOutputStream out = new ByteArrayOutputStream(512);
        try (ZstdInputStream zis = new ZstdInputStream(is)) {
            byte[] buf = new byte[512];
            int len = -1;
            while ((len = zis.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.flush();
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public byte[] decompressMulti(byte[] val, int num) {
        while (num-- >= 0) {
            if (num >= 0) {
                return decompress(val);
            }
            decompress(val);
        }
        return new byte[0];
    }
}
