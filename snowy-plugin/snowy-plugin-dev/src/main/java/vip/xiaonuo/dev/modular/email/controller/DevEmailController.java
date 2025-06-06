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
package vip.xiaonuo.dev.modular.email.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.common.pojo.CommonValidList;
import vip.xiaonuo.dev.modular.email.entity.DevEmail;
import vip.xiaonuo.dev.modular.email.param.*;
import vip.xiaonuo.dev.modular.email.service.DevEmailService;

/**
 * 邮件控制器
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:26
 **/
@Api(tags = "邮件控制器")
@Controller
@Valid
public class DevEmailController {

    @Inject
    private DevEmailService devEmailService;

    /**
     * 发送邮件——本地TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送本地文本邮件")
    @CommonLog("发送本地文本邮件")
    @Post
    @Mapping("/dev/email/sendLocalTxt")
    public CommonResult<String> sendLocal(@Validated DevEmailSendLocalTxtParam devEmailSendLocalTxtParam) {
        devEmailService.sendLocal(devEmailSendLocalTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——本地HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送本地HTML邮件")
    @CommonLog("发送本地HTML邮件")
    @Post
    @Mapping("/dev/email/sendLocalHtml")
    public CommonResult<String> sendLocal(@Validated DevEmailSendLocalHtmlParam devEmailSendLocalHtmlParam) {
        devEmailService.sendLocal(devEmailSendLocalHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送阿里云文本邮件")
    @CommonLog("发送阿里云文本邮件")
    @Post
    @Mapping("/dev/email/sendAliyunTxt")
    public CommonResult<String> sendAliyun(@Validated DevEmailSendAliyunTxtParam devEmailSendAliyunTxtParam) {
        devEmailService.sendAliyun(devEmailSendAliyunTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送阿里云HTML邮件")
    @CommonLog("发送阿里云HTML邮件")
    @Post
    @Mapping("/dev/email/sendAliyunHtml")
    public CommonResult<String> sendAliyun(@Validated DevEmailSendAliyunHtmlParam devEmailSendAliyunHtmlParam) {
        devEmailService.sendAliyun(devEmailSendAliyunHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——阿里云TMP
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送阿里云模板邮件")
    @CommonLog("发送阿里云模板邮件")
    @Post
    @Mapping("/dev/email/sendAliyunTmp")
    public CommonResult<String> sendAliyun(@Validated DevEmailSendAliyunTmpParam devEmailSendAliyunTmpParam) {
        devEmailService.sendAliyun(devEmailSendAliyunTmpParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云TXT
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送腾讯云文本邮件")
    @CommonLog("发送腾讯云文本邮件")
    @Post
    @Mapping("/dev/email/sendTencentTxt")
    public CommonResult<String> sendTencent(@Validated DevEmailSendTencentTxtParam devEmailSendTencentTxtParam) {
        devEmailService.sendTencent(devEmailSendTencentTxtParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云HTML
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送腾讯云HTML邮件")
    @CommonLog("发送腾讯云HTML邮件")
    @Post
    @Mapping("/dev/email/sentTencentHtml")
    public CommonResult<String> sendTencent(@Validated DevEmailSendTencentHtmlParam devEmailSendTencentHtmlParam) {
        devEmailService.sendTencent(devEmailSendTencentHtmlParam);
        return CommonResult.ok();
    }

    /**
     * 发送邮件——腾讯云TMP
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送腾讯云模板邮件")
    @CommonLog("发送腾讯云模板邮件")
    @Post
    @Mapping("/dev/email/sentTencentTmp")
    public CommonResult<String> sendTencent(@Validated DevEmailSendTencentTmpParam devEmailSendTencentTmpParam) {
        devEmailService.sendTencent(devEmailSendTencentTmpParam);
        return CommonResult.ok();
    }

    /**
     * 获取邮件分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取邮件分页")
    @Get
    @Mapping("/dev/email/page")
    public CommonResult<Page<DevEmail>> page(DevEmailPageParam devEmailPageParam) {
        return CommonResult.data(devEmailService.page(devEmailPageParam));
    }

    /**
     * 删除邮件
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除邮件")
    @CommonLog("删除邮件")
    @Post
    @Mapping("/dev/email/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                               CommonValidList<DevEmailIdParam> devEmailIdParamList) {
        devEmailService.delete(devEmailIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取邮件详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取邮件详情")
    @Get
    @Mapping("/dev/email/detail")
    public CommonResult<DevEmail> detail(@Validated DevEmailIdParam devEmailIdParam) {
        return CommonResult.data(devEmailService.detail(devEmailIdParam));
    }
}
