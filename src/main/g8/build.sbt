import Build._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
       "com.twitter" %% "finatra-http" % $finatra$,
       "com.twitter" %% "finatra-httpclient" % $finatra$,
       "com.twitter" %% "finatra-slf4j" % $finatra$,
       "com.twitter" %% "finatra-thrift" % $finatra$,
       "com.twitter" %% "inject-server" % $finatra$,
       "com.twitter" %% "inject-app" % $finatra$,       
       "org.freemarker" % "freemarker" % #("freemarker"),
       "ch.qos.logback" % "logback-classic" % #("logback"),
       "com.twitter" %% "finatra-http" % $finatra$ % "test" classifier "tests",
       "com.twitter" %% "inject-server" % $finatra$ % "test" classifier "tests",
       "com.twitter" %% "inject-app" % $finatra$ % "test" classifier "tests",
       "com.twitter" %% "inject-core" % $finatra$ % "test" classifier "tests",
       "com.twitter" %% "inject-modules" % $finatra$ % "test" classifier "tests",
       "org.mockito" % "mockito-core" % #("mockito") % "test",
       "org.specs2" %% "specs2" % #("specs2") % "test",
       "org.scalatest" %% "scalatest" % #("scalatest") % "test")
  )
