package cn.reasonwhy.spring.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        value = "cn.reasonwhy.spring.rds.mapper",
        sqlSessionFactoryRef = "drdsSqlSessionFactory",
        nameGenerator = DefaultBeanNameGenerator.class
)
public class MysqlConfigurationDrds {

    @Bean
    @ConfigurationProperties(prefix = "spring.druid.drds")
    protected DruidDataSource drdsDruidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    protected SqlSessionFactory drdsSqlSessionFactory(DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
