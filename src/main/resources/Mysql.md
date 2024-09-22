1、InnoDB和Mysam的区别
    a:InnoDB支持事务，Mysam不支持
    b:InnoDB是聚集索引，Mysam是非聚集索引
    c:InnoDB支持外键，Mysam不支持
    d:InnoDB最小粒度的锁是行锁，Mysam是表锁

2、char跟