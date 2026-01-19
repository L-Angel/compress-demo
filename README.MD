ZSTD 解压缩方式的时间与设置的非压缩的原数据大小有关

- 小文件：KB级别，执行1000次
- 普通文件：kb级别，执行100次
- 大文件：4M+，执行10次
- ZSTD：解压缩分配空间等于压缩后的大小*5

```shell
Small File :
Snappy :
    Size :
        Before compress : 2758
        End compress : 2041
    Count : 1000
    Elapse : PT0.571989S
    Size :
        Before decompress : 2041
        End decompress : 2758
    Count : 1000
    Elapse : PT0.004802S
Gzip :
    Size :
        Before compress : 2758
        End compress : 1459
    Count : 1000
    Elapse : PT0.044374S
    Size :
        Before decompress : 1459
        End decompress : 2758
    Count : 1000
    Elapse : PT0.026609S
Lz4 :
    Size :
        Before compress : 2758
        End compress : 2206
    Count : 1000
    Elapse : PT0.093808S
    Size :
        Before decompress : 2206
        End decompress : 0
    Count : 1000
    Elapse : PT0.042024S
Zstd :
    Size :
        Before compress : 2758
        End compress : 1473
    Count : 1000
    Elapse : PT0.323012S
    Size :
        Before decompress : 1473
        End decompress : 2758
    Count : 1000
    Elapse : PT0.011833S
Zstd1 :
    Size :
        Before compress : 2758
        End compress : 1502
    Count : 1000
    Elapse : PT0.014017S
    Size :
        Before decompress : 1502
        End decompress : 2758
    Count : 1000
    Elapse : PT0.009547S
Zstd10 :
    Size :
        Before compress : 2758
        End compress : 1460
    Count : 1000
    Elapse : PT0.029116S
    Size :
        Before decompress : 1460
        End decompress : 2758
    Count : 1000
    Elapse : PT0.007364S
Zstd19 :
    Size :
        Before compress : 2758
        End compress : 1451
    Count : 1000
    Elapse : PT0.305012S
    Size :
        Before decompress : 1451
        End decompress : 2758
    Count : 1000
    Elapse : PT0.009913S


General File :
Snappy :
    Size :
        Before compress : 6855
        End compress : 3529
    Count : 100
    Elapse : PT0.000952S
    Size :
        Before decompress : 3529
        End decompress : 6855
    Count : 100
    Elapse : PT0.000458S
Gzip :
    Size :
        Before compress : 6855
        End compress : 2324
    Count : 100
    Elapse : PT0.012052S
    Size :
        Before decompress : 2324
        End decompress : 6855
    Count : 100
    Elapse : PT0.002512S
Lz4 :
    Size :
        Before compress : 6855
        End compress : 3882
    Count : 100
    Elapse : PT0.009293S
    Size :
        Before decompress : 3882
        End decompress : 0
    Count : 100
    Elapse : PT0.00522S
Zstd :
    Size :
        Before compress : 6855
        End compress : 2287
    Count : 100
    Elapse : PT0.002168S
    Size :
        Before decompress : 2287
        End decompress : 6855
    Count : 100
    Elapse : PT0.001021S
Zstd1 :
    Size :
        Before compress : 6855
        End compress : 2302
    Count : 100
    Elapse : PT0.001891S
    Size :
        Before decompress : 2302
        End decompress : 6855
    Count : 100
    Elapse : PT0.000926S
Zstd10 :
    Size :
        Before compress : 6855
        End compress : 2143
    Count : 100
    Elapse : PT0.013907S
    Size :
        Before decompress : 2143
        End decompress : 6855
    Count : 100
    Elapse : PT0.000973S
Zstd19 :
    Size :
        Before compress : 6855
        End compress : 2088
    Count : 100
    Elapse : PT0.080798S
    Size :
        Before decompress : 2088
        End decompress : 6855
    Count : 100
    Elapse : PT0.00114S


Big File :
Snappy :
    Size :
        Before compress : 4762463
        End compress : 1815712
    Count : 10
    Elapse : PT0.111312S
    Size :
        Before decompress : 1815712
        End decompress : 4762463
    Count : 10
    Elapse : PT0.029372S
Gzip :
    Size :
        Before compress : 4762463
        End compress : 1144920
    Count : 10
    Elapse : PT0.863466S
    Size :
        Before decompress : 1144920
        End decompress : 4762463
    Count : 10
    Elapse : PT0.205455S
Lz4 :
    Size :
        Before compress : 4762463
        End compress : 2539166
    Count : 10
    Elapse : PT0.260874S
    Size :
        Before decompress : 2539166
        End decompress : 0
    Count : 10
    Elapse : PT0.10424S
Zstd :
    Size :
        Before compress : 4762463
        End compress : 1159563
    Count : 10
    Elapse : PT0.125467S
    Size :
        Before decompress : 1159563
        End decompress : 4762463
    Count : 10
    Elapse : PT0.036366S
Zstd1 :
    Size :
        Before compress : 4762463
        End compress : 1286031
    Count : 10
    Elapse : PT0.08622S
    Size :
        Before decompress : 1286031
        End decompress : 4762463
    Count : 10
    Elapse : PT0.034253S
Zstd10 :
    Size :
        Before compress : 4762463
        End compress : 1003086
    Count : 10
    Elapse : PT0.726954S
    Size :
        Before decompress : 1003086
        End decompress : 4762463
    Count : 10
    Elapse : PT0.034045S
Zstd19 :
    Size :
        Before compress : 4762463
        End compress : 918151
    Count : 10
    Elapse : PT7.976122S
    Size :
        Before decompress : 918151
        End decompress : 4762463
    Count : 10
    Elapse : PT0.035913S

```