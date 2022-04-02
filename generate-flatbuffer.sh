flatc --java -o protocol/java/src protocol/flatbuffers/**/*.fbs && \
flatc --cpp --scoped-enums -o protocol/cpp/include/slimevr_protocol/generated protocol/flatbuffers/**/*.fbs && \
flatc --ts --gen-object-api -o protocol/typescript/src -I ./protocol/flatbuffers/ ./protocol/flatbuffers/server.fbs ./protocol/flatbuffers/firmware.fbs && \
flatc --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./protocol/flatbuffers/all.fbs
