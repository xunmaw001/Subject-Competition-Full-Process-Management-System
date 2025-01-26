package com.entity.view;

import com.entity.DiscusshuojiangzhanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 获奖展示评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@TableName("discusshuojiangzhanshi")
public class DiscusshuojiangzhanshiView  extends DiscusshuojiangzhanshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshuojiangzhanshiView(){
	}
 
 	public DiscusshuojiangzhanshiView(DiscusshuojiangzhanshiEntity discusshuojiangzhanshiEntity){
 	try {
			BeanUtils.copyProperties(this, discusshuojiangzhanshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
