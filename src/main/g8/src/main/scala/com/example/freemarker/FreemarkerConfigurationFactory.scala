package com.example.freemarker

import javax.inject.Singleton

import freemarker.template.{Configuration, TemplateExceptionHandler}

@Singleton
class FreemarkerConfigurationFactory {
  val configuration = new Configuration(Configuration.VERSION_2_3_25)

  def apply() {
    configuration.setDefaultEncoding(sys.props.get("file.encoding").getOrElse("UTF-8"))
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    configuration.setLogTemplateExceptions(false)
  }
}
