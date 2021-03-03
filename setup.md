yum install -y gcc-c++ autoconf automake

升级 gcc
yum install -y centos-release-scl scl-utils-build
yum install -y devtoolset-9-toolchain
scl enable devtoolset-9 bash

安装
make
mkdir -p /usr/local/redis
make PREFIX=/usr/local/redis/ install

启动
redis-server

redis.conf
```
daemonize yes
```

开机自启动
```
vi /etc/systemd/system/redis.service

[Unit]
Description=redis-server
After=network.target

[Service]
Type=forking
ExecStart=/usr/local/redis/bin/redis-server /usr/local/redis/bin/redis.conf
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

systemctl daemon-reload
systemctl start redis.service
systemctl enable redis.service


config

bind 0.0.0.0
requirepass 123456

info cpu
info replication
info cluster