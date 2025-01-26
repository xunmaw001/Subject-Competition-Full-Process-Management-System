package com.dao;

import com.entity.GuizetongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuizetongzhiVO;
import com.entity.view.GuizetongzhiView;


/**
 * 规则通知
 * 
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface GuizetongzhiDao extends BaseMapper<GuizetongzhiEntity> {
	
	List<GuizetongzhiVO> selectListVO(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
	
	GuizetongzhiVO selectVO(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
	
	List<GuizetongzhiView> selectListView(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);

	List<GuizetongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
	
	GuizetongzhiView selectView(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
	

}
