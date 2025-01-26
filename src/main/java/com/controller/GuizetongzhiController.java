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

import com.entity.GuizetongzhiEntity;
import com.entity.view.GuizetongzhiView;

import com.service.GuizetongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 规则通知
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@RestController
@RequestMapping("/guizetongzhi")
public class GuizetongzhiController {
    @Autowired
    private GuizetongzhiService guizetongzhiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuizetongzhiEntity guizetongzhi, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		guizetongzhi.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<GuizetongzhiEntity> ew = new EntityWrapper<GuizetongzhiEntity>();


		PageUtils page = guizetongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guizetongzhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuizetongzhiEntity guizetongzhi, 
		HttpServletRequest request){
        EntityWrapper<GuizetongzhiEntity> ew = new EntityWrapper<GuizetongzhiEntity>();

		PageUtils page = guizetongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guizetongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuizetongzhiEntity guizetongzhi){
       	EntityWrapper<GuizetongzhiEntity> ew = new EntityWrapper<GuizetongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guizetongzhi, "guizetongzhi")); 
        return R.ok().put("data", guizetongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuizetongzhiEntity guizetongzhi){
        EntityWrapper< GuizetongzhiEntity> ew = new EntityWrapper< GuizetongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guizetongzhi, "guizetongzhi")); 
		GuizetongzhiView guizetongzhiView =  guizetongzhiService.selectView(ew);
		return R.ok("查询规则通知成功").put("data", guizetongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuizetongzhiEntity guizetongzhi = guizetongzhiService.selectById(id);
        return R.ok().put("data", guizetongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuizetongzhiEntity guizetongzhi = guizetongzhiService.selectById(id);
        return R.ok().put("data", guizetongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuizetongzhiEntity guizetongzhi, HttpServletRequest request){
    	guizetongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guizetongzhi);
    	guizetongzhi.setUserid((Long)request.getSession().getAttribute("userId"));

        guizetongzhiService.insert(guizetongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuizetongzhiEntity guizetongzhi, HttpServletRequest request){
    	guizetongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guizetongzhi);

        guizetongzhiService.insert(guizetongzhi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuizetongzhiEntity guizetongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guizetongzhi);
        guizetongzhiService.updateById(guizetongzhi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guizetongzhiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GuizetongzhiEntity> wrapper = new EntityWrapper<GuizetongzhiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = guizetongzhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
