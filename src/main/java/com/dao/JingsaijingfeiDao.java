package com.dao;

import com.entity.JingsaijingfeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingsaijingfeiVO;
import com.entity.view.JingsaijingfeiView;


/**
 * 竞赛经费
 * 
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface JingsaijingfeiDao extends BaseMapper<JingsaijingfeiEntity> {
	
	List<JingsaijingfeiVO> selectListVO(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
	
	JingsaijingfeiVO selectVO(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
	
	List<JingsaijingfeiView> selectListView(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);

	List<JingsaijingfeiView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
	
	JingsaijingfeiView selectView(@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingsaijingfeiEntity> wrapper);



}
