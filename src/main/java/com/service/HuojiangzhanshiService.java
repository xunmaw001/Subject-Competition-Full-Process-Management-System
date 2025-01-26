package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuojiangzhanshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuojiangzhanshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuojiangzhanshiView;


/**
 * 获奖展示
 *
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public interface HuojiangzhanshiService extends IService<HuojiangzhanshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuojiangzhanshiVO> selectListVO(Wrapper<HuojiangzhanshiEntity> wrapper);
   	
   	HuojiangzhanshiVO selectVO(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
   	
   	List<HuojiangzhanshiView> selectListView(Wrapper<HuojiangzhanshiEntity> wrapper);
   	
   	HuojiangzhanshiView selectView(@Param("ew") Wrapper<HuojiangzhanshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuojiangzhanshiEntity> wrapper);
   	

}

