flatc -o protocol/java/src --java protocol/flatbuffers/**/*.fbs && \
flatc --scoped-enums -o protocol/cpp/include/slimevr_protocol/generated --cpp protocol/flatbuffers/**/*.fbs && \
flatc -o protocol/typescript/src --ts -I .\protocol\flatbuffers\ .\protocol\flatbuffers\server.fbs .\protocol\flatbuffers\firmware.fbs
