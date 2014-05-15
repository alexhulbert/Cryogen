Icew1nd
=======

<img src="http://alexhulbert.com/img/Icewind_new.png">
<h3> Made by Taconut </h3>
Announcements:
--------------

+ None right now :)

Table of Contents:
------------------

+ <a href="#what-is-icew1nd">What is it?</a>
+ <a href="#current-status">Status</a>
+ <a href="#what-can-it-do">What can it do?</a>
+ <a href="#contributing">Contributing</a>
+ <a href="#license">License</a>
+ <a href="#how-will-it-work">How will it work?</a>
  + <a href="#manual-icloud-restore">iCloud</a>
  + <a href="#manual-data-backup">Data Backup</a>
  + <a href="#manual-app-backup">App Backup</a>
  + <a href="#manual-appdata-restore">Restore</a>
  + <a href="#metadata-manager">iTunesMetadata</a>
  + <a href="#backup-packages">Cydia Backup</a>
  + <a href="#backup-custom-folder">Custom Paths</a>
  + <a href="#restore-packages">Cydia Restore</a>
+ <a href="CREDITS.md">Credits</a>

What is Icew1nd?
----------------

+ Icew1nd will be an alternate method of backing up and restoring iDevices
+ It will not require a fully booting device, just one that can enter DFU
+ I _desperately_ need help with this. Any contributions are greatly appreciated
+ All tasks done by ICEW1ND can be done at any point in time, in DFU or after the iPhone has been restored
+ It is written in Java (although I will probably have to use a JNI)

<span id="stat">CURRENT STATUS:</span>
---------------

__Current Tasks:__
+ GUI Prototyping
+ JMobileDevice
+ iCloud Stuff

__Current Status:__

<pre>
iCloud        {++++++----}  60%
Data Backup   {+++++-----}  50%
Data Restore  {+++++-----}  50%
App Backup    {++++++----}  60%
App Restore   {++++++----}  60%
Plist Editor  {----------}   0%
Cydia Restore {+---------}  10%
Cydia Backup  {+---------}  10%
OVERALL       [====>     ]  40%
</pre>


