iCEW1ND
=======

What is iCEW1ND?
----------------

+ iCEW1ND will be an alternate method of backing up and restoring iDevices
+ It will not require a fully booting device, just one that can enter DFU
+ I _desperately_ need help with this. Any contributions are greatly appreciated
+ All tasks done by ICEW1ND can be done at any point in time, in DFU or after the iPhone has been restored
+ If anything is in __bold__, I don't have any definate way to do it. In other words, I'll probably need help.

What can it do?
---------------

+ iCEW1ND will be able to do 4 things:
  + Load selected app data from iCloud onto an iDevice even after it has been restored
  + Backup apps and their data even when an iDevice is in DFU mode
  + Restore those apps/data to the Device at any given time

How will it work?
-----------------

+ Sometime this week (it's 11/4/13 as I write this) I will write some pseudocode

_______
+ The iCloud restore will __download and decrypt the iCloud data__ in a similar fassion to [Elcomsoft Phone Password Breaker](http://www.elcomsoft.com/eppb.html)
+ The downloaded chunk folders (ex: AppDomain-com.2dboy.worldofgoo) will be stripped of their prefix (AppDomain-) and matched with an app in /var/mobile/Applications by looking at the plist names in /var/mobile/Applications/<UID>/Library/Preferences
+ This data will then be copied over to the device over an SSH tunnel.
_______ 
+ The The backup process will start off by __checking if the device is in DFU Mode__. If it is, it will load on an SSH Ramdisk (See [this repo](https://github.com/msftguy/ssh-rd) for more information on how this is done)
+ Then, disk0s1s1 and disk0s1s2 will be mounted on the DFU device (if nesisarry)
+ The SSH connection (DFU ramdisk or usb tunnel) will be mounted onto the computer directly.
+ ...

_______
I have to stop explaining now, but I've got the rest of the project planned out in my head with things like ipa repacking, etc. I will write more tomorrow
----------------------------------------------------------------------------------------------------------------------------------------------------------
