rm ../Icewind/src/com/alexhulbert/icewind/Protobuf.java
./bin/protoc --java_out=../Icewind/src/com/alexhulbert/icewind  protobuf.proto
sed -i "1ipackage com.alexhulbert.icewind;\n" ../Icewind/src/com/alexhulbert/icewind/Protobuf.java