package com.luoyu.dynamicmultipledatasources.config;

import com.luoyu.dynamicmultipledatasources.enums.DataSourceType;

/**
 * @author quange
 */
public class DataSourceContextHolder {

    /**
     * 使用ThreadLocal保证线程安全
     */
    private static final ThreadLocal<DataSourceType> TYPE = new ThreadLocal<>();

    /**
     * 获取数据源
     */
    public static DataSourceType getDataSourceType() {
        return TYPE.get() == null ? DataSourceType.DB1 : TYPE.get();
    }

    /**
     * 往当前线程里设置数据源
     */
    public static void setDataSourceType(DataSourceType dataSourceType) {
        if (dataSourceType == null) {
            throw new NullPointerException();
        }
        TYPE.set(dataSourceType);
    }

    /**
     * 清空数据源
     */
    public static void clearDataSourceType() {
        TYPE.remove();
    }

}
