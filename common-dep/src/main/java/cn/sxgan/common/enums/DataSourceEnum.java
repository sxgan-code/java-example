package cn.sxgan.common.enums;

/**
 * @Description: 数据源枚举类
 * @Author: sxgan
 * @Date: 2024-05-18 12:36
 * @Version: 1.0
 **/

public enum DataSourceEnum {
    
    MOCK_DB("mock-db"),
    
    MOCK_DB_BACKUP("mock-db-backup");
    
    private String value;
    
    DataSourceEnum(String value){
        this.value = value;
    }
}
