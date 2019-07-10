scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"     % "3.0.8"  % "test"
, "org.scalacheck"             %% "scalacheck"    % "1.14.0" % "test"
, "org.typelevel"              %% "discipline"    % "0.10.0"
, "eu.timepit"                 %% "refined"       % "0.9.8"
, "com.beachape"               %% "enumeratum"    % "1.5.13"
, "com.github.mpilquist"       %% "simulacrum"    % "0.15.0"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.typelevel"  %% "kind-projector" % "0.10.3")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

wartremoverErrors ++= Warts.unsafe
Compile / console / scalacOptions :=
  (console / scalacOptions).value.filterNot(_ contains("wartremover"))
