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


import com.dao.JingsaijingfeiDao;
import com.entity.JingsaijingfeiEntity;
import com.service.JingsaijingfeiService;
import com.entity.vo.JingsaijingfeiVO;
import com.entity.view.JingsaijingfeiView;

@Service("jingsaijingfeiService")
public class JingsaijingfeiServiceImpl extends ServiceImpl<JingsaijingfeiDao, JingsaijingfeiEntity> implements JingsaijingfeiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingsaijingfeiEntity> page = this.selectPage(
                new Query<JingsaijingfeiEntity>(params).getPage(),
                new EntityWrapper<JingsaijingfeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingsaijingfeiEntity> wrapper) {
		  Page<JingsaijingfeiView> page =new Query<JingsaijingfeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingsaijingfeiVO> selectListVO(Wrapper<JingsaijingfeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingsaijingfeiVO selectVO(Wrapper<JingsaijingfeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingsaijingfeiView> selectListView(Wrapper<JingsaijingfeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingsaijingfeiView selectView(Wrapper<JingsaijingfeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JingsaijingfeiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JingsaijingfeiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JingsaijingfeiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }



}
