unzip -q backup.zip -d /tmp/icewind
dpkg --log /var/log/icew1nd.log -i /tmp/icewind/apt07strict/* #constains apt-get packages & dependencies
cp -R /tmp/icewind/sources/* /etc/apt/sources.list.d/
apt-get update
dpkg --set-selections << /tmp/icewind/sel
apt-get --fix-missing -f dselect-upgrade
reboot
#structure yet as far as I understood
#   backup.zip #must be in the same dir as restorePkg.sh atm
#      ./apt07strict/
#        apt-get and depencies
#      ./sources/
#        cydia.list
#        saurik.list # shall we even restre this one? Shit the same everywhere
#        whatever.list
#      ./sel
