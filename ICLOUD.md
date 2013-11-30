iCloud
======

UPDATE: METHOD FOR DECRYPTING BACKUPS CAN BE FOUND [HERE](http://www.elcomsoft.com/PR/recon_2013.pdf)
----------------------------------------------------------------------------------------------

<h4>Since iCloud is going to be the hardest to do, I'm including a seperate readme for it.</h4>


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
    <td>Returns a list of chunks (files) and info about each one. These are <a href="#">Varint Encoded</a></td>
</tr>
</table>

Relation to iTunes backups
--------------------------

+ After comparing the data to iTunes' way of backing up, it seems the two aren't that different
+ The "Manifest.mbdb" seems to be very similar, if not exactly the same to the output of "getFiles" in iCloud
+ The "getKeys" url also seems to be related to iTunes in some way.
+ Perhaps a already-existing iTunes decrypter (possibly []()) could be ported to java?

Useful links
------------

+ The following links might aid you in understanding the way iCloud and iTunes encrypt their backups
+ [Cracking and Analyzing Apple iCloud](http://www.cansecwest.com/slides/2013/Cracking%20and%20Analyzing%20Apple%20iCloud.ppt)
+ [iTunes Backup Decrption](http://www.exploit-db.com/wp-content/themes/exploit/docs/19767.pdf)
+ [iPhone Wiki Page](http://theiphonewiki.com/wiki/ITunes_Backup)
+ [MBDB Decryption Script (Python)](http://code.google.com/p/iphone-dataprotection/source/browse/python_scripts/backups/backup4.py)
