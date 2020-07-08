package com.meinergy.springcloud.payment.utils;

import com.meinergy.springcloud.commons.entity.Payment;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * CommonMethodUtil
 * 公共工具方法
 *
 * @author chenwang
 * @date 2020/7/8
 */
public class CommonMethodUtil {

    /**
     * 根据反射设置对象的属性值
     *
     * @param obj          需要进行操作的对象
     * @param propertyName 属性名
     * @param value        设置的值
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setPropertyValue(Object obj, String propertyName, Object value) {
        try {
            Class c = obj.getClass();
            Field field = c.getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据反射设置对象的属性值
     *
     * @param obj           需要进行操作的对象
     * @param propertyIndex 属性在所有属性中的index
     * @param value         设置的值
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setPropertyValue(Object obj, Integer propertyIndex, Object value) {
        try {
            //获取类对象
            Class c = obj.getClass();
            //获取对象所有属性数组
            Field[] fields = c.getDeclaredFields();
            Field field = fields[propertyIndex];
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run() {
        Payment p = new Payment(123L, "dsfweg");
        System.out.println(getPropertyValue(p, 0));
        System.out.println(getPropertyValue(p, "serial"));
        setPropertyValue(p, 0, 114L);
        setPropertyValue(p, "serial", "hahahah");
        System.out.println(getPropertyValue(p, 0));
        System.out.println(getPropertyValue(p, 1));
    }


    /**
     * 根据对象和属性的index得到对象属性值
     *
     * @param object        对象
     * @param propertyIndex 属性的index
     * @return
     */
    public static Object getPropertyValue(Object object, Integer propertyIndex) {
        Object value = 00.00;
        Class c = object.getClass();
        try {
            Field[] fields = c.getDeclaredFields();
            // 获取属性的名字
            String name = fields[propertyIndex].getName();
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            //获取属性的get方法
            Method m = c.getMethod("get" + name);
            // 获取属性的类型
            String type = fields[propertyIndex].getGenericType().toString();
            //根据属性类型调用getter方法获取属性值进行强制转换
            if (type.equals("class java.math.BigDecimal")) {
                //BigDecimal类型转换必须先转换成String类型
                if (m.invoke(object) == null) {
                    value = "";
                } else {
                    String s = m.invoke(object).toString();
                    value = Double.parseDouble(s);
                }
            } else if (type.equals("class java.lang.Double")) {
                //Double类型
                // 调用getter方法获取属性值
                if (m.invoke(object) == null) {
                    value = 0.00;
                } else {
                    value = (Double) m.invoke(object);
                }
            } else if (type.equals("class java.lang.Integer")) {
                //Integer类型
                if (m.invoke(object) != null) {
                    value = (Integer) m.invoke(object);
                } else {
                    value = 0;
                }
            } else if (type.equals("class java.lang.String")) {
                //String类型
                if (m.invoke(object) != null) {
                    value = (String) m.invoke(object);
                } else {
                    value = "";
                }
            } else if (type.equals("class java.lang.Long")) {
                //Long类型
                if (m.invoke(object) != null) {
                    value = (Long) m.invoke(object);
                } else {
                    value = 0L;
                }
            } else if (type.equals("class java.lang.Float")) {
                //Float类型
                if (m.invoke(object) != null) {
                    value = (Float) m.invoke(object);
                } else {
                    value = 0.0f;
                }
            }
        } catch (Exception exception) {
            System.out.println("----------------获取属性值失败，失败原因：" + exception.getMessage());
        }
        return value;
    }

    /**
     * 根据对象和属性名得到对象属性值
     *
     * @param object       对象
     * @param propertyName 属性名
     * @return
     */
    public static Object getPropertyValue(Object object, String propertyName) {
        Object value = 00.00;
        Class c = object.getClass();
        try {
            //获取属性
            Field field = c.getDeclaredField(propertyName);
            // 将属性的首字符大写，方便构造get，set方法
            propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
            //获取属性的get方法
            Method m = c.getMethod("get" + propertyName);
            // 获取属性的类型
            String type = field.getGenericType().toString();
            //根据属性类型调用getter方法获取属性值进行强制转换
            if (type.equals("class java.math.BigDecimal")) {
                //BigDecimal类型转换必须先转换成String类型
                if (m.invoke(object) == null) {
                    value = "0";
                } else {
                    String s = m.invoke(object).toString();
                    value = Double.parseDouble(s);
                }
            } else if (type.equals("class java.lang.Double")) {
                //double类型
                // 调用getter方法获取属性值
                if (m.invoke(object) == null) {
                    value = 0.0d;
                } else {
                    value = (Double) m.invoke(object);
                }
            } else if (type.equals("class java.lang.Integer")) {
                //Integer类型
                if (m.invoke(object) != null) {
                    value = (Integer) m.invoke(object);
                } else {
                    value = 0;
                }
            } else if (type.equals("class java.lang.String")) {
                //String类型
                if (m.invoke(object) != null) {
                    value = (String) m.invoke(object);
                } else {
                    value = "";
                }
            } else if (type.equals("class java.lang.Long")) {
                //Long类型
                if (m.invoke(object) != null) {
                    value = (Long) m.invoke(object);
                } else {
                    value = 0L;
                }
            } else if (type.equals("class java.lang.Float")) {
                //Float类型
                if (m.invoke(object) != null) {
                    value = (Float) m.invoke(object);
                } else {
                    value = 0.0f;
                }
            }
        } catch (Exception exception) {
            System.out.println("----------------获取属性值失败，失败原因：" + exception.getMessage());
        }
        return value;
    }
}
