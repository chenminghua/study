/**
 * @文件名称:XiMen.java
 * @文件路径:com.chen.proxy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午3:04:14
 * @版本:V1.0
 */
package com.minghua.proxy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class XiMen {

	/**
	 *方法功能说明
	 *chen  2013-9-23
	 *@参数：@param args
	 *@return void
	 */
	public static void main(String[] args) {
		//传王婆
		WangPo wangpo = new WangPo();
		//首先，西门庆说我要找金莲，好了，王婆最擅长的
		wangpo.makeEyeWithMan();
		wangpo.happyWithMan();
		//好了，西门跟贾氏也暧昧了
		//还是叫上王婆吧，这种事她不参与怎么行
		JiaShi jiashi = new JiaShi();
		WangPo wangpo1 = new WangPo(jiashi);
		wangpo1.makeEyeWithMan();
		wangpo1.happyWithMan();
	}

}
