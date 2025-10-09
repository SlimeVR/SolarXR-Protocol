$ErrorActionPreference = "Stop"

# TODO: check flatc version before doing anything

Remove-Item -ErrorAction Ignore -Recurse  protocol/java/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/cpp/include/solarxr_protocol/generated
Remove-Item -ErrorAction Ignore -Recurse  protocol/typescript/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/rust/src/generated
Remove-Item -ErrorAction Ignore -Recurse  protocol/kotlin/src


& "flatc" --java --gen-object-api --gen-all -o protocol/java/src -I ./schema/ ./schema/all.fbs
& "flatc" --cpp --scoped-enums --gen-all -o protocol/cpp/include/solarxr_protocol/generated -I ./schema/ ./schema/all.fbs
& "flatc" --ts --gen-object-api --gen-all -o protocol/typescript/src -I ./schema/ ./schema/all.fbs
& "flatc" --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./schema/all.fbs
& "flatc" --kotlin --gen-jvmstatic --gen-all -o ./protocol/kotlin/src -I ./schema/ ./schema/all.fbs
