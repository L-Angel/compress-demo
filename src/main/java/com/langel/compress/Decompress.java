package com.langel.compress;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 9:46 PM
 **/
public interface Decompress {

    byte[] decompress(byte[] val);

    byte[] decompressMulti(byte[] val, int num);
}
