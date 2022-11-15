package org.sv.movie.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:application.properties" })
@Configuration
public class DBConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;

    //este metodo sustituye la configuracion a nivel de properties

   /* @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.url("jdbc:mysql://localhost:3306/movies?useSSL=true&serverTimezone=Europe/Madrid");
        dataSource.username("root");
        dataSource.password("Holamundo23$");
        return dataSource.build();
    }
    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        return properties;
    }

    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getDataSource());
        factory.setHibernateProperties(getHibernateProperties());
        factory.setPackagesToScan("");
        return factory;
    }*/
}
