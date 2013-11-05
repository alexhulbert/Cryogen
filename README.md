iCEW1ND
=======

What is iCEW1ND?
----------------

+ iCEW1ND will be an alternate method of backing up and restoring iDevices
+ It will not require a fully booting device, just one that can enter DFU
+ I _desperately_ need help with this. Any contributions are greatly appreciated
+ All tasks done by ICEW1ND can be done at any point in time, in DFU or after the iPhone has been restored
+ If anything is in __bold__, I don't have any definate way to do it. In other words, I'll probably need help.
+ It will be written in either Java or Groovy (I'm leaning towards Java right now)

What can it do?
---------------

+ iCEW1ND will be able to do 4 things:
  1. Load selected app data from iCloud onto an iDevice even after it has been restored
  2. Backup apps and their data even when an iDevice is in DFU mode
  3. Restore those apps/data to the Device at any given time.)
  4. Bulk modify the metadata for multiple apps at once

Contributing
------------

+ If you just want to add snippits of code, put them into the "code" folder. They don't necessary have to have correct syntax.
+ Miscellaneous ideas can be added as comments in issue #1
+ I use Netbeans, but you can use whatever you want
+ Please try to use 4-spaced tabs (or just regular ones) and keep your curly braces on the same line as your statements. __example:__

```Java
if (this.user.codingStyle.toLowerCase() == "correct") {
    me.setHappiness(true);
} else {
    me.setHappiness(false);
}
```
+ Since this is open source, you can pretty much do whatever you want with it

How will it work?
-----------------

<h3>Sometime this week (it's 11/4/13 as I write this) I will write some pseudocode</h3>

<h4>Manual iCloud Restore</h4>
+ The iCloud restore will __download and decrypt the iCloud data__ in a similar fassion to [Elcomsoft Phone Password Breaker](http://www.elcomsoft.com/eppb.html)
+ The downloaded chunk folders (ex: AppDomain-com.2dboy.worldofgoo) will be stripped of their prefix (AppDomain-) and matched with an app in /var/mobile/Applications by looking at the plist names in /var/mobile/Applications/<UID>/Library/Preferences
+ This data will then be copied over to the device over an SSH tunnel.

<h4>Manual data backup</h4>
+ The The backup process will start off by checking if the device is in DFU Mode using a program such as [this](https://github.com/ThePrivateDevTeam/DFU--Detector). If it is, it will load on an SSH Ramdisk (See [this repo](https://github.com/msftguy/ssh-rd) for more information on how this is done)
+ Then, disk0s1s1 and disk0s1s2 will be mounted on the DFU device (if necessary)
+ The SSH connection (DFU ramdisk or usb tunnel) will be mounted onto the computer directly.
+ The apps in /var/mobile/Applications will be __repacked into ipas__ (this should be easy, as it is already done by dozens of programs)
+ The data in /var/mobile/Applications will be stored in folders containing the apps' bundle ids
+ This will all be zipped into a file which can then later be restored using this program

<h4>Manual app backup</h4>
+ The only trick to this one is __repacking your apps into ipas__.
+ It also might be important to note that this should also be done over SSH with an alternate root if the device is in DFU.

<h4>Manual app/data restore</h4>
+ The data restore process will be almost exactly like the iCloud one, only there is no prefix and the program will somehow have to __differentiate between the app and its data__.
+ The _app_ restoration will be different, however. It will need to __load the ipas onto the device, ignoring or updating duplicates__. This can work in a similar fassion to dragging the ipas into the device in [25pp](http://pro.25pp.com/ppwin)

<h4>Metadata Manager</h4>
+ Finally, the program will need to parse itunesmetadata.plist.
+ This shouldn't be much of a problem, as its just a matter of parsing and manipulating multiple xml files, something there's bound to be a library for.
+ If this is to much of a problem, I just won't include it, as it is somewhat out of place in this program.
