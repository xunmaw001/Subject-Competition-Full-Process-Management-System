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
 * 竞赛经费
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@TableName("jingsaijingfei")
public class JingsaijingfeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JingsaijingfeiEntity() {
		
	}
	
	public JingsaijingfeiEntity(T t) {
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
	 * 参与人数
	 */
					
	private String canyurenshu;
	
	/**
	 * 竞赛经费
	 */
					
	private Float jingsaijingfei;
	
	/**
	 * 经费详情
	 */
					
	private String jingfeixiangqing;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	
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
	 * 设置：参与人数
	 */
	public void setCanyurenshu(String canyurenshu) {
		this.canyurenshu = canyurenshu;
	}
	/**
	 * 获取：参与人数
	 */
	public String getCanyurenshu() {
		return canyurenshu;
	}
	/**
	 * 设置：竞赛经费
	 */
	public void setJingsaijingfei(Float jingsaijingfei) {
		this.jingsaijingfei = jingsaijingfei;
	}
	/**
	 * 获取：竞赛经费
	 */
	public Float getJingsaijingfei() {
		return jingsaijingfei;
	}
	/**
	 * 设置：经费详情
	 */
	public void setJingfeixiangqing(String jingfeixiangqing) {
		this.jingfeixiangqing = jingfeixiangqing;
	}
	/**
	 * 获取：经费详情
	 */
	public String getJingfeixiangqing() {
		return jingfeixiangqing;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}

}
