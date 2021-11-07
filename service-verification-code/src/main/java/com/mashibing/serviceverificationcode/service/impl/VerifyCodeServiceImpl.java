package com.mashibing.serviceverificationcode.service.impl;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.mashibing.serviceverificationcode.service.VerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * @Auther:niulipeng
 * @Date:2021/11/7
 * @Description:com.mashibing.serviceverificationcode.service.impl
 * @Version:1.0
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        // 校验 三档验证。乌云 安全检测。业务方控制，不能无限制发短信。
        // redis 1分钟发了3次，限制你5分钟不能发。。1小时发了10次，限制24小时内不能发。

        String code = String.valueOf((int)((Math.random()*9+1)*Math.pow(10,5)));

        VerifyCodeResponse data = new VerifyCodeResponse();
        data.setCode(code);
        return ResponseResult.success(data);
    }
}
