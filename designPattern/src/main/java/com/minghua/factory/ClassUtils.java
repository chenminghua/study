/**
 * @文件名称:ClassUtils.java
 * @文件路径:com.chen.factory
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-10-14下午2:23:24
 * @版本:V1.0
 */
package com.minghua.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class ClassUtils {
	public static List<Class> getAllClassByInterface(Class c){
		List<Class> returnClassList = new ArrayList();
		//如果不是一个借口，则不作处理
		if(c.isInterface()){
			String packageName = c.getPackage().getName();
			List<Class> allClass = getClasses(packageName);//获取当前包下一集子包下的所有类
			
		}
		return null;		
	}
	//在一个包中查找出所有的类
	private static List<Class> getClasses(String packageName) {
		
		return null;
	}

}
