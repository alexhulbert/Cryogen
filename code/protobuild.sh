rm ../Icewind/src/com/alexhulbert/icewind/Protocol.java
./bin/protoc --java_out=../Icewind/src/com/alexhulbert/icewind  protocol.proto
sed -i "1ipackage com.alexhulbert.icewind;\n" ../Icewind/src/com/alexhulbert/icewind/Protocol.java