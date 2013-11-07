iCEW1ND
=======

What is iCEW1ND?
----------------

+ iCEW1ND will be an alternate method of backing up and restoring iDevices
+ It will not require a fully booting device, just one that can enter DFU
+ I _desperately_ need help with this. Any contributions are greatly appreciated
+ All tasks done by ICEW1ND can be done at any point in time, in DFU or after the iPhone has been restored
+ If anything is in __bold__, I don't have any definate way to do it. In other words, I'll probably need help.
+ It will be written in either Java or Groovy (I'm leaning towards Javaa right now)

What can it do?
---------------

+ iCEW1ND will be able to do 6 things:
  1. Load selected app data from iCloud onto an iDevice even after it has been restored
  2. Backup apps and their data even when an iDevice is in DFU mode
  3. Restore those apps/data to the Device at any given time.)
  4. Bulk modify the metadata for multiple apps at once
  5. Backup/Restore packages & sources
  6. Backup/Restore custom paths

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

<h4>Manual iCloud Restore</h4>
+ The iCloud restore will __download and decrypt the iCloud data__ in a similar fashion to [Elcomsoft Phone Password Breaker](http://www.elcomsoft.com/eppb.html)
+ The downloaded chunk folders (ex: AppDomain-com.2dboy.worldofgoo) will be stripped of their prefix (AppDomain-) and matched with an app in /var/mobile/Applications by looking at the plist names in /var/mobile/Applications/<UID>/Library/Preferences
+ This data will then be copied over to the device over an SSH tunnel.

<h4>Manual data backup</h4>
+ The The backup process will start off by checking if the device is in DFU Mode using a program such as [this](https://github.com/ThePrivateDevTeam/DFU--Detector). If it is, it will load on an SSH Ramdisk using [msftguy's JSyringe and SSH Ramdisk](https://github.com/msftguy/ssh-rd)
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

<h4>Backup Packages</h4>
+ Icewind will get the installed packages with ```dpkg --get-selections | sed 's/^.+[ \t]*deinstall[ \t]*$//g``` and iterate through each line in a "for" statement
+ The program will check if the specified package can be downloaded online by checking it ```apt-cache policy $1``` where $1 is a line in the above command after running ```preg_replace("^([^ \t]+)[ \t]*install[ \t]*$``` to get the package id
+ If the package is not found in any of the sources, it will be repackaged into a deb file, which will be added to a "deb" folder in the backup zip
+ If the package _is_ found, that line of the the dpkg command (something like "com.blah.blah       install") will be added to another file, containing the dpkg selections
+ The sources will also be backed up. I know there is a file somewhere that lists the sources, but I don't know its location off the top of my head. Regardless, backing up sources should be relatively easy.
<h4>Backup Custom Folder</h4>
+ The user will also have the option to backup up custom paths
+ This can be done by using something like ```split("/")``` on each path the user wants to create and iterating through each folder.
+ On each subdirectory, the program will create a folder. For example, backing up "/private/var/mobile" would start off by creating a "private" folder in a temp directory, a "var" directory in the private folder, and so on.
+ Once this is done, the contents of the last folder will be copied into the temp folder. In the example, a command such as ```cp -R /private/var/mobile/* /tmp/icewind/private/var/mobile``` would be run
+ This will happen for each path the user wants to backup, all of the paths being merged into one root folder
+ Finally, this root __folder will be packaged into a deb__ and deleted.
+ This deb can then be added to the "debs" folder in the backup zip
<h4>Restore Packages</h4>
+ First, the "debs" folder, the dpkg selections file (which I'm going to call "sel"), and the sources file will be unzipped
+ I'm going to assume that they're unzipped into the current directory, but it goes without saying that this might not always be the case.
+ APT 0.7 Strict will be installed via dpkg so that the "apt-get" commands can be used
+ The sources will be copied over to the device and ```apt-get update``` will be run to refresh everything
+ The dpkg selections will be put on the device using ```dpkg --set-selections << sel```
+ Then, the custom debs will be installed using ```dpkg -i debs/*```
+ The "debs" folder and selections file will be removed with ```rm -R debs``` and ```rm apt```
+ Finally the selections will be installed (the dpkg command doesn't accually install them) with ```apt-get --fix-missing -f dselect-upgrade```
+ The "f" flag is for "force." It allows you to install the packages even if there are some dependency errors, which might have happened because some debs were installed manually
+ The "--fix-missing" flag makes sure that the command doesn't stop mid-way because of an error. That could be disastrous.
+ Finally, a simple ```reboot``` will reboot the device and finish the installation process
