package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingsaijingfeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingsaijingfeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingsaijingfeiView;


/**
 * 竞赛经费
 *
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface JingsaijingfeiService extends IService<JingsaijingfeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaijingfeiVO> selectListVO(Wrapper<JingsaijingfeiEntity> wrapper);
   	
   	JingsaijingfeiVO selectVO(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
   	
   	List<JingsaijingfeiView> selectListView(Wrapper<JingsaijingfeiEntity> wrapper);
   	
   	JingsaijingfeiView selectView(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaijingfeiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JingsaijingfeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JingsaijingfeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JingsaijingfeiEntity> wrapper);



}

