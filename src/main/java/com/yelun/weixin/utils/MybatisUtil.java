package com.yelun.weixin.utils;

import java.util.List;

import com.yelun.weixin.utils.exception.ErrorCode;

public class MybatisUtil {
	
	public static <T> T selectOne(List<T> list) throws Exception{
		if (list.size() == 1){
			return list.get(0);
		} else if (list.size() == 0){
			return null;
		} else {
			throw new Exception(ErrorCode.SQL_SELECT_ERROR.description() + "except 1 but found " + list.size());
		}
	}
	
}
