package com.dao;

import com.entity.HuojiangzhanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuojiangzhanshiVO;
import com.entity.view.HuojiangzhanshiView;


/**
 * 获奖展示
 * 
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface HuojiangzhanshiDao extends BaseMapper<HuojiangzhanshiEntity> {
	
	List<HuojiangzhanshiVO> selectListVO(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
	
	HuojiangzhanshiVO selectVO(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
	
	List<HuojiangzhanshiView> selectListView(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);

	List<HuojiangzhanshiView> selectListView(Pagination page,@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
	
	HuojiangzhanshiView selectView(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
	

}
