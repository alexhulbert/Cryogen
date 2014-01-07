#!/bin/bash
$ip = '127.0.0.1'        #ip of the device
$port = '22'             #port of the device
$mountpoint = '/private/var' #mountpoint for private partition
ssh root@$ip -p 'alpine' "

scp -P$port root@$ip:$mountpoint/Keychains/keychain-2.db keychain-2.db <<EOF
alpine
EOF
