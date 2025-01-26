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


import com.dao.DiscusshuojiangzhanshiDao;
import com.entity.DiscusshuojiangzhanshiEntity;
import com.service.DiscusshuojiangzhanshiService;
import com.entity.vo.DiscusshuojiangzhanshiVO;
import com.entity.view.DiscusshuojiangzhanshiView;

@Service("discusshuojiangzhanshiService")
public class DiscusshuojiangzhanshiServiceImpl extends ServiceImpl<DiscusshuojiangzhanshiDao, DiscusshuojiangzhanshiEntity> implements DiscusshuojiangzhanshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshuojiangzhanshiEntity> page = this.selectPage(
                new Query<DiscusshuojiangzhanshiEntity>(params).getPage(),
                new EntityWrapper<DiscusshuojiangzhanshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshuojiangzhanshiEntity> wrapper) {
		  Page<DiscusshuojiangzhanshiView> page =new Query<DiscusshuojiangzhanshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshuojiangzhanshiVO> selectListVO(Wrapper<DiscusshuojiangzhanshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshuojiangzhanshiVO selectVO(Wrapper<DiscusshuojiangzhanshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshuojiangzhanshiView> selectListView(Wrapper<DiscusshuojiangzhanshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshuojiangzhanshiView selectView(Wrapper<DiscusshuojiangzhanshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
