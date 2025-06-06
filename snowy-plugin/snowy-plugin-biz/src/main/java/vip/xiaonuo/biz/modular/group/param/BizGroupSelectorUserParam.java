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
package vip.xiaonuo.biz.modular.group.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户选择器参数
 *
 * @author chengchuanyao
 * @date 2025/1/6 11:28
 */
@Getter
@Setter
public class BizGroupSelectorUserParam {

    /** 当前页 */
    @ApiModelProperty(value = "当前页码", position = 1)
    private Integer current;

    /** 每页条数 */
    @ApiModelProperty(value = "每页条数", position = 2)
    private Integer size;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 3)
    private String orgId;

    /** 姓名关键词 */
    @ApiModelProperty(value = "姓名关键词", position = 4)
    private String searchKey;
}
