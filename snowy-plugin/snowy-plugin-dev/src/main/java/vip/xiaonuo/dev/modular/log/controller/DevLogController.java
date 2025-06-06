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
package vip.xiaonuo.dev.modular.log.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.dev.modular.log.entity.DevLog;
import vip.xiaonuo.dev.modular.log.param.DevLogDeleteParam;
import vip.xiaonuo.dev.modular.log.param.DevLogPageParam;
import vip.xiaonuo.dev.modular.log.result.DevLogOpBarChartDataResult;
import vip.xiaonuo.dev.modular.log.result.DevLogOpPieChartDataResult;
import vip.xiaonuo.dev.modular.log.result.DevLogVisLineChartDataResult;
import vip.xiaonuo.dev.modular.log.result.DevLogVisPieChartDataResult;
import vip.xiaonuo.dev.modular.log.service.DevLogService;

import java.util.List;

/**
 * 日志控制器
 *
 * @author xuyuxiang
 * @date 2022/9/2 15:15
 */
@Api(tags = "日志控制器")
@Controller
@Valid
public class DevLogController {

    @Inject
    private DevLogService devLogService;

    /**
     * 获取日志分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取日志分页")
    @Get
    @Mapping("/dev/log/page")
    public CommonResult<Page<DevLog>> page(DevLogPageParam devLogPageParam) {
        return CommonResult.data(devLogService.page(devLogPageParam));
    }

    /**
     * 获取日志分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取日志详情")
    @Get
    @Mapping("/dev/log/detail")
    public CommonResult<DevLog> detail(Long id) {
        return CommonResult.data(devLogService.getById(id));
    }


    /**
     * 清空日志
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("清空日志")
    @CommonLog("清空日志")
    @Post
    @Mapping("/dev/log/delete")
    public CommonResult<String> delete(DevLogDeleteParam devLogDeleteParam) {
        devLogService.delete(devLogDeleteParam);
        return CommonResult.ok();
    }

    /**
     * 获取访问日志折线图数据
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取访问日志折线图数据")
    @Get
    @Mapping("/dev/log/vis/lineChartData")
    public CommonResult<List<DevLogVisLineChartDataResult>> visLogLineChartData() {
        return CommonResult.data(devLogService.visLogLineChartData());
    }

    /**
     * 获取访问日志饼状图数据
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取访问日志饼状图数据")
    @Get
    @Mapping("/dev/log/vis/pieChartData")
    public CommonResult<List<DevLogVisPieChartDataResult>> visLogPieChartData() {
        return CommonResult.data(devLogService.visLogPieChartData());
    }

    /**
     * 获取操作日志柱状图数据
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取操作日志柱状图数据")
    @Get
    @Mapping("/dev/log/op/barChartData")
    public CommonResult<List<DevLogOpBarChartDataResult>> opLogBarChartData() {
        return CommonResult.data(devLogService.opLogBarChartData());
    }

    /**
     * 获取操作日志饼状图数据
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取操作日志饼状图数据")
    @Get
    @Mapping("/dev/log/op/pieChartData")
    public CommonResult<List<DevLogOpPieChartDataResult>> opLogPieChartData() {
        return CommonResult.data(devLogService.opLogPieChartData());
    }
}
