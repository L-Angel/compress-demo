package com.langel.compress;

/**
 * @author L-Angel,Rick(lonelyangel.jcw@gamil.com)
 * @date 2019/1/12 9:45 PM
 **/
public interface Compress {

    byte[] compress(byte[] val);

    byte[] compressMulti(byte[] val, int num);
}
