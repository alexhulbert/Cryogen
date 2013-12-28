mkdir /tmpApp
mkdir /tmpApp/Payload
for UUID in $(ls /private/var/mobile/Applications)
do
    $name = $(ls /private/var/mobile/Applications/$UUID | grep '.app' | sed 's/.app//g')
    cp -R /private/var/mobile/Applications/$UUID/$name /tmpApp
    cp /private/var/mobile/Applications/$UUID/iTunesArtwork /tmpApp
    cp /private/var/mobile/Applications/$UUID/iTunesMetadata.plist /tmpApp
    zip -r /tmpApp/$name.ipa /tmpApp
    rm -R /tmpApp/Payload/*
    rm /tmpApp/iTunesArtwork
    rm /tmpApp/iTunesMetadata.plist
done
rmdir /tmpApp/Payload
#copy /tmpApp to computer
rm -r /tmpApp
exit
