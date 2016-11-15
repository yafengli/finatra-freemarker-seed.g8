import Build._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.0"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
       "com.twitter" %% "finatra-http" % $("finatra"),
       "com.twitter" %% "finatra-httpclient" % $("finatra"),
       "com.twitter" %% "finatra-slf4j" % $("finatra"),
       "com.twitter" %% "finatra-thrift" % $("finatra"),
       "com.twitter" %% "inject-server" % $("finatra"),
       "com.twitter" %% "inject-app" % $("finatra"),
       "org.apache.shiro" % "shiro-core" % $("shiro"),
       "com.github.finagle" %% "finagle-oauth2" % $("finagle-oauth2"),
       "org.jdbi" % "jdbi" % $("jdbi"),
       "org.hibernate" % "hibernate-entitymanager" % $("hibernate"),
       "org.hibernate" % "hibernate-hikaricp" % $("hibernate"),
       "dom4j" % "dom4j" % $("dom4j"),
       "org.springframework.data" % "spring-data-jpa" % $("spring-data-jpa"),
       "org.postgresql" % "postgresql" % $("postgresql"),
       "com.h2database" % "h2" % $("h2"),
       "org.freemarker" % "freemarker" % $("freemarker"),
       "ch.qos.logback" % "logback-classic" % $("logback"),
       "com.twitter" %% "finatra-http" % $("finatra") % "test" classifier "tests",
       "com.twitter" %% "inject-server" % $("finatra") % "test" classifier "tests",
       "com.twitter" %% "inject-app" % $("finatra") % "test" classifier "tests",
       "com.twitter" %% "inject-core" % $("finatra") % "test" classifier "tests",
       "com.twitter" %% "inject-modules" % $("finatra") % "test" classifier "tests",
       "org.mockito" % "mockito-core" % $("mockito") % "test",
       "org.specs2" %% "specs2" % "2.3.12" % "test",
       "org.scalatest" %% "scalatest" % $("scalatest") % "test")
  )
