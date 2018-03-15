/**
 * @文件名称:HumanFactory.java
 * @文件路径:com.chen.factory
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-27下午5:28:00
 * @版本:V1.0
 */
package com.minghua.factory;
import com.minghua.factory.Human;

import java.util.List;

/**
* @author cbf4Life cbf4life@126.com
* I'm glad to share my knowledge with you all.
* 今天讲女娲造人的故事，这个故事梗概是这样的：
* 很久很久以前，盘古开辟了天地，用身躯造出日月星辰、山川草木，天地一片繁华
* One day，女娲下界走了一遭，哎！太寂寞，太孤独了，没个会笑的、会哭的、会说话的东东
* 那怎么办呢？不用愁，女娲，神仙呀，造出来呀，然后捏泥巴，放八卦炉（后来这个成了太白金星的宝
贝）中烤，于是就有了人：
* 我们把这个生产人的过程用Java程序表现出来：
*/
public class HumanFactory {
	//工厂里有烤箱，泥巴塞进去，人出来
	public static Human createHuman(Class c){
		Human human = null;
		try {
			human = (Human)Class.forName(c.getName()).newInstance();
		} catch (InstantiationException e) {//你要是不说个人种颜色的话，没法烤，要白的黑，你说话了才好烤
			System.out.println("必须指定人种的颜色");
		} catch (IllegalAccessException e) {//定义的人种有问题，那就烤不出来了，这是...
			System.out.println("人种定义错误！");
		} catch (ClassNotFoundException e) {//你随便说个人种，我到哪里给你制造去？！
			System.out.println("混蛋，你指定的人种找不到！");
		}
		return human;
	}
	//女娲生气了，这样效率太低了，随便啊，爱怎么着怎么着
	public static Human createHuman(){
		Human human = null;
		List<Class> concreateHumanList = ClassUtils.getAllClassByInterface(Human.class); 
		return human;
	}

}
