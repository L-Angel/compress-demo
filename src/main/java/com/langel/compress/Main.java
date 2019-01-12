package com.langel.compress;

import com.langel.compress.support.*;
import com.langel.compress.util.FileUtils;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 10:10 PM
 **/
public class Main {

    public static void main(String[] args) {
        Snappy snappy = new Snappy();
        ExecuteRecorder snappyExec = new ExecuteRecorder(snappy, snappy);
        Gzip gzip = new Gzip();
        ExecuteRecorder gzipExec = new ExecuteRecorder(gzip, gzip);
        Lz4 lz4 = new Lz4();
        ExecuteRecorder lz4Exec = new ExecuteRecorder(lz4, lz4);
        Bzip bzip = new Bzip();
        ExecuteRecorder bzipExec = new ExecuteRecorder(bzip, bzip);
        Zstd zstd = new Zstd();
        ExecuteRecorder zstdExec = new ExecuteRecorder(zstd, zstd);

        System.out.println("Small File :");
        int smallNum = 1000;
        byte[] smallCnt = FileUtils.readToString("src/main/resources/small.txt").getBytes();

        System.out.println("Snappy :");
        byte[] snappyCompressed = snappyExec.compressMulti(smallCnt, smallNum);
        snappyExec.decompressMulti(snappyCompressed, smallNum);

        System.out.println("Gzip :");
        byte[] gzipCompressed = gzipExec.compressMulti(smallCnt, smallNum);
        gzipExec.decompressMulti(gzipCompressed, smallNum);

        System.out.println("Lz4 :");
        byte[] lz4Compressed = lz4Exec.compressMulti(smallCnt, smallNum);
        lz4Exec.decompressMulti(lz4Compressed, smallNum);

//        System.out.println("Bzip :");
//        byte[] bzipCompressed = bzipExec.compressMulti(smallCnt,smallNum);
//        bzipExec.decompressMulti(bzipCompressed,smallNum);

        System.out.println("Zstd :");
        byte[] zstdCompressed = zstdExec.compressMulti(smallCnt, smallNum);
        zstdExec.decompressMulti(zstdCompressed, smallNum);

        System.out.println("\n\nGeneral File :");

        int generalNum = 100;
        byte[] generalCnt = FileUtils.readToString("src/main/resources/general.txt").getBytes();

        System.out.println("Snappy :");
        snappyCompressed = snappyExec.compressMulti(generalCnt, generalNum);
        snappyExec.decompressMulti(snappyCompressed, generalNum);

        System.out.println("Gzip :");
        gzipCompressed = gzipExec.compressMulti(generalCnt, generalNum);
        gzipExec.decompressMulti(gzipCompressed, generalNum);

        System.out.println("Lz4 :");
        lz4Compressed = lz4Exec.compressMulti(generalCnt, generalNum);
        lz4Exec.decompressMulti(lz4Compressed, generalNum);

//        System.out.println("Bzip :");
//        byte[] bzipCompressed = bzipExec.compressMulti(smallCnt,smallNum);
//        bzipExec.decompressMulti(bzipCompressed,smallNum);

        System.out.println("Zstd :");
        zstdCompressed = zstdExec.compressMulti(generalCnt, generalNum);
        zstdExec.decompressMulti(zstdCompressed, generalNum);

        System.out.println("\n\nBig File :");
        int bigNum = 10;
        byte[] bigCnt = FileUtils.readToString("src/main/resources/big.txt").getBytes();

        System.out.println("Snappy :");
        snappyCompressed = snappyExec.compressMulti(bigCnt, bigNum);
        snappyExec.decompressMulti(snappyCompressed, bigNum);

        System.out.println("Gzip :");
        gzipCompressed = gzipExec.compressMulti(bigCnt, bigNum);
        gzipExec.decompressMulti(gzipCompressed, bigNum);

        System.out.println("Lz4 :");
        lz4Compressed = lz4Exec.compressMulti(bigCnt, bigNum);
        lz4Exec.decompressMulti(lz4Compressed, bigNum);

//        System.out.println("Bzip :");
//        byte[] bzipCompressed = bzipExec.compressMulti(smallCnt,smallNum);
//        bzipExec.decompressMulti(bzipCompressed,smallNum);

        System.out.println("Zstd :");
        zstdCompressed = zstdExec.compressMulti(bigCnt, bigNum);
        zstdExec.decompressMulti(zstdCompressed, bigNum);
    }
}
