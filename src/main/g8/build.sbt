name := "$name;format="norm"$"

organization := "$project_group_id$"

version := "0.1.0-SNAPSHOT"

homepage := Some(url("https://github.com/$github_username$/$name;format="norm"$"))

startYear := Some(2013)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/$github_username$/$name;format="norm"$"),
    "scm:git:https://github.com/$github_username$/$name;format="norm"$.git",
    Some("scm:git:git@github.com:$github_username$/$name;format="norm"$.git")
  )
)

/* scala versions and options */
scalaVersion := "2.10.2"

crossScalaVersions := Seq(
/*  "2.9.3-RC1",
  "2.9.2",
  "2.9.1", "2.9.1-1",
  "2.9.0", "2.9.0-1",
  "2.8.0", "2.8.1", "2.8.2" */
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  ,"-unchecked"
  ,"-encoding", "UTF-8"
  ,"-target:jvm-1.6"
  // "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.10") List(
    "-Xverify"
    ,"-Ywarn-all"
    ,"-feature"
    ,"-language:postfixOps"
    // "-language:reflectiveCalls",
    // "-language:implicitConversions"
    // "-language:higherKinds",
    // "-language:existentials",
    // "-language:experimental.macros",
    // "-language:experimental.dynamics"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq (
  // -- testing --
  "org.scalatest" % "scalatest_2.10" % "2.0.M7" % "test"
  , "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test" 
  // -- config --
  , "com.typesafe" % "config" % "1.0.2"
  // -- Logging --
  , "ch.qos.logback" % "logback-classic" % "1.0.13"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeRepo("releases")
  // "spray repo" at "http://repo.spray.io"
)

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("$project_group_id$.$name;format="snake"$.Main")

assemblySettings

test in AssemblyKeys.assembly := {}

net.virtualvoid.sbt.graph.Plugin.graphSettings
