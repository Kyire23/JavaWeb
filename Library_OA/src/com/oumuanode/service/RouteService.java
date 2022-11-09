package com.oumuanode.service;


import com.oumuanode.domain.PageBean;
import com.oumuanode.domain.User;

import java.util.Map;

public interface RouteService {
    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param condition
     * @return
     */
    PageBean<User> pageQuery(int currentPage, int pageSize, Map<String, String[]> condition);
}
