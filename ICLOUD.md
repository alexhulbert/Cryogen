iCloud
======

<h4>Since iCloud is going to be the hardest to do, I'm including a seperate readme for it.</h4>
<h4>Look [here](http://www.elcomsoft.com/PR/recon_2013.pdf) for in-depth info on how iCloud is decrypted</h4>


Decryption Process
------------------

<table>
<tr>
    <td>Step #</td>
    <td>Method</td>
    <td>URL</td>
    <td>Headers</td>
    <td>Response</td>
    <td>&nbsp;&nbsp;&nbsp;Comments&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
    <td>1</td>
    <td>GET</td>
    <td>https://setup.icloud.com/setup/authenticate/&lt;iCloudUserName&gt;</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"basic&nbsp;"&nbsp;+&nbsp;base64(iCloudUserName&nbsp;+&nbsp;":"&nbsp;+&nbsp;iCloudPassword)</td>
        </table>
    </td>
    <td>DsPrsID and mmeAuthToken</td>
    <td>These values will be used for authentication in the next step</td>
</tr>
<tr>
    <td>2</td>
    <td>GET</td>
    <td>https://setup.icloud.com/setup/get_account_settings</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"basic&nbsp;"&nbsp;+&nbsp;base64(DsPrsID&nbsp;+&nbsp;":"&nbsp;+&nbsp;mmeAuthToken)</td>
        </table>
    <td>Info about the user</td>
    <td>This&nbsp;will&nbsp;return&nbsp;a&nbsp;NEW&nbsp;AND&nbsp;DIFFERENT&nbsp;MMEAUTHTOKEN.&nbsp;Use&nbsp;this&nbsp;new&nbsp;one&nbsp;instead&nbsp;of&nbsp;the&nbsp;one&nbsp;from&nbsp;/authenticate. It will also tell you what number should come after the "p" (partition #?) in the next urls.</td>
</tr>
<tr>
    <td>3</td>
    <td>GET</td>
    <td>https://p##-mobilebackup.icloud.com/mbs/&lt;DsPrsID&gt;/</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"X&#8209;MobileMe&#8209;AuthToken&nbsp;"&nbsp;+&nbsp;base64(DsPrsID&nbsp;+&nbsp;":"&nbsp;+&nbsp;mmeAuthToken)</td>
            </tr>
        </table>
    </td>
    <td>A&nbsp;list&nbsp;of&nbsp;BackupUDIDS</td>
    <td>Each&nbsp;"BackupUDID"&nbsp;represents&nbsp;a&nbsp;device&nbsp;linked&nbsp;with&nbsp;the&nbsp;account. Parse with "DeviceUDIDs" class.</td>
</tr>
<tr>
    <td>4</td>
    <td>GET</td>
    <td>https://p##-mobilebackup.icloud.com/mbs/&lt;DsPrsID&gt;/&lt;UDID&gt;</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"X&#8209;MobileMe&#8209;AuthToken&nbsp;"&nbsp;+&nbsp;base64(DsPrsID&nbsp;+&nbsp;":"&nbsp;+&nbsp;mmeAuthToken)</td>
            </tr>
        </table>
    </td>
    <td>Device info<br>list of backups</td>
    <td>
        Use the "Device" class to parse out the info (name, color, etc) and backups.<br>
        Choose a backup to download based on backup date and get its "snapshotID"
    </td>
</tr>
<tr>
    <td>5</td>
    <td>GET</td>
    <td>https://p##-mobilebackup.icloud.com/mbs/&lt;DsPrsID&gt;/getKeys</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"X&#8209;MobileMe&#8209;AuthToken&nbsp;"&nbsp;+&nbsp;base64(DsPrsID&nbsp;+&nbsp;":"&nbsp;+&nbsp;mmeAuthToken)</td>
            </tr>
        </table>
    </td>
    <td>Decryption Keys</td>
    <td>Parse these with "Keys." I have no clue how to use these yet. They are probably for decrypting the chunks</td>
</tr>
<tr>
    <td>6</td>
    <td>GET</td>
    <td>https://p##-mobilebackup.icloud.com/mbs/&lt;DsPrsID&gt;/&lt;UDID&gt;/&lt;SnapshotID&gt;</td>
    <td>
        <table>
            <tr>
                <td>Authorization</td>
                <td>"X&#8209;MobileMe&#8209;AuthToken&nbsp;"&nbsp;+&nbsp;base64(DsPrsID&nbsp;+&nbsp;":"&nbsp;+&nbsp;mmeAuthToken)</td>
            </tr>
        </table>
    </td>
    <td>File List</td>
    <td>Returns a list of chunks (files) and info about each one. <a href="#getFiles-Process">These are a little tricky to parse</a>.</td>
</tr>
<tr>
    <td>7</td>
    <td>POST</td>
    <td>https://p##-mobilebackup.icloud.com/mbs/&lt;DsPrsID&gt;/&lt;UDID&gt;/&lt;SnapshotID&gt;/getFiles</td>
    <td><b><em>This</em> is where I'm stuck. I have no idea how to get any of this without restoring.</b></td>
    <td>File Auth tokens (fileAuthToken)</td>
    <td>If anybody is willing to restore a jailbreakable device, let me know ASAP! This part of the project is stopping me from continuing on.</td>
</tr>
<tr>
    <td>8</td>
    <td>POST</td>
    <td>https://p##-content.icloud.com/&lt;dsPrsID&gt;/authorizeGet</td>
    <td>
        <table>
            <tr>
                <td>x-apple-mmcs-auth</td>
                <td><em>The&nbsp;fileAuthToken&nbsp;from&nbsp;the&nbsp;previous&nbsp;URL</em></td>
            </tr>
            <tr>
                <td>x-apple-mmcs-dataclass</td>
                <td>com.apple.Dataclass.Backup</td>
            </tr>
            <tr>
                <td>x-apple-mmcs-proto-version</td>
                <td>3.3</td>
            </tr>
            <tr>
                <td>x-apple-mme-dsid</td>
                <td><em>DsPrsID</em></td>
            </tr>
            <tr>
                <td>x-apple-request-uuid</td>
                <td>4EFFF273-5611-479B-A945-04DA0A0F2C3A</td>
            </tr>
            <tr>
                <td>x-mme-client-info</td>
                <td><em>Same as before</em></td>
            </tr>
        </table>
    </td>
    <td>File URL</td>
    <td>Once you download the file using that URL, just decrypt it with getKeys and rename it with the info from listFiles</td>
</tr>
</table>

getFiles Process
----------------
+ GetFiles can't be decrypted like it is.
+ It uses something called a "[varint](https://developers.google.com/protocol-buffers/docs/encoding#varints)"
+ The varint tells the program how long to read to get the next protobuf.
+ It goes varint1, protobuf1, varint2, protobuf2
+ The length of protobuf1 is the value of varint1, and so on.
+ If the varint thing seems too intimidating to create, don't worry. The protobuf library does this automatically,
+ I don't know how to decode this in other languages, but here is what I am doing in Java:

```Java
CodedInputStream chunkParser = CodedInputStream.newInstance(fileList);  //Get the output of "listFiles" and put it into a CodedInputStream (that class comes with the protobuf library)
Protobuf.Chunk[] files = new Protobuf.Chunk[/*# of chunks*/];           //this is an array that will contain all the chunks
for (int i = 0; !chunkParser.isAtEnd(); i++) {                          //Keep doing the following code until you reach the end of the file (with "i" increasing by 1 every time)
    int len = chunkParser.readRawVarint32();                            //Read a varint directly from the stream
    byte[] rawProtobuf = chunkParser.readRawBytes(len);                 //Now read x bytes from the stream, where x is the value of the previous varint
    files[i] = Protobuf.Chunk.parseFrom(rawProtobuf);                   //Interpret those bytes as a Protobuf and add that protobuf to the list of files
}                                                                       //Now you can run "getFiles" and "authorizeGet" on each member of the "files" variable to get the URLs
```

Relation to iTunes backups
--------------------------

+ After comparing the data to iTunes' way of backing up, it seems the two aren't that different
+ The "Manifest.mbdb" seems to be very similar, if not exactly the same to the output of "getFiles" in iCloud
+ The "getKeys" url also seems to be related to iTunes in some way.
+ Perhaps a already-existing iTunes decrypter (possibly [iPhone Data Protection](http://code.google.com/p/iphone-dataprotection/source/browse/python_scripts/backup_tool.py)) could be ported to java?

Useful links
------------

+ The following links might aid you in understanding the way iCloud and iTunes encrypt their backups
+ [Cracking and Analyzing Apple iCloud](http://www.cansecwest.com/slides/2013/Cracking%20and%20Analyzing%20Apple%20iCloud.ppt)
+ [iTunes Backup Decrption](http://www.exploit-db.com/wp-content/themes/exploit/docs/19767.pdf)
+ [iPhone Wiki Page](http://theiphonewiki.com/wiki/ITunes_Backup)
+ [MBDB Decryption Script (Python)](http://code.google.com/p/iphone-dataprotection/source/browse/python_scripts/backups/backup4.py)
