#!/bin/sh
#
# InstallApp - v1.7.8 (2008-11-25)
# uncon
#
 
DisplayHelp() {
        echo "Usage: $(basename $0) [OPTIONS]"
        echo
        echo "Mandatory options:"
        echo "  -i  IPA file to install"
        echo
        echo "Other options:"
        echo "  -u  UUID for destination directory"
        echo "  -h  display help"
        echo
}
 
echo -e "> InstallApp v1.7.8 (2008-11-25) - uncon\n"
 
if [ $# -eq 0 ]; then
        DisplayHelp
        exit 1
fi
 
while [ "$1" != "" ]; do
        case $1 in
                -i)
                        IPAInput="$2"
                        shift 2;;
                -u)
                        UUID="$2"
                        shift 2;;
                -h)
                        DisplayHelp
                        exit 0;;
                *)
                        DisplayHelp
                        echo "Unrecognized option: $1"
                        exit 1;;
        esac
done
 
echo "0% Checking dependencies"
 
if [ ! -e /usr/bin/plutil ]; then
        echo "Cannot find plutil (Install 'Erica Utilities' with Cydia)"
        exit 1
fi
if [ ! -e /usr/bin/uuid ]; then
        echo "Cannot find uuid (Install 'UUID Generator' with Cydia)"
        exit 1
fi
if [ ! -e /usr/bin/otool ]; then
        echo "Cannot find otool (Install 'Darwin CC Tools' with Cydia)"
        exit 1
fi
 
echo "2% Checking IPA"
 
if [ ! -f "$IPAInput" ]; then
        echo "IPA file does not exist ($IPAInput)"
        exit 1
fi
 
echo "5% Creating work directories"
 
WorkDir="/tmp/InstallApp-$(date +%Y%m%d-%H%M%S)"
 
if [ -e "$WorkDir" ]; then
        rm -rf "$WorkDir"
fi
mkdir -p "$WorkDir"
mkdir -p "$WorkDir/IPA"
 
if [ ! -d "$WorkDir" -o ! -d "$WorkDir/IPA" ]; then
        echo "Unable to create work directories"
        exit 1
fi
 
echo "10% Decompressing archive"
 
foo=$(unzip "$IPAInput" -d "$WorkDir/IPA" 2>&1> /dev/null)
if [ $? -gt 0 ]; then
        echo "Unable to decompress archive"
        rm -fr "$WorkDir"
        exit 1
fi
if [ $(ls "$WorkDir/IPA/Payload/" | wc -l) -ne 1 ]; then
        echo "Invalid IPA file"
        rm -fr "$WorkDir"
        exit 1
fi
mv "$WorkDir/IPA/Payload/$(ls "$WorkDir/IPA/Payload/")" "$WorkDir"
if [ -e "$WorkDir/IPA/iTunesArtwork" ]; then
        mv "$WorkDir/IPA/iTunesArtwork" "$WorkDir/"
fi
rm -fr "$WorkDir/IPA"
if [ $(ls "$WorkDir" | grep -v "iTunesArtwork" | wc -l) -ne 1 ]; then
        echo "Something went wrong (You should never see this.)"
        rm -fr "$WorkDir"
        exit 1
fi
TmpPath=$WorkDir/$(ls "$WorkDir" | grep -v "iTunesArtwork")
AppName=$(basename "$TmpPath")
AppPath=$(dirname "$TmpPath")
 
if [ ! -d "$AppPath/$AppName" ]; then
        echo "Something went wrong (You should never see this.)"
        rm -fr "$WorkDir"
        exit 1
fi
 
if [ "$UUID" = "" ]; then
        echo "25% Checking for previously installed version"
        AppId=$(plutil -key CFBundleIdentifier "$AppPath/$AppName/Info.plist" 2>&1)
        IFS=$'\n'
        for App in $(find /var/mobile/Applications -maxdepth 3 -type f -name Info.plist); do
                if [ "$(plutil -key CFBundleIdentifier "$App" 2>&1)" = "$AppId" ]; then
                        if [ "$AppNewPath" != "" ]; then
                                echo "$AppName is installed multiple times"
                                rm -fr "$WorkDir"
                                exit 1
                        fi
                        AppNewPath=/var/mobile/Applications/$(echo $App | awk -F "/" '{ print $5 }')
                fi
        done
fi
 
