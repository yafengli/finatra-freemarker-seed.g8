package finatra.freemarker

import java.io._

import freemarker.template._

package object template {

  val configuration = {
    val conf = new Configuration(Configuration.VERSION_2_3_26)
    conf.setObjectWrapper(new ScalaObjectWrapper)
    conf.setClassLoaderForTemplateLoading(this.getClass.getClassLoader, "")
    conf
  }

  def ftl2string(template: String, root: Any): String = {
    val result = new StringWriter
    configuration.getTemplate(template).process(root, result)
    result.toString
  }

  val resolveFields = getBool("ftl.wrapper.resolveFields", true)
  val resolveMethods = getBool("ftl.wrapper.resolveMethods", true)
  val delegateToDefault = getBool("ftl.wrapper.delegateToDefault", false)

  def getBool(key: String, defaultVal: Boolean): Boolean = if (System.getProperty(key) != null) System.getProperty(key).toBoolean else defaultVal
}
