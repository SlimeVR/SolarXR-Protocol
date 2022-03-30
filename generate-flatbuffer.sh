flatc --scoped-enums -o protocol/java/src --java protocol/flatbuffers/**/*.fbs
flatc --scoped-enums -o protocol/cpp/include/slimevr_protocol/generated --cpp protocol/flatbuffers/**/*.fbs
flatc --scoped-enums -o protocol/typescript/src --ts protocol/flatbuffers/**/*.fbs
