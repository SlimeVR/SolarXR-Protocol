{
  description = "A hardware-agnostic serialization protocol for full body tracking (FBT) in VR";

  inputs.nixpkgs.url = "nixpkgs/nixos-unstable";
  inputs.nixpkgs-flatbuffers.url = "nixpkgs/nixos-22.11";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, nixpkgs, nixpkgs-flatbuffers, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
        pkgsFlatbuffers = nixpkgs-flatbuffers.legacyPackages.${system};
      in {
        devShells.default = pkgs.mkShell {
          nativeBuildInputs = [
            pkgsFlatbuffers.flatbuffers
            pkgs.direnv
            pkgs.jdk25
          ];
          JAVA_HOME="${pkgs.jdk25}/lib/openjdk";
        };
      }
    );
}
