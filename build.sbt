scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"                   % "3.2.0"  % Test
, "org.scalatest"              %% "scalatest-funsuite"          % "3.2.0"  % Test
, "org.scalatest"              %% "scalatest-shouldmatchers"    % "3.2.0"  % Test
, "org.typelevel"              %% "simulacrum"        % "1.0.0"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions += "-Ymacro-annotations"

wartremoverErrors ++= Warts.unsafe
Compile / console / scalacOptions :=
  (console / scalacOptions).value.filterNot(_ contains "wartremover")
