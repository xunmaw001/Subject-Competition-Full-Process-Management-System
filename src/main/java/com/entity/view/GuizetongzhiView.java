package com.entity.view;

import com.entity.GuizetongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 规则通知
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 22:26:49
 */
@TableName("guizetongzhi")
public class GuizetongzhiView  extends GuizetongzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuizetongzhiView(){
	}
 
 	public GuizetongzhiView(GuizetongzhiEntity guizetongzhiEntity){
 	try {
			BeanUtils.copyProperties(this, guizetongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
