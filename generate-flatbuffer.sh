#!/usr/bin/env bash
set -e
VERSION="22.10.26"

if [[ -f "./flatc" ]]; then
	PATH="./:$PATH"
fi

if [[ "$(flatc --version)" != "flatc version $VERSION" ]]; then
	echo "Flatc must be $VERSION"
	exit 1
fi

rm -rf protocol/java/src
rm -rf protocol/cpp/include/solarxr_protocol/generated
rm -rf protocol/typescript/src
rm -rf protocol/rust/src/generated
rm -rf protocol/kotlin/src

flatc --java --gen-object-api --gen-all -o ./protocol/java/src -I ./schema/ ./schema/all.fbs && \
flatc --cpp --scoped-enums --gen-all -o ./protocol/cpp/include/solarxr_protocol/generated -I ./schema/ ./schema/all.fbs && \
flatc --ts --gen-object-api --gen-all -o ./protocol/typescript/src -I ./schema/ ./schema/all.fbs && \
flatc --rust --rust-module-root-file --gen-all -o ./protocol/rust/src/generated ./schema/all.fbs && \
flatc --kotlin --gen-jvmstatic --gen-all -o ./protocol/kotlin/src -I ./schema/ ./schema/all.fbs
