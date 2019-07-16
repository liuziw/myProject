package com.zw.proxy;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/10 17:26
 */
public class ConfigFactory {
    private ConfigFactory() {}

    public static IConfig create(final InputStream is) throws IOException {

        final Properties properties = new Properties();
        properties.load(is);

        return (IConfig) Proxy.newProxyInstance(IConfig.class.getClassLoader(),
                new Class[] { IConfig.class }, new PropertyMapper(properties));

    }

    public static final class PropertyMapper implements InvocationHandler {

        private final Properties properties;

        public PropertyMapper(Properties properties) {
            this.properties = properties;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            final Value value = method.getAnnotation(Value.class);

            if (value == null) return null;

            String property = properties.getProperty(value.value());
            if (property == null) return (null);

            final Class<?> returns = method.getReturnType();
            if (returns.isPrimitive())
            {
                if (returns.equals(int.class)) return (Integer.valueOf(property));
                else if (returns.equals(long.class)) return (Long.valueOf(property));
                else if (returns.equals(double.class)) return (Double.valueOf(property));
                else if (returns.equals(float.class)) return (Float.valueOf(property));
                else if (returns.equals(boolean.class)) return (Boolean.valueOf(property));
            }

            return property;
        }

    }

    public static void main(String [] args) throws FileNotFoundException, IOException {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("classpath:config/config.properties");
        IConfig config = ConfigFactory.create(resource.getInputStream());
        String dbUrl = config.dbUrl();
        boolean isLoginValidated = config.isValidated();
        int dbPoolSize = config.poolSize();
        System.out.println(dbUrl+isLoginValidated+dbPoolSize);
    }
}
