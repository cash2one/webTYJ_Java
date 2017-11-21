package com.flf.mapper;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import com.flf.entity.HrPermissions;
import com.flf.entity.TUser;

public interface HrPermissionsMapper {
    int deleteByHrPermissions(Map map);

    int insert(HrPermissions record);

    int insertSelective(HrPermissions record);

    HrPermissions selectByPrimaryKey(String permissionsId);

    int updateByPrimaryKeySelective(HrPermissions record);

    int updateByPrimaryKey(HrPermissions record);
    
    /**
     * 查询功能权限表所有数据
     * @return
     */
    List<HrPermissions> listHrPermissions();
    
    /**
     * 根据用户id获取所有的权限
     * @param user
     * @return
     */
    List<HrPermissions> getHrPermissions(TUser user);
    
    /**
     * 根据条件查询数据
     * zhuqi 2016.03.10
     * @param map
     * @return List<HrPermissions>
     */
    List<HrPermissions> selectByMap(Map map);
}