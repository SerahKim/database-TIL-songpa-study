package com.chapter01_connection_config.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

    @Select("SELECT CURDATE() FROM DUAL")
    java.util.Date selectSysDate();
}
