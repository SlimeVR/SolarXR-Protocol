$ErrorActionPreference = "Stop"

Remove-Item -ErrorAction Ignore -Recurse  protocol/java/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/cpp/include/solarxr_protocol/generated
Remove-Item -ErrorAction Ignore -Recurse  protocol/typescript/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/rust/src/generated


./lib/flatc.exe --java --gen-object-api --gen-all -o protocol/java/src -I ./schema/ ./schema/all.fbs
./lib/flatc.exe --cpp --scoped-enums --gen-all -o protocol/cpp/include/solarxr_protocol/generated -I ./schema/ ./schema/all.fbs
./lib/flatc.exe --ts --gen-object-api --gen-all -o protocol/typescript/src -I ./schema/ ./schema/all.fbs
./lib/flatc.exe --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./schema/all.fbs
