rm -rf protocol/java/src && ./lib/flatc-linux-x64 --java --gen-object-api --gen-all -o protocol/java/src -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
rm -rf protocol/cpp/include/solarxr_protocol/generated && ./lib/flatc-linux-x64 --cpp --scoped-enums --gen-all -o protocol/cpp/include/solarxr_protocol/generated -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
rm -rf protocol/typescript/src && ./lib/flatc-linux-x64 --ts --gen-object-api --gen-all -o protocol/typescript/src -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
# ./lib/flatc-linux-x64 -n --gen-all -o ./test -I ./protocol/flatbuffers ./protocol/flatbuffers/all.fbs
rm -rf protocol/rust/src/generated && ./lib/flatc-linux-x64 --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./protocol/flatbuffers/all.fbs
