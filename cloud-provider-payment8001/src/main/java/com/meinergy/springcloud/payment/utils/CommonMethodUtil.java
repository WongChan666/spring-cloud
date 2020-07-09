package com.meinergy.springcloud.payment.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * CommonMethodUtil
 * 公共工具方法类
 *
 * @author chenwang
 */
public class CommonMethodUtil {

    /**
     * 根据属性index设置对象的属性值
     *
     * @param obj          需要进行操作的对象
     * @param propertyName 属性名
     * @param value        设置的值
     */
    public static void setPropertyValue(Object obj, String propertyName, Object value) {
        try {
            //获取类对象
            Class c = obj.getClass();
            //获取属性
            Field field = c.getDeclaredField(propertyName);
            field.setAccessible(true);
            if (value == null) {
                System.out.println("--------------------------------------警告：参数value的值为null！！！！！！！！");
            }
            field.set(obj, value);
        } catch (Exception e) {
            System.out.println("--------------------------------------设置对象属性值报错，错误信息：" + e.getMessage());
        }
    }

    /**
     * 根据属性index设置对象的属性值
     *
     * @param obj           需要进行操作的对象
     * @param propertyIndex 属性在所有属性中的index
     * @param value         设置的值
     */
    public static void setPropertyValue(Object obj, Integer propertyIndex, Object value) {
        try {
            //获取类对象
            Class c = obj.getClass();
            //获取对象所有属性数组
            Field[] fields = c.getDeclaredFields();
            //获取属性
            Field field = fields[propertyIndex];
            field.setAccessible(true);
            if (value == null) {
                System.out.println("--------------------------------------警告：参数value的值为null！！！！！！！！");
            }
            field.set(obj, value);
        } catch (Exception e) {
            System.out.println("--------------------------------------设置对象属性值报错，错误信息：" + e.getMessage());
        }
    }


    /**
     * 根据对象和属性的index获取对象属性值
     * 注意：若该属性值为null，则返回相应的初值。
     *
     * @param object        对象
     * @param propertyIndex 属性的index
     * @return
     */
    public static Object getPropertyValue(Object object, Integer propertyIndex) {
        Object value = 00.00;
        //获取类对象
        Class c = object.getClass();
        try {
            Field[] fields = c.getDeclaredFields();
            Field field = fields[propertyIndex];
            field.setAccessible(true);
            //获取该属性数据类型
            String type = field.getGenericType().toString();
            value = field.get(object);
            if (type.equals("class java.math.BigDecimal")) {
                //BigDecimal类型转换必须先转换成String类型
                if (value == null) {
                    value = "";
                }
                return value;
            } else if (type.equals("class java.lang.Double")) {
                //double类型
                if (value == null) {
                    value = 0.0d;
                }
                return value;
            } else if (type.equals("class java.lang.Integer")) {
                //Integer类型
                if (value == null) {
                    value = 0;
                }
                return value;
            } else if (type.equals("class java.lang.String")) {
                //String类型
                if (value == null) {
                    value = "";
                }
                return value;
            } else if (type.equals("class java.lang.Long")) {
                //Long类型
                if (value == null) {
                    value = 0L;
                }
                return value;
            } else if (type.equals("class java.lang.Float")) {
                //Float类型
                if (value == null) {
                    value = 0.0f;
                }
                return value;
            } else if (type.equals("class java.util.Date")) {
                //Date类型
                if (value == null) {
                    value = new Date();
                }
                return value;
            }
        } catch (Exception exception) {
            System.out.println("--------------------------------------获取属性值失败，失败原因：" + exception.getMessage());
        }
        return value;
    }

    /**
     * 根据对象和属性名获取对象属性值
     * 注意：若该属性值为null，则返回相应的初值。
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
            field.setAccessible(true);
            //获取该属性数据类型
            String type = field.getGenericType().toString();
            value = field.get(object);
            if (type.equals("class java.math.BigDecimal")) {
                //BigDecimal类型转换必须先转换成String类型
                if (value == null) {
                    value = "";
                }
                return value;
            } else if (type.equals("class java.lang.Double")) {
                //double类型
                if (value == null) {
                    value = 0.0d;
                }
                return value;
            } else if (type.equals("class java.lang.Integer")) {
                //Integer类型
                if (value == null) {
                    value = 0;
                }
                return value;
            } else if (type.equals("class java.lang.String")) {
                //String类型
                if (value == null) {
                    value = "";
                }
                return value;
            }
            else if (type.equals("class java.lang.Character")) {
                //Character类型
                if (value == null) {
                    value = '-';
                }
                return value;
            }else if (type.equals("class java.lang.Long")) {
                //Long类型
                if (value == null) {
                    value = 0L;
                }
                return value;
            } else if (type.equals("class java.lang.Float")) {
                //Float类型
                if (value == null) {
                    value = 0.0f;
                }
                return value;
            } else if (type.equals("class java.util.Date")) {
                //Date类型
                if (value == null) {
                    value = new Date();
                }
                return value;
            }
        } catch (Exception exception) {
            System.out.println("--------------------------------------获取属性值失败，失败原因：" + exception.getMessage());
        }
        return value;
    }

    /**
     * 给对象每个属性赋初值
     * 注意：不要求对象的每个属性都为null，也可以给为属性值为null的属性赋初值。
     *
     * @param object
     */
    private void setFieldDefultValue(Object object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                Object value = field.get(object);
                if (value == null) {
                    // 获取属性的类型
                    String type = field.getGenericType().toString();
                    if (type.equals("class java.lang.String")) {
                        //String类型
                        field.set(object, "");
                        continue;
                    } else if (type.equals("class java.lang.Character")) {
                        //Character类型
                        field.set(object, '-');
                        continue;
                    } else if (type.equals("class java.lang.Integer")) {
                        //Integer类型
                        field.set(object, 0);
                        continue;
                    } else if (type.equals("class java.lang.Short")) {
                        //Short类型
                        field.set(object, 0);
                        continue;
                    } else if (type.equals("class java.lang.Long")) {
                        //Long类型
                        field.set(object, 0L);
                        continue;
                    } else if (type.equals("class java.lang.Double")) {
                        //Double类型
                        field.set(object, 0.0d);
                        continue;
                    } else if (type.equals("class java.lang.float")) {
                        //float类型
                        field.set(object, 0.0f);
                        continue;
                    } else if (type.equals("class java.lang.Boolean")) {
                        //布尔类型
                        field.set(object, false);
                        continue;
                    } else if (type.equals("class java.util.Date")) {
                        //date时间类型
                        field.set(object, new Date());
                        continue;
                    } else if (type.equals("class java.math.BigDecimal")) {
                        //BigDecimal类型
                        field.set(object, "");
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------设置对象初值出错，错误信息：" + e.getMessage());
        }
    }
}
