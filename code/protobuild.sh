rm ../Icewind/src/com/alexhulbert/icewind/Protocol.java
./bin/protoc --java_out=../Icewind/src/com/alexhulbert/icewind  protocol.proto
sed -i "1ipackage com.alexhulbert.icewind;\n" ../Icewind/src/com/alexhulbert/icewind/Protocol.java

rm ../Icewind/src/com/alexhulbert/icewind/ChunkServer.java
./bin/protoc --java_out=../Icewind/src/com/alexhulbert/icewind  chunkserver.proto
sed -i "1ipackage com.alexhulbert.icewind;\n" ../Icewind/src/com/alexhulbert/icewind/ChunkServer.java