+ For discussions on iCloud decryption, please see [this issue](https://github.com/jurriaan/Ruby-iCloud/issues/1)
+ For the reddit thread and discussion, please see [this post](http://www.reddit.com/r/jailbreak/comments/1r57b2/need_help_developing_new_application_icew1nd/)
+ For work on Pymobiledevice and Jython/Python related errors, please see [this issue](https://github.com/Triforce1/Icew1nd/issues/2) or [this repo](https://github.com/PythEch/pymobiledevice)

<span id="features">What can it do?</span>
---------------

+ Icew1nd will be able to do 6 things:
  1. Load selected app data from iCloud onto an iDevice even after it has been restored
  2. Backup apps and their data even when an iDevice is in DFU mode
  3. Restore those apps/data to the Device at any given time.)
  4. Bulk modify the metadata for multiple apps at once
  5. Backup/Restore packages & sources
  6. Backup/Restore custom paths

Contributing
------------

+ You can contact me via email at alex@alexhulbert.com 
+ If you just want to add snippits of code, put them into the "code" folder. They don't necessary have to have correct syntax.
+ General discussion can be found in issue #1.
+ I use Netbeans, but you can use whatever you want
+ Please try to use 4-spaced tabs (or just regular ones) and keep your curly braces on the same line as your statements. __example:__

```Java
if (this.user[0].codingStyle.toLowerCase() == "correct") {
    me.setHappiness(true);
} else {
    me.setHappiness(false);
}
```

License
-------

+ You can do basically anything you want with this, just follow these guidelines when redistributing my software
  + Follow the [license](LICENSE.md).
  + Include my donate button when distributing binaries of Icew1nd (when its done, of course)

How will it work?
-----------------

<h4>Manual iCloud Restore</h4>
+ The iCloud restore will download and decrypt the iCloud data in a similar fashion to [Elcomsoft Phone Password Breaker](http://www.elcomsoft.com/eppb.html)
+ Multiple HTTP GET and POST requests will be made to the iCloud servers to enumerate a list of files, names, urls, and keys.
+ It may be important to note that many of these requests will be encoded in [protobuf]() form
+ A list of protobuf message structures that I (or [Jurriaan](https://github.com/Jurriaan)) have reverse-engineered) can be found [here](./code/protobuf.proto).
+ Once the HTTP requests have been made, they will be downloaded from Windows Azure and AWS.
+ These downloaded "chunks" will be __decrypted using the output of "getKeys"__ and renamed to their correct names.
+ The downloaded chunks will be categorized by their domain (AppDomain, etc) and the apps will be matched using their bundle IDs (ex: com.2dboy.worldofgoo) by looking at Info.plist on the client device and parsing out the value of "CFBundleIdentifier"
+ This data will then be copied over to the device over an SSH tunnel (or like [this](#altMeth)).
Here is a table
+ A handy table depicting this process can be found [here](./ICLOUD.md).

<h4>Manual data backup</h4>
+ The backup process will start off by checking if the device is in DFU Mode. If it is, it will load on an SSH Ramdisk using [msftguy's JSyringe and SSH Ramdisk](https://github.com/msftguy/ssh-rd)
+ Then, disk0s1s1 and disk0s1s2 will be mounted on the DFU device (if necessary)
+ The SSH connection (DFU ramdisk or usb tunnel) will be mounted onto the computer directly.
+ The data in /var/mobile/Applications will be stored in folders containing the apps' bundle ids
+ This will all be zipped into a file which can then later be restored using this program
+ If the device _isn't_ in DFU, then it will have to find an alternate, non-jailbreak-dependant method for backing up apps.
+ I think that all the important info _should_ be in the "Documents" folder, which I'm pretty sure is publically accessable
+ (See <a href="#manual-appdata-restore">"Manual app/data restore"</a> for Info on non-jailbroken backup

<h4>Manual app backup</h4>
+ (See <a href="#manual-appdata-restore">"Manual app/data restore"</a> for Info on non-jailbroken backup
+ You can see the script for doing this (DFU/Jailbroken) [here](./code/AppBackup.sh).
+ It also might be important to note that this should also be done over SSH with an alternate root if the device is in DFU.

<h4>Manual app/data restore</h4>
+ The data restore process will be almost exactly like the iCloud one, only there is no prefix.
+ The _app_ restoration will be different, however. It will need to load the ipas onto the device, ignoring or updating duplicates.
+ All app restoration will be done using a Jython port of pymobiledevice (which, in turn, is a port of libimobiledevice).
+ [this repo](https://github.com/pythech/pymobiledevice)provides in-depth information on how most of the non-jailbroken stuff works. 

<h4>Metadata Manager</h4>
+ Finally, the program will need to parse itunesmetadata.plist.
+ This shouldn't be much of a problem, as its just a matter of parsing and manipulating multiple xml files, something there's bound to be a library for.
+ If this is to much of a problem, I just won't include it, as it is somewhat out of place in this program.

<h4>Backup Packages</h4>
+ Icewind will get the installed packages with ```dpkg --get-selections | sed 's/^.+[ \t]*deinstall[ \t]*$//g``` and iterate through each line in a "for" statement
+ The program will check if the specified package can be downloaded online by executing ```apt-cache policy $1``` where $1 is a line in the above command after running ```preg_replace("^([^ \t]+)[ \t]*install[ \t]*$``` to get the package id
+ If the package is not found in any of the sources, it will be repackaged into a deb file, which will be added to a "deb" folder in the backup zip
+ If the package _is_ found, that line of the the dpkg command (something like "com.blah.blah       install") will be added to another file, containing the dpkg selections
+ The sources will also be backed up. I know there is a file somewhere that lists the sources, but I don't know its location off the top of my head. Regardless, backing up sources should be relatively easy.

<h4>Backup Custom Folder</h4>
+ The user will also have the option to backup up custom paths
+ This can be done by using something like ```split("/")``` on each path the user wants to create and iterating through each folder.
+ On each subdirectory, the program will create a folder. For example, backing up "/private/var/mobile" would start off by creating a "private" folder in a temp directory, a "var" directory in the private folder, and so on.
+ Once this is done, the contents of the last folder will be copied into the temp folder. In the example, a command such as ```cp -R /private/var/mobile/* /tmp/icewind/private/var/mobile``` would be run
+ This will happen for each path the user wants to backup, all of the paths being merged into one root folder
+ Finally, this root folder will be packaged into a deb and deleted.
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
