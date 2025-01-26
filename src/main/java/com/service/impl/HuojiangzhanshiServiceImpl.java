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


import com.dao.HuojiangzhanshiDao;
import com.entity.HuojiangzhanshiEntity;
import com.service.HuojiangzhanshiService;
import com.entity.vo.HuojiangzhanshiVO;
import com.entity.view.HuojiangzhanshiView;

@Service("huojiangzhanshiService")
public class HuojiangzhanshiServiceImpl extends ServiceImpl<HuojiangzhanshiDao, HuojiangzhanshiEntity> implements HuojiangzhanshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuojiangzhanshiEntity> page = this.selectPage(
                new Query<HuojiangzhanshiEntity>(params).getPage(),
                new EntityWrapper<HuojiangzhanshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuojiangzhanshiEntity> wrapper) {
		  Page<HuojiangzhanshiView> page =new Query<HuojiangzhanshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuojiangzhanshiVO> selectListVO(Wrapper<HuojiangzhanshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuojiangzhanshiVO selectVO(Wrapper<HuojiangzhanshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuojiangzhanshiView> selectListView(Wrapper<HuojiangzhanshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuojiangzhanshiView selectView(Wrapper<HuojiangzhanshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
