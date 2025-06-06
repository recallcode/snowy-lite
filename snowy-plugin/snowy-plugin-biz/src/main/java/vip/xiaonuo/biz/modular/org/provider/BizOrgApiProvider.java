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
package vip.xiaonuo.biz.modular.org.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.json.JSONObject;
import com.mybatisflex.core.paginate.Page;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import vip.xiaonuo.biz.api.BizOrgApi;
import vip.xiaonuo.biz.modular.org.param.BizOrgSelectorOrgListParam;
import vip.xiaonuo.biz.modular.org.service.BizOrgService;

import java.util.List;

/**
 * 组织API接口提供者
 *
 * @author yubaoshan
 * @date 2024/11/1 18:27:51
 **/
@Component
public class BizOrgApiProvider implements BizOrgApi {

    @Inject
    private BizOrgService bizOrgService;

    @Override
    public List<Tree<String>> orgTreeSelector() {
        return bizOrgService.orgTreeSelector();
    }

    @SuppressWarnings("ALL")
    @Override
    public Page<JSONObject> orgListSelector(String parentId) {
        BizOrgSelectorOrgListParam bizOrgSelectorOrgListParam = new BizOrgSelectorOrgListParam();
        bizOrgSelectorOrgListParam.setParentId(parentId);
        return BeanUtil.toBean(bizOrgService.orgListSelector(bizOrgSelectorOrgListParam), Page.class);
    }
}