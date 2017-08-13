package com.yelun.weixin.repo.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yelun.weixin.domain.user.UserRepo;
import com.yelun.weixin.domain.user.WechatUser;
import com.yelun.weixin.domain.user.WechatUserExample;
import com.yelun.weixin.repo.user.WechatUserMapper;
import com.yelun.weixin.utils.MybatisUtil;

/**
 * user模块数据接口实现类
 * @author yelun
 *
 */
@Repository
public class UserRepoImpl implements UserRepo{
	@Autowired WechatUserMapper wechatUserMapper;

	@Override
	public WechatUser getWechatUserByOpenId(String openId) {
		WechatUserExample example = new WechatUserExample();
		example.createCriteria().andOpenidEqualTo(openId);
		WechatUser wechatUser = null;
		try {
			wechatUser = MybatisUtil.selectOne(wechatUserMapper.selectByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wechatUser;
	}

	@Override
	public int saveWechatUser(WechatUser wechatUser) {
		return wechatUserMapper.insert(wechatUser);
	}

	@Override
	public int updateWechatUser(WechatUser wechatUser) {
		return wechatUserMapper.updateByPrimaryKey(wechatUser);
	}

}
