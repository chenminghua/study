/**
 * @文件名称:WangPo.java
 * @文件路径:com.chen.proxy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午2:59:21
 * @版本:V1.0
 */
package com.minghua.proxy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class WangPo implements KindWoman {

	private KindWoman kindWoman;
	public WangPo(){//默认是小潘的代理
		this.kindWoman = new XiaoPan();
	}
	//王婆这事干多了，虽然没有见到其他的，但是肯定他也能干
	public WangPo(KindWoman kindWoman){
		this.kindWoman = kindWoman;
	}

	@Override
	public void makeEyeWithMan() {
		this.kindWoman.makeEyeWithMan();
	}

	@Override
	public void happyWithMan() {
		this.kindWoman.happyWithMan();
	}

}
