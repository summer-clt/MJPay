package com.mujin.io;

import java.io.InputStream;
import java.util.Map;

/**
 * Description:
 *
 * @Author: 伍成林
 * @Date： 2021年 03月19日
 */
public interface PropertiesResourceLoad {
    /**
     * 读取配置文件的接口
     *
     * @param inputStream 输入流
     * @return map<String, String>
     */
    Map<String, String> load(InputStream inputStream);

    /**
     * 读取成自己想要的类
     *
     * @param inputStream 输入流
     * @param tClass      class队形
     * @param <T>         泛型
     * @return T
     */
    <T> T load(InputStream inputStream, Class<T> tClass);
}
