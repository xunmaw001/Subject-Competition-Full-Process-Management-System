package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuojiangzhanshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuojiangzhanshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuojiangzhanshiView;


/**
 * 获奖展示评论表
 *
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface DiscusshuojiangzhanshiService extends IService<DiscusshuojiangzhanshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuojiangzhanshiVO> selectListVO(Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
   	
   	DiscusshuojiangzhanshiVO selectVO(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
   	
   	List<DiscusshuojiangzhanshiView> selectListView(Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
   	
   	DiscusshuojiangzhanshiView selectView(@Param("ew") Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuojiangzhanshiEntity> wrapper);
   	

}

