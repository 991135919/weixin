package com.yelun.weixin.domain.user;

/**
 * user 模块数据接口
 * @author yelun
 *
 */
public interface UserRepo {
	
	/**
	 * openID 查询用户
	 * @param openId
	 * @return
	 */
	WechatUser getWechatUserByOpenId(String openId);
	
	/**
	 * 保存用户信息
	 * @param wechatUser
	 * @return
	 */
	int saveWechatUser(WechatUser wechatUser);
	
	/**
	 * 更新用户信息
	 * @param wechatUser
	 * @return
	 */
	int updateWechatUser(WechatUser wechatUser);
	
}
