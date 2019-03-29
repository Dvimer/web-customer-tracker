package web.customer.tracker.webapp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "web.customer.tracker.webapp")
@EnableAspectJAutoProxy
@PropertySource({"classpath:persistence-mysql.properties", "classpath:security-persistence-mysql.properties"})
public class DemoAppConfig implements WebMvcConfigurer
{

	@Autowired
	Environment env;

	private Logger logger = Logger.getLogger(DemoAppConfig.class.getName());

	@Bean
	public ViewResolver viewResolver()
	{

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	@Bean
	public DataSource securityDataSource()
	{
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try
		{
			securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
		}
		catch (PropertyVetoException exc)
		{
			throw new RuntimeException(exc);
		}

		logger.info(">>> security.jdbc.url=" + env.getProperty("security.jdbc.url"));
		logger.info(">>> security.jdbc.user=" + env.getProperty("security.jdbc.user"));

		securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
		securityDataSource.setUser(env.getProperty("security.jdbc.user"));
		securityDataSource.setPassword(env.getProperty("security.jdbc.password"));

		// set connection pool props

		securityDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	@Bean
	public DataSource myDataSource()
	{

		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try
		{
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");
		}
		catch (PropertyVetoException exc)
		{
			throw new RuntimeException(exc);
		}
		logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		// set database connection props
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool props
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return myDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new
			LocalSessionFactoryBean();
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	private Properties getHibernateProperties()
	{
		// set hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	private String getProperty(String s)
	{
		return env.getProperty(s);
	}

	private Integer getIntProperty(String s)
	{
		return env.getProperty(s, Integer.class);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}
}











