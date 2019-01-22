lazy val root = (project in file(".")).
  settings(
    test in Test := {
      val _ = (g8Test in Test).toTask("").value
    })