package com.htht.common.util;

import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: debbo_piesat_sg
 * @description: 对象工具类
 * @author: Zhao Lianlian
 * @create: 2021-04-29 09:23
 */
public class BeanUtil
{
    static {
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new DateConverter(null), java.sql.Date.class);
    }

    /**
     * Map对象封装到Bean内
     * toBean:(这里用一句话描述这个方法的作用). <br/>
     * @author zll
     * @param map
     * @param clazz
     * @return
     * @since JDK 1.8
     */
    public static <T> T toBean(Map map, Class<T> clazz)
    {
        try
        {
            /*
             * 1. 创建指定类型的javabean对象
             */
            T bean = clazz.newInstance();
            /*
             * 2. 把数据封装到javabean中
             */
            BeanUtils.populate(bean, map);
            /*
             * 返回javabean对象
             */
            return bean;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * bean转为Map
     * toMap:(这里用一句话描述这个方法的作用). <br/>
     * @author zll
     * @param bean
     * @return
     * @since JDK 1.8
     */
    public static Map toMap(Object bean)
    {
        try
        {
            Map map = BeanUtils.describe(bean);
            return map;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public static List<Map<String,Object>> toList(List<? extends Object> beans)
    {
        try
        {
            List<Map<String,Object>> retList= Lists.newArrayList();
            for(Object obj:beans)
            {
                Map map = BeanUtils.describe(obj);
                retList.add(map);
            }
            return retList;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public static <E> List<E> arraytoList(E[] array)
    {
        List<E> list=new ArrayList<E>();
        for(E element:array)
        {
            list.add(element);
        }
        return list;
    }
    /**
     * bean之间的属性拷贝
     * @param destBean 被拷贝的bean
     * @param orgBean 源bean
     */
    public static void copyProperties(Object destBean,Object orgBean)
    {
        try
        {
            BeanUtils.copyProperties(destBean, orgBean);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
