package com.examples.activitiSpringMvc.configuration;

import javax.sql.DataSource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivitiSpringMvcConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.activitiSpringMvc")
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class ActivitiSpringMvcConfiguration extends WebMvcConfigurerAdapter {

	/** The environment. */
	@Autowired
	Environment environment;
	
	

	/**
	 * Configures View Resolver
	 *
	 * @return the viewResolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}


	/**
	 * Configures MessageSource to provide internationalized messages
	 *
	 * @return the messageSource
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}


	/**
	  (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 *
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}


	/**
	 * 	 Configures processEngineConfiguration to be provided to Activiti's
	 * processEngine
	 *
	 * @return the processEngineConfiguration
	 */
	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
		processEngineConfiguration.setDataSource(activitiDataSource());
		processEngineConfiguration.setTransactionManager(activitiTransactionManager());
		processEngineConfiguration.setDatabaseSchemaUpdate("true");
		processEngineConfiguration.setJobExecutorActivate(true);
		processEngineConfiguration.setHistory("full");

		return processEngineConfiguration;
	}

	/**
	 * Configures  Activiti's  processEngine.
	 *
	 * @return the process engine factory bean
	 */
	@Bean
	public ProcessEngineFactoryBean processEngine() {
		ProcessEngineFactoryBean processEngine = new ProcessEngineFactoryBean();
		processEngine.setProcessEngineConfiguration(processEngineConfiguration());

		return processEngine;
	}

	/**
	 * Form service.
	 *
	 * @param processEngine the processEngine
	 * @return the formService
	 * @throws Exception the exception
	 */
	@Bean
	public FormService formService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getFormService();
	}

	/**
	 * Repository service.
	 *
	 * @param processEngine the processEngine
	 * @return the repositoryService
	 * @throws Exception the exception
	 */
	@Bean
	public RepositoryService repositoryService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getRepositoryService();
	}

	/**
	 * Runtime service.
	 *
	 * @param processEngine the processEngine
	 * @return the runtimeService
	 * @throws Exception the exception
	 */
	@Bean
	public RuntimeService runtimeService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getRuntimeService();
	}

	/**
	 * Task service.
	 *
	 * @param processEngine the processEngine
	 * @return the task service
	 * @throws Exception the exception
	 */
	@Bean
	public TaskService taskService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getTaskService();
	}

	/**
	 * History service.
	 *
	 * @param processEngine the processEngine
	 * @return the history service
	 * @throws Exception the exception
	 */
	@Bean
	public HistoryService historyService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getHistoryService();
	}

	/**
	 * Management service.
	 *
	 * @param processEngine the processEngine
	 * @return the management service
	 * @throws Exception the exception
	 */
	@Bean
	public ManagementService managementService(ProcessEngineFactoryBean processEngine) throws Exception {
		return processEngine.getObject().getManagementService();
	}

	/**
	 * Activiti data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource activitiDataSource() {
		DriverManagerDataSource activitiDataSource = new DriverManagerDataSource();
		activitiDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		activitiDataSource.setUrl(environment.getRequiredProperty("jdbc.activitiUrl"));
		activitiDataSource.setUsername(environment.getRequiredProperty("jdbc.activitiUsername"));
		activitiDataSource.setPassword(environment.getRequiredProperty("jdbc.activitiPassword"));
		return activitiDataSource;
	}

	/**
	 * Activiti transaction manager.
	 *
	 * @return the data source transaction manager
	 */
	@Bean
	// @Autowired //TODO: Review this piece of code
	public DataSourceTransactionManager activitiTransactionManager() {
		DataSourceTransactionManager activitiTransactionManager = new DataSourceTransactionManager();
		activitiTransactionManager.setDataSource(activitiDataSource());
		return activitiTransactionManager;
	}

}