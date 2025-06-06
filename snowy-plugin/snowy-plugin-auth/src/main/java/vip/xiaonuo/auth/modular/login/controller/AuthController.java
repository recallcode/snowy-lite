/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package vip.xiaonuo.auth.modular.login.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import vip.xiaonuo.auth.core.enums.SaClientTypeEnum;
import vip.xiaonuo.auth.core.pojo.SaBaseLoginUser;
import vip.xiaonuo.auth.modular.login.param.AuthAccountPasswordLoginParam;
import vip.xiaonuo.auth.modular.login.param.AuthGetPhoneValidCodeParam;
import vip.xiaonuo.auth.modular.login.param.AuthPhoneValidCodeLoginParam;
import vip.xiaonuo.auth.modular.login.result.AuthPicValidCodeResult;
import vip.xiaonuo.auth.modular.login.service.AuthService;
import vip.xiaonuo.common.pojo.CommonResult;

/**
 * B端登录控制器
 *
 * @author xuyuxiang
 * @date 2021/12/23 21:50
 */
@Api(tags = "B端登录控制器")
@Controller
@Valid
public class AuthController {

    @Inject
    private AuthService authService;

    /**
     * B端获取图片验证码
     *
     * @author xuyuxiang
     * @date 2022/7/8 9:26
     **/
    @ApiOperation("B端获取图片验证码")
    @Get
    @Mapping("/auth/b/getPicCaptcha")
    public CommonResult<AuthPicValidCodeResult> getPicCaptcha() {
        return CommonResult.data(authService.getPicCaptcha(SaClientTypeEnum.B.getValue()));
    }

    /**
     * B端获取手机验证码
     *
     * @author xuyuxiang
     * @date 2022/7/8 9:26
     **/
    @ApiOperation("B端获取手机验证码")
    @Get
    @Mapping("/auth/b/getPhoneValidCode")
    public CommonResult<String> getPhoneValidCode(@Validated AuthGetPhoneValidCodeParam authGetPhoneValidCodeParam) {
        return CommonResult.data(authService.getPhoneValidCode(authGetPhoneValidCodeParam, SaClientTypeEnum.B.getValue()));
    }

    /**
     * B端账号密码登录
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @ApiOperation("B端账号密码登录")
    @Post
    @Mapping("/auth/b/doLogin")
    public CommonResult<String> doLogin(@Validated AuthAccountPasswordLoginParam authAccountPasswordLoginParam) {
        return CommonResult.data(authService.doLogin(authAccountPasswordLoginParam, SaClientTypeEnum.B.getValue()));
    }

    /**
     * B端手机验证码登录
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @ApiOperation("B端手机验证码登录")
    @Post
    @Mapping("/auth/b/doLoginByPhone")
    public CommonResult<String> doLoginByPhone(@Validated AuthPhoneValidCodeLoginParam authPhoneValidCodeLoginParam) {
        return CommonResult.data(authService.doLoginByPhone(authPhoneValidCodeLoginParam, SaClientTypeEnum.B.getValue()));
    }

    /**
     * B端退出
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @ApiOperation("B端退出")
    @SaCheckLogin
    @Get
    @Mapping("/auth/b/doLogout")
    public CommonResult<String> doLogout() {
        StpUtil.logout();
        return CommonResult.ok();
    }

    /**
     * B端获取用户信息
     *
     * @author xuyuxiang
     * @date 2021/10/15 13:12
     **/
    @ApiOperation("B端获取用户信息")
    @SaCheckLogin
    @Get
    @Mapping("/auth/b/getLoginUser")
    public CommonResult<SaBaseLoginUser> getLoginUser() {
        return CommonResult.data(authService.getLoginUser());
    }
}
