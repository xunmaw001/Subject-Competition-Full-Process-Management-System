package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GuizetongzhiDao;
import com.entity.GuizetongzhiEntity;
import com.service.GuizetongzhiService;
import com.entity.vo.GuizetongzhiVO;
import com.entity.view.GuizetongzhiView;

@Service("guizetongzhiService")
public class GuizetongzhiServiceImpl extends ServiceImpl<GuizetongzhiDao, GuizetongzhiEntity> implements GuizetongzhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuizetongzhiEntity> page = this.selectPage(
                new Query<GuizetongzhiEntity>(params).getPage(),
                new EntityWrapper<GuizetongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuizetongzhiEntity> wrapper) {
		  Page<GuizetongzhiView> page =new Query<GuizetongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuizetongzhiVO> selectListVO(Wrapper<GuizetongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuizetongzhiVO selectVO(Wrapper<GuizetongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuizetongzhiView> selectListView(Wrapper<GuizetongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuizetongzhiView selectView(Wrapper<GuizetongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
