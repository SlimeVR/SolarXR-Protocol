{
  description = "A hardware-agnostic serialization protocol for full body tracking (FBT) in VR";

  inputs.nixpkgs.url = "nixpkgs/nixos-unstable";
  inputs.nixpkgs-jdk24.url = "github:NixOS/nixpkgs/d0fc30899600b9b3466ddb260fd83deb486c32f1";
  inputs.nixpkgs-flatbuffers.url = "nixpkgs/nixos-22.11";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, nixpkgs, nixpkgs-jdk24, nixpkgs-flatbuffers, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
        jdkPkgs = import nixpkgs-jdk24 { inherit system; };
        java = jdkPkgs.javaPackages.compiler.temurin-bin.jdk-24;
        pkgsFlatbuffers = nixpkgs-flatbuffers.legacyPackages.${system};
      in {
        devShells.default = pkgs.mkShell {
          nativeBuildInputs = [
            pkgsFlatbuffers.flatbuffers
            pkgs.direnv
            java
          ];
          shellHook = ''
            export JAVA_HOME=${java}
            export PATH="${java}/bin:$PATH"
          '';
        };
      }
    );
}
