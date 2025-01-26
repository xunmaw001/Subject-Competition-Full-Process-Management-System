package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HuojiangzhanshiEntity;
import com.entity.view.HuojiangzhanshiView;

import com.service.HuojiangzhanshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 获奖展示
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@RestController
@RequestMapping("/huojiangzhanshi")
public class HuojiangzhanshiController {
    @Autowired
    private HuojiangzhanshiService huojiangzhanshiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuojiangzhanshiEntity huojiangzhanshi, 
		HttpServletRequest request){

        EntityWrapper<HuojiangzhanshiEntity> ew = new EntityWrapper<HuojiangzhanshiEntity>();


		PageUtils page = huojiangzhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huojiangzhanshi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuojiangzhanshiEntity huojiangzhanshi, 
		HttpServletRequest request){
        EntityWrapper<HuojiangzhanshiEntity> ew = new EntityWrapper<HuojiangzhanshiEntity>();

		PageUtils page = huojiangzhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huojiangzhanshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuojiangzhanshiEntity huojiangzhanshi){
       	EntityWrapper<HuojiangzhanshiEntity> ew = new EntityWrapper<HuojiangzhanshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huojiangzhanshi, "huojiangzhanshi")); 
        return R.ok().put("data", huojiangzhanshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuojiangzhanshiEntity huojiangzhanshi){
        EntityWrapper< HuojiangzhanshiEntity> ew = new EntityWrapper< HuojiangzhanshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huojiangzhanshi, "huojiangzhanshi")); 
		HuojiangzhanshiView huojiangzhanshiView =  huojiangzhanshiService.selectView(ew);
		return R.ok("查询获奖展示成功").put("data", huojiangzhanshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuojiangzhanshiEntity huojiangzhanshi = huojiangzhanshiService.selectById(id);
        return R.ok().put("data", huojiangzhanshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuojiangzhanshiEntity huojiangzhanshi = huojiangzhanshiService.selectById(id);
        return R.ok().put("data", huojiangzhanshi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        HuojiangzhanshiEntity huojiangzhanshi = huojiangzhanshiService.selectById(id);
        if(type.equals("1")) {
        	huojiangzhanshi.setThumbsupnum(huojiangzhanshi.getThumbsupnum()+1);
        } else {
        	huojiangzhanshi.setCrazilynum(huojiangzhanshi.getCrazilynum()+1);
        }
        huojiangzhanshiService.updateById(huojiangzhanshi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuojiangzhanshiEntity huojiangzhanshi, HttpServletRequest request){
    	huojiangzhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huojiangzhanshi);

        huojiangzhanshiService.insert(huojiangzhanshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuojiangzhanshiEntity huojiangzhanshi, HttpServletRequest request){
    	huojiangzhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huojiangzhanshi);

        huojiangzhanshiService.insert(huojiangzhanshi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuojiangzhanshiEntity huojiangzhanshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huojiangzhanshi);
        huojiangzhanshiService.updateById(huojiangzhanshi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huojiangzhanshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<HuojiangzhanshiEntity> wrapper = new EntityWrapper<HuojiangzhanshiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = huojiangzhanshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
