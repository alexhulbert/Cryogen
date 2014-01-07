#!/bin/bash
$port = '22'                  #port of the device
$ip = '127.0.0.1'             #ip of the device
$loc = './keychain-2.db'      #location of keychain to restore
$mountpoint = '/private/var'  #mountpoint for private partition

scp $loc -P$port root@$ip:$mountpoint/Keychains/keychain-2.db <<EOF
alpine
EOF
