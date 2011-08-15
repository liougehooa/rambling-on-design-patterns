package pattern.part3.chapter7;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2009-12-1
 * Time: 21:53:50
 */
public class CopyUtils {
    private static Map<String, PropertyDescriptor> getPropertyDescriptor(Class clazz) {
        Map<String, PropertyDescriptor> propertyDescriptorMap = new HashMap<String, PropertyDescriptor>();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < pds.length; i++) {
                PropertyDescriptor pd = pds[i];
                propertyDescriptorMap.put(pd.getName(), pd);
            }
            return propertyDescriptorMap;
        } catch (IntrospectionException e) {
            throw new RuntimeException("Can not get bean info from class : " + clazz.getName(), e);
        } finally {
            if (beanInfo != null) {
                //release caches of this class gracefully
                Introspector.flushFromCaches(clazz);
            }
        }
    }

    public static void copyOf(Object source, Object target) {
        if (source == null) {   //qucik return
            return;
        }
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(target.getClass(), Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            Map<String, PropertyDescriptor> srcBeanInfo = getPropertyDescriptor(source.getClass());
            for (PropertyDescriptor targetPd : pds) {
                if (targetPd.getWriteMethod() != null) {
                    PropertyDescriptor sourcePd = srcBeanInfo.get(targetPd.getName());
                    if (sourcePd != null && sourcePd.getReadMethod() != null) {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source, new Object[0]);
                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, new Object[]{value});
                    }

                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Unable to copy properties : ", e);
        }
        finally {
            if (beanInfo != null) {
                //release caches of this class gracefully
                Introspector.flushFromCaches(target.getClass());
            }

        }

    }
}
