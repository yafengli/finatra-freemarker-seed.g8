import Build._

resolvers +=  "Finatra-Freemarker-Seed Repository" at "https://dl.bintray.com/yafengli/maven/"

lazy val root = (project in file(".")).enablePlugins(SbtDistApp).
  settings(
    organization := "com.example",
    scalaVersion := ver("scala"),
    name := "hello",
    mainClass := Some("com.example.HelloServerMain"),
    libraryDependencies ++= Seq(
      "greatbit" %% "finatra-freemarker" % ver("finatra"),
      "ch.qos.logback" % "logback-classic" % ver("logback"),
      "org.jdbi" % "jdbi" % ver("jdbi"),
      "com.h2database" % "h2" % ver("h2"),
      "com.twitter" %% "finatra-http" % ver("finatra") % "test",
      "com.twitter" %% "inject-server" % ver("finatra") % "test",
      "com.twitter" %% "inject-app" % ver("finatra") % "test",
      "com.twitter" %% "inject-core" % ver("finatra") % "test",
      "com.twitter" %% "inject-modules" % ver("finatra") % "test",
      "com.google.inject.extensions" % "guice-testlib" % ver("guice") % "test",
      "com.twitter" %% "finatra-http" % ver("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-server" % ver("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-app" % ver("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-core" % ver("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-modules" % ver("finatra") % "test" classifier "tests",
      "org.scalatest" %% "scalatest" % ver("scalatest") % "test")
  )
