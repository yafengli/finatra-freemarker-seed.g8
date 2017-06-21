import Build._

lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging).
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
       "com.twitter" %% "finatra-http" % ver("finatra") % "test" classifier "tests",       
       "org.scalatest" %% "scalatest" % ver("scalatest") % "test")
  )
