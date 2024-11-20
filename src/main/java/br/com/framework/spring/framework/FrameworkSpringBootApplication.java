package br.com.framework.spring.framework;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@SpringBootApplication
public class FrameworkSpringBootApplication {
	
	@Autowired
	private Configuration cfg;

	public static void main(String[] args) {
		SpringApplication.run(FrameworkSpringBootApplication.class, args);
	}

	@Bean
	public boolean teste(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Template template = cfg.getTemplate("GetModel.ftl");

		StringWriter out = new StringWriter();

		Map<String, String> params = new HashMap<>();
		params.put("tipo", "String");
		params.put("nomeAtributo", StringUtils.capitalize("nome"));
		params.put("atributo", "nome");

		template.process(params, out);

		System.out.println(out.toString());

		return true;
	}

}
