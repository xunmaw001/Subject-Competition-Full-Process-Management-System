package com.dao;

import com.entity.DiscusshuojiangzhanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuojiangzhanshiVO;
import com.entity.view.DiscusshuojiangzhanshiView;


/**
 * 获奖展示评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface DiscusshuojiangzhanshiDao extends BaseMapper<DiscusshuojiangzhanshiEntity> {
	
	List<DiscusshuojiangzhanshiVO> selectListVO(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
	
	DiscusshuojiangzhanshiVO selectVO(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
	
	List<DiscusshuojiangzhanshiView> selectListView(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);

	List<DiscusshuojiangzhanshiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
	
	DiscusshuojiangzhanshiView selectView(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
	

}
