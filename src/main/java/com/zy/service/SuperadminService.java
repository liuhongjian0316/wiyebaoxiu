package com.zy.service;

import com.zy.entity.Superadmin;
import java.util.List;
import java.util.Map;

/**
 * (Superadmin)表服务接口
 *
 * @author makejava
 * @since 2020-11-14 13:26:01
 */
public interface SuperadminService {

    /**
     * 管理员
     * @param username
     * @param pwd
     * @return
     */
    public Map<String,Object> login(String username ,String pwd);

}