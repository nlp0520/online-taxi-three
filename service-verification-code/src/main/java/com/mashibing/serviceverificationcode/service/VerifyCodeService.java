package com.mashibing.serviceverificationcode.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;

/**
 * @Auther:niulipeng
 * @Date:2021/11/7
 * @Description:com.mashibing.serviceverificationcode.service.impl
 * @Version:1.0
 */
public interface VerifyCodeService {
    public ResponseResult<VerifyCodeResponse> generate(int identity , String phoneNumber);
}
