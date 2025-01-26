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

import com.entity.JingsaichengjiEntity;
import com.entity.view.JingsaichengjiView;

import com.service.JingsaichengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 竞赛成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@RestController
@RequestMapping("/jingsaichengji")
public class JingsaichengjiController {
    @Autowired
    private JingsaichengjiService jingsaichengjiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaichengjiEntity jingsaichengji, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jingsaichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			jingsaichengji.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();


		PageUtils page = jingsaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaichengji), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaichengjiEntity jingsaichengji, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jingsaichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			jingsaichengji.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();

		PageUtils page = jingsaichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaichengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaichengjiEntity jingsaichengji){
       	EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaichengji, "jingsaichengji")); 
        return R.ok().put("data", jingsaichengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaichengjiEntity jingsaichengji){
        EntityWrapper< JingsaichengjiEntity> ew = new EntityWrapper< JingsaichengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaichengji, "jingsaichengji")); 
		JingsaichengjiView jingsaichengjiView =  jingsaichengjiService.selectView(ew);
		return R.ok("查询竞赛成绩成功").put("data", jingsaichengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaichengjiEntity jingsaichengji = jingsaichengjiService.selectById(id);
        return R.ok().put("data", jingsaichengji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaichengjiEntity jingsaichengji = jingsaichengjiService.selectById(id);
        return R.ok().put("data", jingsaichengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
    	jingsaichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaichengji);

        jingsaichengjiService.insert(jingsaichengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
    	jingsaichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaichengji);
    	jingsaichengji.setUserid((Long)request.getSession().getAttribute("userId"));

        jingsaichengjiService.insert(jingsaichengji);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaichengjiEntity jingsaichengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaichengji);
        jingsaichengjiService.updateById(jingsaichengji);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaichengjiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JingsaichengjiEntity> wrapper = new EntityWrapper<JingsaichengjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jingsaichengjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/jingsaichengji/jingsaimingcheng")
	@IgnoreAuth
    public R jingsaimingchengjingsaichengjiSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<JingsaichengjiEntity> ew = new EntityWrapper<JingsaichengjiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jingsaichengjiService.jingsaimingchengjingsaichengjiSectionStat(params, ew);
        return R.ok().put("data", result);
    }




}
