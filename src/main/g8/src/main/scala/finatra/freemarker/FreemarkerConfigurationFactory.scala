package finatra.freemarker

import java.io.File

import freemarker.template.{Configuration, TemplateExceptionHandler}

case class FreemarkerConfigurationFactory(configuration: Configuration)

object FreemarkerConfigurationFactory {
  def apply(classLoader: ClassLoader, templateDir: String): FreemarkerConfigurationFactory = {
    val conf = configuration()
    conf.setClassLoaderForTemplateLoading(classLoader, templateDir)
    FreemarkerConfigurationFactory(conf)
  }

  def apply(templateDir: File): FreemarkerConfigurationFactory = {
    val conf = configuration()
    conf.setDirectoryForTemplateLoading(templateDir)
    FreemarkerConfigurationFactory(conf)
  }

  private def configuration(): Configuration = {
    val configuration = new Configuration(Configuration.VERSION_2_3_26)
    configuration.setDefaultEncoding(sys.props.get("file.encoding").getOrElse("UTF-8"))
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    configuration.setLogTemplateExceptions(false)
    configuration
  }
}