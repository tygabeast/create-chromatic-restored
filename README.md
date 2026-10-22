# Create: Chromatic Restored (NeoForge 1.21.1)

Restores Create's removed Chromatic Compound, Shadow Steel, Refined Radiance, Shadow Casing and Radiant Casing.

* Recipes (in `src/main/resources/data/create_chromatic_restored/recipe/`):
  * Chromatic Compound: superheated mixing, 3 glowstone dust + 3 powdered obsidian + 3 polished rose quartz
  * Shadow Casing / Radiant Casing: apply Shadow Steel / Refined Radiance to a stripped log or stripped wood
* `ChromaticRestored.java` adds the five items to Create's creative tab (`create:base`). JEI lists whatever the creative tabs hold.
* Shadow Steel (drop the compound in the Void) and Refined Radiance (Beacon beam or absorbed light) are Create's own in-world logic.
  They need `shadowSteelRecipe` and `refinedRadianceRecipe` set to true under `[recipes]` in `create-server.toml`.

## Build

1. Install JDK 21.
2. Add a Gradle wrapper: copy `gradlew`, `gradlew.bat` and `gradle/` from the official NeoForge MDK
   (https://github.com/neoforged/MDK, 1.21.1 branch), or run `gradle wrapper`.
3. `./gradlew build` -> `build/libs/create_chromatic_restored-1.0.2.jar`
4. Put the jar in `mods/` next to Create 6.0.10 or newer.

If Gradle cannot resolve `net.neoforged.moddev` 2.0.78 or NeoForge 21.1.172, update `build.gradle` and
`gradle.properties` to the versions in the MDK's own files. Only those two version numbers should need changing.

Licence: MIT (see LICENSE). See NOTICE.md for credits.
