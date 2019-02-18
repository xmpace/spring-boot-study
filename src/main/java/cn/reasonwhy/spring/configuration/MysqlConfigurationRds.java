package cn.reasonwhy.spring.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan(
        value = "cn.reasonwhy.spring.rds.mapper",
        sqlSessionFactoryRef = "rdsSqlSessionFactory",
        nameGenerator = DefaultBeanNameGenerator.class
)
public class MysqlConfigurationRds {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    protected HikariDataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    protected SqlSessionFactory rdsSqlSessionFactory(HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
