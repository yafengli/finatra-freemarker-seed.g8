import Build._

resolvers +=  "Finatra-Freemarker-Seed Repository" at "https://dl.bintray.com/yafengli/maven/"

lazy val root = (project in file(".")).settings(
    organization := "com.example",
    scalaVersion := v("scala"),
    name := "hello",
    mainClass := Some("com.example.HelloServerMain"),
    libraryDependencies ++= Seq(
      "greatbit" %% "finatra-freemarker" % v("finatra"),
      "ch.qos.logback" % "logback-classic" % v("logback"),
      "org.jdbi" % "jdbi" % v("jdbi"),
      "com.h2database" % "h2" % v("h2"),

      "com.twitter" %% "finatra-http" % v("finatra") % "test",
      "com.twitter" %% "finatra-jackson" % v("finatra") % "test",
      "com.twitter" %% "inject-server" % v("finatra") % "test",
      "com.twitter" %% "inject-app" % v("finatra") % "test",
      "com.twitter" %% "inject-core" % v("finatra") % "test",
      "com.twitter" %% "inject-modules" % v("finatra") % "test",
      "com.google.inject.extensions" % "guice-testlib" % v("guice") % "test",

      "com.twitter" %% "finatra-http" % v("finatra") % "test" classifier "tests",
      "com.twitter" %% "finatra-jackson" % v("finatra" % "test" classifier "tests",
      "com.twitter" %% "inject-server" % v("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-app" % v("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-core" % v("finatra") % "test" classifier "tests",
      "com.twitter" %% "inject-modules" % v("finatra") % "test" classifier "tests",
      
      "org.mockito" % "mockito-core" % v("mockito") % "test",    
      "org.scalatest" %% "scalatest" % v("scalatest") % "test")
  )
