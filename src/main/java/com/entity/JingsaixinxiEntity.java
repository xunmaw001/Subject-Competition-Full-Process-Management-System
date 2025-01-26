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
 * 竞赛信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@TableName("jingsaixinxi")
public class JingsaixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JingsaixinxiEntity() {
		
	}
	
	public JingsaixinxiEntity(T t) {
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
	 * 竞赛类型
	 */
					
	private String jingsaileixing;
	
	/**
	 * 竞赛图片
	 */
					
	private String jingsaitupian;
	
	/**
	 * 竞赛规则
	 */
					
	private String jingsaiguize;
	
	/**
	 * 竞赛人数
	 */
					
	private Integer jingsairenshu;
	
	/**
	 * 竞赛时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jingsaishijian;
	
	/**
	 * 竞赛地点
	 */
					
	private String jingsaididian;
	
	/**
	 * 竞赛介绍
	 */
					
	private String jingsaijieshao;
	
	/**
	 * 倒计结束时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date reversetime;
	
	
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
	 * 设置：竞赛图片
	 */
	public void setJingsaitupian(String jingsaitupian) {
		this.jingsaitupian = jingsaitupian;
	}
	/**
	 * 获取：竞赛图片
	 */
	public String getJingsaitupian() {
		return jingsaitupian;
	}
	/**
	 * 设置：竞赛规则
	 */
	public void setJingsaiguize(String jingsaiguize) {
		this.jingsaiguize = jingsaiguize;
	}
	/**
	 * 获取：竞赛规则
	 */
	public String getJingsaiguize() {
		return jingsaiguize;
	}
	/**
	 * 设置：竞赛人数
	 */
	public void setJingsairenshu(Integer jingsairenshu) {
		this.jingsairenshu = jingsairenshu;
	}
	/**
	 * 获取：竞赛人数
	 */
	public Integer getJingsairenshu() {
		return jingsairenshu;
	}
	/**
	 * 设置：竞赛时间
	 */
	public void setJingsaishijian(Date jingsaishijian) {
		this.jingsaishijian = jingsaishijian;
	}
	/**
	 * 获取：竞赛时间
	 */
	public Date getJingsaishijian() {
		return jingsaishijian;
	}
	/**
	 * 设置：竞赛地点
	 */
	public void setJingsaididian(String jingsaididian) {
		this.jingsaididian = jingsaididian;
	}
	/**
	 * 获取：竞赛地点
	 */
	public String getJingsaididian() {
		return jingsaididian;
	}
	/**
	 * 设置：竞赛介绍
	 */
	public void setJingsaijieshao(String jingsaijieshao) {
		this.jingsaijieshao = jingsaijieshao;
	}
	/**
	 * 获取：竞赛介绍
	 */
	public String getJingsaijieshao() {
		return jingsaijieshao;
	}
	/**
	 * 设置：倒计结束时间
	 */
	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}
	/**
	 * 获取：倒计结束时间
	 */
	public Date getReversetime() {
		return reversetime;
	}

}
