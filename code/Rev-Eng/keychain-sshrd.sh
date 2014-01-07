#!/bin/bash
wget --no-check-certificate https://github.com/msftguy/ssh-rd/archive/rev-04b.zip
unzip rev-04b.zip
java -jar ssh-rd.jar #Different name?
rm rev-04b.zip ssh-rd.jar #Is there a readme in that zip too?
