#!/bin/bash
set -ex

rm -rf protocol/java/src && ./flatc --java --gen-object-api --gen-all -o ./protocol/java/src -I ./schema/ ./schema/all.fbs && \
rm -rf protocol/cpp/include/solarxr_protocol/generated && ./flatc --cpp --scoped-enums --gen-all -o ./protocol/cpp/include/solarxr_protocol/generated -I ./schema/ ./schema/all.fbs && \
rm -rf protocol/typescript/src && ./flatc --ts --gen-object-api --gen-all -o ./protocol/typescript/src -I ./schema/ ./schema/all.fbs && \
rm -rf protocol/rust/src/generated && ./flatc --rust --rust-module-root-file --gen-all -o ./protocol/rust/src/generated ./schema/all.fbs