if [ "$AppNewPath" = "" ]; then
        if [ "$UUID" = "" ]; then
                UUID=$(uuid -v4 | tr "[:lower:]" "[:upper:]")
        elif [ $(echo $UUID | tr "[:lower:]" "[:upper:]" | egrep [0-9,A-F]{8}-[0-9,A-F]{4}-[0-9,A-F]{4}-[0-9,A-F]{4}-[0-9,A-F]{12} | wc -m) != "37" ]; then
                echo "Provided UUID is invalid"
                rm -fr "$WorkDir"
                exit 1
        else
                UUID=$(echo "$UUID" | tr "[:lower:]" "[:upper:]")
        fi
        AppNewPath=/var/mobile/Applications/$UUID
fi
 
if [ "$AppNewPath" = "" ]; then
        echo "Unable to determine destination directory"
        rm -fr "$WorkDir"
        exit 1
fi
 
if [ -d "$AppNewPath/$AppName" ]; then
        DoUpgrade=1
elif [ -d "$AppNewPath/Documents" ]; then
        echo "$AppName is not installed in upgrade path"
        rm -fr "$WorkDir"
        exit 1
else
        DoUpgrade=0
fi
 
if [ $DoUpgrade -eq 1 ]; then
        echo "50% Upgrading $AppName"
        rm -fr "$AppNewPath/$AppName"
else
        echo "50% Installing $AppName"
        echo "51% Creating application directories"
        mkdir "$AppNewPath"
        mkdir "$AppNewPath/tmp"
        mkdir "$AppNewPath/Documents"
        mkdir "$AppNewPath/Library"
        mkdir "$AppNewPath/Library/Preferences"
        ln -s "/private/var/mobile/Library/Preferences/.GlobalPreferences.plist" "$AppNewPath/Library/Preferences/.GlobalPreferences.plist"
        ln -s "/private/var/mobile/Library/Preferences/com.apple.PeoplePicker.plist" "$AppNewPath/Library/Preferences/com.apple.PeoplePicker.plist"
fi
 
if [ ! -d "$AppNewPath" ]; then
        echo "Unable to create/locate application directories"
        rm -fr "$WorkDir"
        exit 1
fi
 
echo "70% Moving application"
 
mv "$AppPath/$AppName" "$AppNewPath/"
mv "$AppPath/iTunesArtwork" "$AppNewPath/"
 
echo "75% Fixing permissions"
 
#chown -R mobile:mobile "$AppNewPath"
chown -R mobile:wheel "$AppNewPath/$AppName"
chmod -R u=+r+w+X,g=+r-w+X,o=+r-w+X "$AppNewPath"
 
AppExec=$(plutil -key CFBundleExecutable "$AppNewPath/$AppName/Info.plist")
if [ ! -f "$AppNewPath/$AppName/$AppExec" ]; then
        echo "Unable to find executable"
        rm -fr "$AppNewPath"
        rm -fr "$WorkDir"
        exit 1
fi
 
CryptID=$(otool -l "$AppNewPath/$AppName/$AppExec" | grep cryptid | awk '{print $2}')
if [ $CryptID -ne "0" ]; then
        echo "Application is encrypted"
        rm -fr "$WorkDir"
        exit 1
fi
 
chmod +x "$AppNewPath/$AppName/$AppExec"
 
if [ ! -x "$AppNewPath/$AppName/$AppExec" ]; then
        echo "Unable to make $AppNewPath/$AppName/$AppExec executable"
        rm -fr "$AppNewPath"
        rm -fr "$WorkDir"
        exit 1
fi
 
if [ -e "$AppNewPath/$AppName/SC_Info" ]; then
        echo "91% Removing SC_Info"
fi
 
if [ -e "$AppNewPath/$AppName/_CodeSignature" ]; then
        echo "92% Removing _CodeSignature"
        rm -fr "$AppNewPath/$AppName/_CodeSignature"
fi
 
if [ -h "$AppNewPath/$AppName/CodeResources" ]; then
        echo "93% Removing CodeResources"
        rm -fr "$AppNewPath/$AppName/CodeResources"
fi
 
if [ -e "$AppNewPath/$AppName/ResourceRules.plist" ]; then
        echo "94% Removing ResourceRules.plist"
        rm -fr "$AppNewPath/$AppName/ResourceRules.plist"
fi
 
echo "95% Removing work directories"
rm -fr "$WorkDir"
 
echo -e "100% \n> Done\n\nInstalled $AppName to $AppNewPath"
exit 0
