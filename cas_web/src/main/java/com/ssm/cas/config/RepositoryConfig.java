package com.ssm.cas.config;

import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: 胖虎
 * @date: 2019/6/9 23:20
 **/
@Configuration
@MapperScan(basePackages = {"com.ssm.cas.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
@ComponentScan(basePackages = {"com.ssm.cas.dao"})
public class RepositoryConfig {

    @Bean
    public ComboPooledDataSource dataSource() throws SQLException {
        return new ComboPooledDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        //配置分页插件的拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        PageInterceptor[] pageInterceptors = {pageInterceptor};

        factoryBean.setPlugins(pageInterceptors);

        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

/*    @Bean
    public UserDao userDao() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate.getMapper(UserDao.class);
    }*/

}
