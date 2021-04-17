scalaVersion := "3.0.0-RC2"

libraryDependencies ++= Seq(
  "org.scalameta"              %% "munit"             % "0.7.23" % Test
)

testFrameworks += new TestFramework("munit.Framework")
