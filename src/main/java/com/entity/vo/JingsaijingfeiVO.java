package com.entity.vo;

import com.entity.JingsaijingfeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 竞赛经费
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public class JingsaijingfeiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
