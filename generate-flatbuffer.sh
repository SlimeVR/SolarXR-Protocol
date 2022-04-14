rm -rf protocol/java/src && flatc --java --gen-object-api --gen-all -o protocol/java/src -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
rm -rf protocol/cpp/include/slimevr_protocol/generated && flatc --cpp --scoped-enums --gen-all -o protocol/cpp/include/slimevr_protocol/generated -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
rm -rf protocol/typescript/src && flatc --ts --gen-object-api --gen-all -o protocol/typescript/src -I ./protocol/flatbuffers/ ./protocol/flatbuffers/all.fbs && \
# flatc -n --gen-all -o ./test -I ./protocol/flatbuffers ./protocol/flatbuffers/all.fbs
rm -rf protocol/rust/src/generated && flatc --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./protocol/flatbuffers/all.fbs
