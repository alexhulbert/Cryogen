unzip backup.zip /tmp/icewind
dpkg --set-selections << /tmp/icewind/sel
dpkg -i /tmp/icewind/apt07strict/* #constains apt-get packages & dependencies
cp /tmp/icewind/sources /path/to/sources/file
apt-get update
dpkg -i /tmp/icewind/debs/*
rm -R /tmp/icewind/debs/*
rmdir /tmp/icewind/debs
rm /tmp/icewind/sel
apt-get --fix-missing -f dselect-upgrade
reboot
