import Build._

assemblyMergeStrategy in assembly := {
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.last
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf" => MergeStrategy.concat
  case "unwanted.txt" => MergeStrategy.discard
  case "BUILD" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

test in assembly := {}

lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8"
    )),
    name := "hello",
    mainClass := Some("com.example.HelloServerMain"),
    libraryDependencies ++= Seq(
       "com.twitter" %% "finatra-http" % "$finatra$",
       "com.twitter" %% "finatra-httpclient" % "$finatra$",
       "com.twitter" %% "finatra-slf4j" % "$finatra$",
       "com.twitter" %% "finatra-thrift" % "$finatra$",
       "com.twitter" %% "inject-server" % "$finatra$",
       "com.twitter" %% "inject-app" % "$finatra$",       
       "org.freemarker" % "freemarker" % ver("freemarker"),
       "ch.qos.logback" % "logback-classic" % ver("logback"),
       "org.jdbi" % "jdbi" % ver("jdbi"),
       "com.h2database" % "h2" % ver("h2"),
       "com.twitter" %% "finatra-http" % "$finatra$" % "test" classifier "tests",
       "com.twitter" %% "inject-server" % "$finatra$" % "test" classifier "tests",
       "com.twitter" %% "inject-app" % "$finatra$" % "test" classifier "tests",
       "com.twitter" %% "inject-core" % "$finatra$" % "test" classifier "tests",
       "com.twitter" %% "inject-modules" % "$finatra$" % "test" classifier "tests",
       "org.mockito" % "mockito-core" % ver("mockito") % "test",       
       "org.scalatest" %% "scalatest" % ver("scalatest") % "test")
  )
