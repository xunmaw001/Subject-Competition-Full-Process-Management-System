package com.entity.model;

import com.entity.JingsaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 竞赛信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
public class JingsaixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
