package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuizetongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuizetongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuizetongzhiView;


/**
 * 规则通知
 *
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface GuizetongzhiService extends IService<GuizetongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuizetongzhiVO> selectListVO(Wrapper<GuizetongzhiEntity> wrapper);
   	
   	GuizetongzhiVO selectVO(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
   	
   	List<GuizetongzhiView> selectListView(Wrapper<GuizetongzhiEntity> wrapper);
   	
   	GuizetongzhiView selectView(@Param("ew") Wrapper<GuizetongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuizetongzhiEntity> wrapper);
   	

}

