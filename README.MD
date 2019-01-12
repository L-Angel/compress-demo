ZSTD 解压缩方式的时间与设置的非压缩的原数据大小有关
```html

Small File :
Snappy :
    Size :
        Before compress : 2758
        End compress : 2037
    Count : 1000
    Elapse : PT0.125S
    Size :
        Before decompress : 2037
        End decompress : 2758
    Count : 1000
    Elapse : PT0.011S
Gzip :
    Size :
        Before compress : 2758
        End compress : 1459
    Count : 1000
    Elapse : PT0.16S
    Size :
        Before decompress : 1459
        End decompress : 2758
    Count : 1000
    Elapse : PT0.115S
Lz4 :
    Size :
        Before compress : 2758
        End compress : 2206
    Count : 1000
    Elapse : PT0.081S
    Size :
        Before decompress : 2206
        End decompress : 0
    Count : 1000
    Elapse : PT0.025S
Zstd :
    Size :
        Before compress : 2758
        End compress : 1473
    Count : 1000
    Elapse : PT0.086S
    Size :
        Before decompress : 1473
        End decompress : 2758
    Count : 1000
    Elapse : PT17.432S


General File :
Snappy :
    Size :
        Before compress : 6855
        End compress : 3528
    Count : 100
    Elapse : PT0.003S
    Size :
        Before decompress : 3528
        End decompress : 6855
    Count : 100
    Elapse : PT0.002S
Gzip :
    Size :
        Before compress : 6855
        End compress : 2324
    Count : 100
    Elapse : PT0.023S
    Size :
        Before decompress : 2324
        End decompress : 6855
    Count : 100
    Elapse : PT0.006S
Lz4 :
    Size :
        Before compress : 6855
        End compress : 3882
    Count : 100
    Elapse : PT0.004S
    Size :
        Before decompress : 3882
        End decompress : 0
    Count : 100
    Elapse : PT0.001S
Zstd :
    Size :
        Before compress : 6855
        End compress : 2301
    Count : 100
    Elapse : PT0.004S
    Size :
        Before decompress : 2301
        End decompress : 6855
    Count : 100
    Elapse : PT1.082S


Big File :
Snappy :
    Size :
        Before compress : 4762463
        End compress : 1814797
    Count : 10
    Elapse : PT0.274S
    Size :
        Before decompress : 1814797
        End decompress : 4762463
    Count : 10
    Elapse : PT0.093S
Gzip :
    Size :
        Before compress : 4762463
        End compress : 1144920
    Count : 10
    Elapse : PT2.079S
    Size :
        Before decompress : 1144920
        End decompress : 4762463
    Count : 10
    Elapse : PT0.305S
Lz4 :
    Size :
        Before compress : 4762463
        End compress : 2539166
    Count : 10
    Elapse : PT0.221S
    Size :
        Before decompress : 2539166
        End decompress : 0
    Count : 10
    Elapse : PT0.114S
Zstd :
    Size :
        Before compress : 4762463
        End compress : 1169771
    Count : 10
    Elapse : PT0.335S
    Size :
        Before decompress : 1169771
        End decompress : 4762463
    Count : 10
    Elapse : PT0.273S
```