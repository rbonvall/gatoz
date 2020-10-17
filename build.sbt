scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"         % "3.2.0"  % Test
, "org.scalacheck"             %% "scalacheck"        % "1.14.1" % Test
, "org.typelevel"              %% "discipline-core"   % "1.0.0"
, "eu.timepit"                 %% "refined"           % "0.9.17"
, "com.beachape"               %% "enumeratum"        % "1.6.1"
, "org.typelevel"              %% "simulacrum"        % "1.0.0"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions += "-Ymacro-annotations"

wartremoverErrors ++= Warts.unsafe
Compile / console / scalacOptions :=
  (console / scalacOptions).value.filterNot(_ contains "wartremover")
