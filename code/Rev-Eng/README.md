Files For Reverse Engineering
=============================

These scripts should come in handy for anyone wanting to help develop Icew1nd.

Although these scripts may seem simple, the provide a means of easily contributing without knowing much about shellcode.

Keychain
--------

This set of scripts is used for installing a custom certificate on an iDevice before it is fully setup.

+ Use keychain-backup to copy the keychain to your computer
+ Use keychain-restore to put the keychain back on
+ Use keychain-sshrd to download and run msftguy's SSH Ramdisk utility
+ Use keychain-setup for instructions on how to setup your device with a wifi proxy
+ Use keychain-cert for instructions on how to install the HTTPS interception certificate

Pymobile
--------

This set of scripts is used for testing various functions in pymobile device

+ Use pymobile-lockdown to test if connecting to a device and running commands will work
+ Use pymobile-timeout  to test if the connection will stay after 1 minute
+ Use pymobile-jython   to test if Jython is working with pymobiledevice
+ Use pymobile-sockets  to test INET socket functionality (only for Windows)
+ Use pymobile-unixsock to test UNIX socket functionality (only for Linux/Mac)
+ Use pymobile-pair     to see all devices that have been paired with iTunes (only for Windows/Mac)
