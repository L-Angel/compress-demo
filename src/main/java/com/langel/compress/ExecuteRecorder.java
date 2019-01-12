package com.langel.compress;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 9:57 PM
 **/
public class ExecuteRecorder implements Decompress, Compress {

    private Compress compress;

    private Decompress decompress;

    public ExecuteRecorder(Compress compress, Decompress decompress) {
        this.compress = compress;
        this.decompress = decompress;
    }

    public byte[] compress(byte[] val) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("    Size :");
        System.out.println("        Before compress : " + val.length);
        byte[] v = compress.compress(val);
        System.out.println("        End compress : " + v.length);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("    Elapse : " + Duration.between(start, end).toString());

        return v;
    }

    @Override
    public byte[] compressMulti(byte[] val, int num) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("    Size :");
        System.out.println("        Before compress : " + val.length);
        byte[] v = compress.compressMulti(val, num);
        System.out.println("        End compress : " + v.length);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("    Count : " + num);
        System.out.println("    Elapse : " + Duration.between(start, end).toString());
        return v;
    }

    public byte[] decompress(byte[] val) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("    Size :");
        System.out.println("        Before decompress : " + val.length);
        byte[] v = decompress.decompress(val);
        System.out.println("        End decompress : " + v.length);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("    Elapse : " + Duration.between(start, end).toString());
        return v;
    }

    @Override
    public byte[] decompressMulti(byte[] val, int num) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("    Size :");
        System.out.println("        Before decompress : " + val.length);
        byte[] v = decompress.decompressMulti(val, num);
        System.out.println("        End decompress : " + v.length);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("    Count : " + num);
        System.out.println("    Elapse : " + Duration.between(start, end).toString());
        return v;
    }
}
