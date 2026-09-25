$ErrorActionPreference = "Stop"
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot"

# TODO: check flatc version before doing anything

Remove-Item -ErrorAction Ignore -Recurse  protocol/java/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/cpp/include/solarxr_protocol/generated
Remove-Item -ErrorAction Ignore -Recurse  protocol/typescript/src
Remove-Item -ErrorAction Ignore -Recurse  protocol/rust/src/generated
Remove-Item -ErrorAction Ignore -Recurse  protocol/kotlin/src/generated/kotlin


flatc --java --gen-object-api --gen-all -o protocol/java/src -I ./schema/ ./schema/all.fbs
flatc --cpp --scoped-enums --gen-all -o protocol/cpp/include/solarxr_protocol/generated -I ./schema/ ./schema/all.fbs
flatc --ts --gen-object-api --gen-all -o protocol/typescript/src -I ./schema/ ./schema/all.fbs
flatc --rust --rust-module-root-file --gen-all -o protocol/rust/src/generated ./schema/all.fbs
./gradlew.bat :codegen:run --args="-o ./protocol/kotlin/src/generated/kotlin -I ./schema/ ./schema/all.fbs"
