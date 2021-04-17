scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "org.scalameta"              %% "munit"             % "0.7.23" % Test
, "org.typelevel"              %% "simulacrum"        % "1.0.0"
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions += "-Ymacro-annotations"

testFrameworks += new TestFramework("munit.Framework")

wartremoverErrors ++= Warts.unsafe
Compile / console / scalacOptions :=
  (console / scalacOptions).value.filterNot(_ contains "wartremover")
