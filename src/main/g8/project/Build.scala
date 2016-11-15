
import sbt._
import scala.io.Source

object Build {
  var reg = "(.+)=(.+)".r
  val ver = Source.fromFile("project/build.properties").getLines().filter(reg.findFirstMatchIn(_).isDefined).map(reg.findFirstMatchIn(_).get).map(m => m.group(1) -> m.group(2)).toMap 
}
