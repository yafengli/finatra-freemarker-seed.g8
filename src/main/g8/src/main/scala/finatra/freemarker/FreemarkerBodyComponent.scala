package finatra.freemarker

import java.util
import javax.inject.Inject

import com.twitter.finatra.http.marshalling.MessageBodyComponent

case class FreemarkerBodyComponent @Inject()(data: util.Map[String, Object], template: String) extends MessageBodyComponent