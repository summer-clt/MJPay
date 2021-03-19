package com.mujin.utils;


import com.mujin.annotation.PropertyKey;
import org.springframework.util.Assert;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Description:
 *
 * @Author: 伍成林
 * @Date： 2021年 03月18日
 */
public final class PropertyLoadUtil {
    /**
     * set方法的前缀
     */
    private final static String SET_PREFIX = "set";
    /**
     * get方法的前缀
     */
    private final static String GET_PREFIX = "get";
    /**
     * boolean值的is
     */
    private final static String IS_PREFIX = "is";

    /**
     * 包装类boolean值的simpleName
     */
    private final static String PACKAGING_BOOLEAN_TYPE = "Boolean";
    /**
     * 基本类型的boolean值的simpleName
     */
    private final static String BASE_BOOLEAN_TYPE = "boolean";

    /**
     * 私有化工具类的构造器
     */
    private PropertyLoadUtil() {

    }

    /**
     * 配置简单的config类
     * TODO 暂时只考虑简单的对config配置类的赋值，不考虑IOC容器相互注入的问题
     *
     * @param tClass         需要配置的配置类的Class对象
     * @param propertiesName 需要读取的文件名
     * @param <T>            泛型
     * @return T 泛型的实例
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static <T> T loadProperties(Class<T> tClass, String propertiesName) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 创建是否赋过值的map
        Map<String, Boolean> theAssignmentMap = new HashMap<>(16);
        // 创建当前Class文件的实例
        T instance = tClass.newInstance();
        // 读取配置文件
        Properties properties = loadProperties(propertiesName);
        // 获取当前类中的所有属性
        Field[] fields = tClass.getDeclaredFields();
        // 获取当前类中的所有方法
        Method[] declaredMethods = tClass.getDeclaredMethods();
        // 设置属性的值
        setFieldValue(fields, tClass, instance, properties, theAssignmentMap);
        // 为方法赋值
        invokeMethods(declaredMethods, tClass, instance, properties, theAssignmentMap);

        return instance;
    }

    /**
     * 调用被@PropertyKey修饰的方法
     *
     * @param declaredMethods  Class类中所有的方法
     * @param tClass           Class对象
     * @param instance         Class对象的实例
     * @param properties       读取出来的配置文件
     * @param theAssignmentMap 是否赋值的map
     * @param <T>              泛型
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static <T> void invokeMethods(Method[] declaredMethods, Class<T> tClass, T instance, Properties properties, Map<String, Boolean> theAssignmentMap) throws InvocationTargetException, IllegalAccessException {
        for (Method method : declaredMethods) {
            boolean annotationPresent = method.isAnnotationPresent(PropertyKey.class);
            boolean isSetMethod = method.getName().startsWith(SET_PREFIX);
            // 判断是否有注解
            if (!annotationPresent) {
                continue;
            }
            // 判断是否有方法
            if (isSetMethod) {
                String filed = StrUtils.lowerCaseFirst(method.getName().replace(SET_PREFIX, ""));
                // 判断是否包含那个键，如果包含则说明已经有值了
                if (theAssignmentMap.containsKey(filed)) {
                    continue;
                }
            }
            // 注解中的值
            String value = method.getAnnotation(PropertyKey.class).value();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) {
                method.invoke(instance);
                return;
            }
            method.invoke(instance, parameterTypes[0].cast(properties.get(value)));
        }

    }

    /**
     * 为属性赋值
     *
     * @param fields        Class类中所有的属性的数组
     * @param tClass        Class对象
     * @param instance      当前Class对象的实例
     * @param properties    配置文件读取出来的名字
     * @param assignmentMap 赋值与否的map
     * @param <T>           泛型
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static <T> void setFieldValue(Field[] fields, Class<T> tClass, T instance, Properties properties, Map<String, Boolean> assignmentMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Field field : fields) {
            // 获取当前类中的属性的名字
            String fieldName = field.getName();
            // 判断是否有此注解
            boolean annotationPresent = field.isAnnotationPresent(PropertyKey.class);
            // 判断此前是否已经赋过值
            boolean isSetValue = assignmentMap.get(fieldName) != null && assignmentMap.get(fieldName);
            if (!annotationPresent || isSetValue) {
                continue;
            }
            // 获取注解的类
            PropertyKey annotation = field.getAnnotation(PropertyKey.class);
            // 获取注解中的value值
            String value = annotation.value();
            // 将参数的首字母大写，方便拼接方法
            String filedName = StrUtils.upperCaseFirst(field.getName());
            // 获取set方法
            Class<?> fieldType = field.getType();
            Method method = tClass.getMethod(SET_PREFIX + filedName, fieldType);
            method.invoke(instance, fieldType.cast(properties.get(value)));
        }
    }

    /**
     * 类型为boolean的属性设值
     *
     * @param tClass     反射类的class对象
     * @param instance   class对象生成的
     * @param properties 获取到的properties文件对象
     * @param field      类型为boolean的值
     * @param value      所属自定义注解中的value
     * @param <T>        反射泛型
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static <T> void booleanSetValue(Class<T> tClass, T instance, Properties properties, Field field, String value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object invoke;
        // 将参数的首字母大写，方便拼接方法
        String filedName = StrUtils.upperCaseFirst(field.getName());
        Method method = null;
        // 获取
        try {
            method = tClass.getMethod(IS_PREFIX + filedName);
        } catch (NoSuchMethodException e) {
            method = tClass.getMethod(GET_PREFIX + filedName);
        } finally {
            Assert.notNull(method, "当前class类：" + tClass.getName() + "中没有这个属性的get或is方法：" + GET_PREFIX + filedName);
            invoke = method.invoke(instance);
        }
        if (invoke == null || !Boolean.parseBoolean(invoke.toString())) {
            Method setMethod = tClass.getMethod(SET_PREFIX + filedName);
            setMethod.invoke(instance, properties.get(value));
        }
    }


    /**
     * 读取配置文件成properties类
     *
     * @param propertiesName 配置文件的名字
     * @return Properties 配置文件读取出来的类
     * @throws IOException 读取配置文件的流异常
     */
    private static Properties loadProperties(String propertiesName) throws IOException {
        URL resource = ClassLoader.getSystemResource(propertiesName);

        File propertiesFile = new File(resource.getPath());

        InputStream resourceStream = new FileInputStream(propertiesFile);
        Properties properties = new Properties();
        properties.load(resourceStream);

        resourceStream.close();
        return properties;
    }


}
