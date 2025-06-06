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
package vip.xiaonuo.sys.modular.role.controller;

import cn.hutool.core.lang.tree.Tree;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import vip.xiaonuo.common.annotation.CommonLog;
import vip.xiaonuo.common.pojo.CommonResult;
import vip.xiaonuo.common.pojo.CommonValidList;
import vip.xiaonuo.sys.modular.role.entity.SysRole;
import vip.xiaonuo.sys.modular.role.param.*;
import vip.xiaonuo.sys.modular.role.result.*;
import vip.xiaonuo.sys.modular.role.service.SysRoleService;
import vip.xiaonuo.sys.modular.user.entity.SysUser;

import org.noear.solon.validation.annotation.NotEmpty;
import java.util.List;

/**
 * 角色控制器
 *
 * @author xuyuxiang
 * @date 2022/4/25 20:19
 */
@Api(tags = "角色控制器")
@Controller
@Valid
public class SysRoleController {

    @Inject
    private SysRoleService sysRoleService;

    /**
     * 获取角色分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色分页")
    @Get
    @Mapping("/sys/role/page")
    public CommonResult<Page<SysRole>> page(SysRolePageParam sysRolePageParam) {
        return CommonResult.data(sysRoleService.page(sysRolePageParam));
    }

    /**
     * 添加角色
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加角色")
    @CommonLog("添加角色")
    @Post
    @Mapping("/sys/role/add")
    public CommonResult<String> add(@Validated SysRoleAddParam sysRoleAddParam) {
        sysRoleService.add(sysRoleAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑角色
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑角色")
    @CommonLog("编辑角色")
    @Post
    @Mapping("/sys/role/edit")
    public CommonResult<String> edit(@Validated SysRoleEditParam sysRoleEditParam) {
        sysRoleService.edit(sysRoleEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除角色
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除角色")
    @CommonLog("删除角色")
    @Post
    @Mapping("/sys/role/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<SysRoleIdParam> sysRoleIdParamList) {
        sysRoleService.delete(sysRoleIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取角色详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色详情")
    @Get
    @Mapping("/sys/role/detail")
    public CommonResult<SysRole> detail(@Validated SysRoleIdParam sysRoleIdParam) {
        return CommonResult.data(sysRoleService.detail(sysRoleIdParam));
    }

    /**
     * 获取角色拥有资源
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色拥有资源")
    @Get
    @Mapping("/sys/role/ownResource")
    public CommonResult<SysRoleOwnResourceResult> ownResource(@Validated SysRoleIdParam sysRoleIdParam) {
        return CommonResult.data(sysRoleService.ownResource(sysRoleIdParam));
    }

    /**
     * 给角色授权资源
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("给角色授权资源")
    @CommonLog("给角色授权资源")
    @Post
    @Mapping("/sys/role/grantResource")
    public CommonResult<String> grantResource(@Validated SysRoleGrantResourceParam sysRoleGrantResourceParam) {
        sysRoleService.grantResource(sysRoleGrantResourceParam);
        return CommonResult.ok();
    }

    /**
     * 获取角色拥有移动端菜单
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色拥有移动端菜单")
    @Get
    @Mapping("/sys/role/ownMobileMenu")
    public CommonResult<SysRoleOwnMobileMenuResult> ownMobileMenu(@Validated SysRoleIdParam sysRoleIdParam) {
        return CommonResult.data(sysRoleService.ownMobileMenu(sysRoleIdParam));
    }

    /**
     * 给角色授权移动端菜单
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("给角色授权移动端菜单")
    @CommonLog("给角色授权移动端菜单")
    @Get
    @Mapping("/sys/role/grantMobileMenu")
    public CommonResult<String> grantMobileMenu(@Validated SysRoleGrantMobileMenuParam sysRoleGrantMobileMenuParam) {
        sysRoleService.grantMobileMenu(sysRoleGrantMobileMenuParam);
        return CommonResult.ok();
    }

    /**
     * 获取角色拥有权限
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色拥有权限")
    @Get
    @Mapping("/sys/role/ownPermission")
    public CommonResult<SysRoleOwnPermissionResult> ownPermission(@Validated SysRoleIdParam sysRoleIdParam) {
        return CommonResult.data(sysRoleService.ownPermission(sysRoleIdParam));
    }

    /**
     * 给角色授权权限
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("给角色授权权限")
    @CommonLog("给角色授权权限")
    @Post
    @Mapping("/sys/role/grantPermission")
    public CommonResult<String> grantPermission(@Validated SysRoleGrantPermissionParam sysRoleGrantPermissionParam) {
        sysRoleService.grantPermission(sysRoleGrantPermissionParam);
        return CommonResult.ok();
    }

    /**
     * 获取角色下的用户
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色下的用户")
    @Get
    @Mapping("/sys/role/ownUser")
    public CommonResult<List<String>> ownUser(@Validated SysRoleIdParam sysRoleIdParam) {
        return CommonResult.data(sysRoleService.ownUser(sysRoleIdParam));
    }

    /**
     * 给角色授权用户
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("给角色授权用户")
    @CommonLog("给角色授权用户")
    @Post
    @Mapping("/sys/role/grantUser")
    public CommonResult<String> grantUser(@Validated SysRoleGrantUserParam sysRoleGrantUserParam) {
        sysRoleService.grantUser(sysRoleGrantUserParam);
        return CommonResult.ok();
    }

    /* ====角色部分所需要用到的选择器==== */

    /**
     * 获取组织树选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取组织树选择器")
    @Get
    @Mapping("/sys/role/orgTreeSelector")
    public CommonResult<List<Tree<String>>> orgTreeSelector() {
        return CommonResult.data(sysRoleService.orgTreeSelector());
    }

    /**
     * 获取资源授权树
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取资源授权树")
    @Get
    @Mapping("/sys/role/resourceTreeSelector")
    public CommonResult<List<SysRoleGrantResourceTreeResult>> resourceTreeSelector() {
        return CommonResult.data(sysRoleService.resourceTreeSelector());
    }

    /**
     * 获取移动端菜单授权树
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取移动端菜单授权树")
    @Get
    @Mapping("/sys/role/mobileMenuTreeSelector")
    public CommonResult<List<SysRoleGrantMobileMenuTreeResult>> mobileMenuTreeSelector() {
        return CommonResult.data(sysRoleService.mobileMenuTreeSelector());
    }

    /**
     * 获取权限授权树
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取权限授权树")
    @Get
    @Mapping("/sys/role/permissionTreeSelector")
    public CommonResult<List<String>> permissionTreeSelector() {
        return CommonResult.data(sysRoleService.permissionTreeSelector());
    }

    /**
     * 获取角色选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取角色选择器")
    @Get
    @Mapping("/sys/role/roleSelector")
    public CommonResult<Page<SysRole>> roleSelector(SysRoleSelectorRoleParam sysRoleSelectorRoleParam) {
        return CommonResult.data(sysRoleService.roleSelector(sysRoleSelectorRoleParam));
    }

    /**
     * 获取用户选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取用户选择器")
    @Get
    @Mapping("/sys/role/userSelector")
    public CommonResult<Page<SysUser>> userSelector(SysRoleSelectorUserParam sysRoleSelectorUserParam) {
        return CommonResult.data(sysRoleService.userSelector(sysRoleSelectorUserParam));
    }
}
