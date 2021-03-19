package com.mujin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Description:
 *
 * @Author: wuchenglin
 * @Date： 2020/7/1
 */
@Configuration
@Slf4j
public class CustomPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
        String[] actives = encodedResource.getResource().getFilename().split("\\.")[0].replace(name + "-", "").split(",");
        log.info("encodedResource : {},actives : {} ,activesLength : {}, actives[0] : {}",encodedResource,Arrays.toString(actives),actives.length,actives[0]);
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("application" + "-" + actives[0] + ".properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        //如果只有一个，就直接返回
        return new ResourcePropertySource(encodedResource);
    }

}
