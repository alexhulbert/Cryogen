iCloud
======

<h3>Since iCloud is going to be the hardest to do, I'm including a seperate readme for it.</h3>

Background Information
----------------------

+ Currently, the only thing I know of that can decrypt an iCloud backup is some program by Elcommsoft (See README.MD), but this is $200 and closed-source
+ After testing the program, it seems that it downloads some "chunks," which are files that each represent a file from iCloud or some piece of data
+ It also downloads two other files: ".files" and ".keys"
+ Each chunk's name is a random string of hex (each one is the same length)
+ I opened ".files" in a hex editor and it contains the name of the chunk file in hex, followed by 3 bytes, and then the path/name to the file.
+ Presumably, the program parses this file to give the chunks their correct name (the ones accually used on the device).
+ As for the ".keys" file, I think this might have something to do with decrypting certain data into those chunks
+ Parsing the chunk files might take awhile, but its defenately do-able in about a week
+ The main areas would be getting the data from whatever server iCloud uses and decrypting it into chunks
+ If anyone has any idea on how this is done, let me know.

Stuff I got from IDA
--------------------

+ Pretty soon, I'll try to reverse engineer the program in IDA and see if I can get some insight on how it works.

Relation to iTunes backups
--------------------------

+ After comparing the data to iTunes' way of backing up, it seems the two aren't that different
+ The "Manifest.mbdb" seems to be very similar, if not exactly the same to the ".files" in iCloud
+ Knowing this, an existing parsing script for Manifest.mbdb could be easily ported to Java for use in iCEW1ND
+ I will check into seeing what other parts of the iCloud are similar to iTunes, and record what I see here

Useful links
------------

+ The following links might aid you in understanding the way iCloud and iTunes encrypt their backups
+ [Cracking and Analyzing Apple iCloud](http://www.cansecwest.com/slides/2013/Cracking%20and%20Analyzing%20Apple%20iCloud.ppt)
+ [iTunes Backup Decrption](http://www.exploit-db.com/wp-content/themes/exploit/docs/19767.pdf)
+ [MBDB Decryption Script (Python)](http://code.google.com/p/iphone-dataprotection/source/browse/python_scripts/backups/backup4.py)
