package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 获奖展示
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@TableName("huojiangzhanshi")
public class HuojiangzhanshiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuojiangzhanshiEntity() {
		
	}
	
	public HuojiangzhanshiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 竞赛名称
	 */
					
	private String jingsaimingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 竞赛类型
	 */
					
	private String jingsaileixing;
	
	/**
	 * 竞赛日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jingsairiqi;
	
	/**
	 * 获奖名单
	 */
					
	private String huojiangmingdan;
	
	/**
	 * 获奖展示
	 */
					
	private String huojiangzhanshi;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：竞赛名称
	 */
	public void setJingsaimingcheng(String jingsaimingcheng) {
		this.jingsaimingcheng = jingsaimingcheng;
	}
	/**
	 * 获取：竞赛名称
	 */
	public String getJingsaimingcheng() {
		return jingsaimingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：竞赛类型
	 */
	public void setJingsaileixing(String jingsaileixing) {
		this.jingsaileixing = jingsaileixing;
	}
	/**
	 * 获取：竞赛类型
	 */
	public String getJingsaileixing() {
		return jingsaileixing;
	}
	/**
	 * 设置：竞赛日期
	 */
	public void setJingsairiqi(Date jingsairiqi) {
		this.jingsairiqi = jingsairiqi;
	}
	/**
	 * 获取：竞赛日期
	 */
	public Date getJingsairiqi() {
		return jingsairiqi;
	}
	/**
	 * 设置：获奖名单
	 */
	public void setHuojiangmingdan(String huojiangmingdan) {
		this.huojiangmingdan = huojiangmingdan;
	}
	/**
	 * 获取：获奖名单
	 */
	public String getHuojiangmingdan() {
		return huojiangmingdan;
	}
	/**
	 * 设置：获奖展示
	 */
	public void setHuojiangzhanshi(String huojiangzhanshi) {
		this.huojiangzhanshi = huojiangzhanshi;
	}
	/**
	 * 获取：获奖展示
	 */
	public String getHuojiangzhanshi() {
		return huojiangzhanshi;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
