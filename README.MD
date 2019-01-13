ZSTD 解压缩方式的时间与设置的非压缩的原数据大小有关

- 小文件：KB级别，执行1000次
- 普通文件：kb级别，执行100次
- 大文件：4M+，执行10次
- ZSTD：解压缩分配空间等于压缩后的大小*5

```html

Small File :
Snappy :
    Size :
        Before compress : 2758
        End compress : 2037
    Count : 1000
    Elapse : PT0.111S
    Size :
        Before decompress : 2037
        End decompress : 2758
    Count : 1000
    Elapse : PT0.008S
Gzip :
    Size :
        Before compress : 2758
        End compress : 1459
    Count : 1000
    Elapse : PT0.206S
    Size :
        Before decompress : 1459
        End decompress : 2758
    Count : 1000
    Elapse : PT0.13S
Lz4 :
    Size :
        Before compress : 2758
        End compress : 2206
    Count : 1000
    Elapse : PT0.085S
    Size :
        Before decompress : 2206
        End decompress : 0
    Count : 1000
    Elapse : PT0.034S
Zstd :
    Size :
        Before compress : 2758
        End compress : 1473
    Count : 1000
    Elapse : PT0.067S
    Size :
        Before decompress : 1473
        End decompress : 2758
    Count : 1000
    Elapse : PT0.016S


General File :
Snappy :
    Size :
        Before compress : 6855
        End compress : 3528
    Count : 100
    Elapse : PT0.004S
    Size :
        Before decompress : 3528
        End decompress : 6855
    Count : 100
    Elapse : PT0.001S
Gzip :
    Size :
        Before compress : 6855
        End compress : 2324
    Count : 100
    Elapse : PT0.028S
    Size :
        Before decompress : 2324
        End decompress : 6855
    Count : 100
    Elapse : PT0.005S
Lz4 :
    Size :
        Before compress : 6855
        End compress : 3882
    Count : 100
    Elapse : PT0.005S
    Size :
        Before decompress : 3882
        End decompress : 0
    Count : 100
    Elapse : PT0.002S
Zstd :
    Size :
        Before compress : 6855
        End compress : 2301
    Count : 100
    Elapse : PT0.005S
    Size :
        Before decompress : 2301
        End decompress : 6855
    Count : 100
    Elapse : PT0.003S


Big File :
Snappy :
    Size :
        Before compress : 4762463
        End compress : 1814797
    Count : 10
    Elapse : PT0.467S
    Size :
        Before decompress : 1814797
        End decompress : 4762463
    Count : 10
    Elapse : PT0.116S
Gzip :
    Size :
        Before compress : 4762463
        End compress : 1144920
    Count : 10
    Elapse : PT1.684S
    Size :
        Before decompress : 1144920
        End decompress : 4762463
    Count : 10
    Elapse : PT0.28S
Lz4 :
    Size :
        Before compress : 4762463
        End compress : 2539166
    Count : 10
    Elapse : PT0.181S
    Size :
        Before decompress : 2539166
        End decompress : 0
    Count : 10
    Elapse : PT0.253S
Zstd :
    Size :
        Before compress : 4762463
        End compress : 1169771
    Count : 10
    Elapse : PT0.288S
    Size :
        Before decompress : 1169771
        End decompress : 4762463
    Count : 10
    Elapse : PT0.127S
```