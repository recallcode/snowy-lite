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
package vip.xiaonuo.client.modular.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import vip.xiaonuo.client.modular.relation.service.ClientRelationService;
import vip.xiaonuo.client.modular.user.entity.ClientUser;
import vip.xiaonuo.client.modular.user.enums.ClientUserStatusEnum;
import vip.xiaonuo.client.modular.user.mapper.ClientUserMapper;
import vip.xiaonuo.client.modular.user.param.ClientUserAddParam;
import vip.xiaonuo.client.modular.user.param.ClientUserEditParam;
import vip.xiaonuo.client.modular.user.param.ClientUserIdParam;
import vip.xiaonuo.client.modular.user.param.ClientUserPageParam;
import vip.xiaonuo.client.modular.user.result.ClientLoginUser;
import vip.xiaonuo.client.modular.user.service.ClientUserService;
import vip.xiaonuo.common.enums.CommonSortOrderEnum;
import vip.xiaonuo.common.exception.CommonException;
import vip.xiaonuo.common.page.CommonPageRequest;
import vip.xiaonuo.common.util.*;
import vip.xiaonuo.dev.api.DevConfigApi;

import java.util.List;

/**
 * C端用户Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:43
 **/
@Component
public class ClientUserServiceImpl extends ServiceImpl<ClientUserMapper, ClientUser> implements ClientUserService {

    private static final String SNOWY_SYS_DEFAULT_PASSWORD_KEY = "SNOWY_SYS_DEFAULT_PASSWORD";

    @Inject
    private DevConfigApi devConfigApi;

    @Inject
    private ClientRelationService clientRelationService;

    @Override
    public ClientLoginUser getUserById(String id) {
        ClientUser clientUser = this.getById(id);
        if (ObjectUtil.isNotEmpty(clientUser)) {
            ClientLoginUser clientLoginUser = BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
            if (ObjectUtil.isNotEmpty(clientLoginUser.getPhone())) {
                clientLoginUser.setPhone(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getPhone()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getIdCardNumber())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getIdCardNumber()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getEmergencyPhone())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getEmergencyPhone()));
            }
            return clientLoginUser;
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByAccount(String account) {
        ClientUser clientUser = this.getOne(new QueryWrapper().eq(ClientUser::getAccount, account));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            ClientLoginUser clientLoginUser = BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
            if (ObjectUtil.isNotEmpty(clientLoginUser.getPhone())) {
                clientLoginUser.setPhone(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getPhone()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getIdCardNumber())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getIdCardNumber()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getEmergencyPhone())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getEmergencyPhone()));
            }
            return clientLoginUser;
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByPhone(String phone) {
        ClientUser clientUser = this.getOne(new QueryWrapper().eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(phone)));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            ClientLoginUser clientLoginUser = BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
            if (ObjectUtil.isNotEmpty(clientLoginUser.getPhone())) {
                clientLoginUser.setPhone(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getPhone()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getIdCardNumber())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getIdCardNumber()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getEmergencyPhone())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getEmergencyPhone()));
            }
            return clientLoginUser;
        }
        return null;
    }

    @Override
    public ClientLoginUser getUserByEmail(String email) {
        ClientUser clientUser = this.getOne(new QueryWrapper().eq(ClientUser::getEmail, email));
        if (ObjectUtil.isNotEmpty(clientUser)) {
            ClientLoginUser clientLoginUser = BeanUtil.copyProperties(clientUser, ClientLoginUser.class);
            if (ObjectUtil.isNotEmpty(clientLoginUser.getPhone())) {
                clientLoginUser.setPhone(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getPhone()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getIdCardNumber())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getIdCardNumber()));
            }
            if (ObjectUtil.isNotEmpty(clientLoginUser.getEmergencyPhone())) {
                clientLoginUser.setIdCardNumber(CommonCryptogramUtil.doSm4CbcDecrypt(clientLoginUser.getEmergencyPhone()));
            }
            return clientLoginUser;
        }
        return null;
    }

    @Override
    public Page<ClientUser> page(ClientUserPageParam clientUserPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(clientUserPageParam.getSearchKey())) {
            queryWrapper.and(q -> {
                q.like(ClientUser::getName, clientUserPageParam.getSearchKey());
            }).or(q -> {
                q.like(ClientUser::getAccount, clientUserPageParam.getSearchKey());
            });
        }
        if (ObjectUtil.isAllNotEmpty(clientUserPageParam.getSortField(), clientUserPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(clientUserPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(clientUserPageParam.getSortField()),clientUserPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ClientUser::getSortCode);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(ClientUserAddParam clientUserAddParam) {
        checkParam(clientUserAddParam);
        // 设置手机号
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getPhone())) {
            clientUserAddParam.setPhone(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserAddParam.getPhone()));
        }
        // 设置证件号
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getIdCardNumber())) {
            clientUserAddParam.setIdCardNumber(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserAddParam.getIdCardNumber()));
        }
        // 设置紧急联系人电话
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getEmergencyPhone())) {
            clientUserAddParam.setEmergencyPhone(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserAddParam.getEmergencyPhone()));
        }
        ClientUser clientUser = BeanUtil.toBean(clientUserAddParam, ClientUser.class);
        if (ObjectUtil.isEmpty(clientUser.getAvatar())) {
            // 设置默认头像
            clientUser.setAvatar(CommonAvatarUtil.generateImg(clientUser.getName()));
        }
        // 设置默认密码
        clientUser.setPassword(CommonCryptogramUtil.doHashValue(devConfigApi.getValueByKey(SNOWY_SYS_DEFAULT_PASSWORD_KEY)));
        // 设置状态
        clientUser.setUserStatus(ClientUserStatusEnum.ENABLE.getValue());
        this.save(clientUser);
    }

    private void checkParam(ClientUserAddParam clientUserAddParam) {
        if (this.count(new QueryWrapper()
                .eq(ClientUser::getAccount, clientUserAddParam.getAccount())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", clientUserAddParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getPhone())) {
            if (!PhoneUtil.isMobile(clientUserAddParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", clientUserAddParam.getPhone());
            }
            if (this.count(new QueryWrapper()
                    .eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(clientUserAddParam.getPhone()))) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", clientUserAddParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(clientUserAddParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(clientUserAddParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", clientUserAddParam.getEmail());
            }
            if (this.count(new QueryWrapper()
                    .eq(ClientUser::getEmail, clientUserAddParam.getEmail())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", clientUserAddParam.getEmail());
            }
        }
    }

    @Override
    public void edit(ClientUserEditParam clientUserEditParam) {
        ClientUser clientUser = this.queryEntity(clientUserEditParam.getId());
        checkParam(clientUserEditParam);
        // 设置手机号
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getPhone())) {
            clientUserEditParam.setPhone(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserEditParam.getPhone()));
        }
        // 设置证件号
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getIdCardNumber())) {
            clientUserEditParam.setIdCardNumber(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserEditParam.getIdCardNumber()));
        }
        // 设置紧急联系人电话
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getEmergencyPhone())) {
            clientUserEditParam.setEmergencyPhone(CommonCryptogramUtil.doSm4CbcEncrypt(clientUserEditParam.getEmergencyPhone()));
        }
        BeanUtil.copyProperties(clientUserEditParam, clientUser);
        this.updateById(clientUser);
    }

    private void checkParam(ClientUserEditParam clientUserEditParam) {
        if (this.count(new QueryWrapper()
                .eq(ClientUser::getAccount, clientUserEditParam.getAccount())
                .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", clientUserEditParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getPhone())) {
            if (!PhoneUtil.isMobile(clientUserEditParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", clientUserEditParam.getPhone());
            }
            if (this.count(new QueryWrapper()
                    .eq(ClientUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(clientUserEditParam.getPhone()))
                    .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", clientUserEditParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(clientUserEditParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(clientUserEditParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", clientUserEditParam.getEmail());
            }
            if (this.count(new QueryWrapper()
                    .eq(ClientUser::getEmail, clientUserEditParam.getEmail())
                    .ne(ClientUser::getId, clientUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", clientUserEditParam.getEmail());
            }
        }
    }

    @Tran
    @Override
    public void delete(List<ClientUserIdParam> clientUserIdParamList) {
        this.removeByIds(CollStreamUtil.toList(clientUserIdParamList, ClientUserIdParam::getId));
    }

    @Override
    public ClientUser detail(ClientUserIdParam clientUserIdParam) {
        return this.queryEntity(clientUserIdParam.getId());
    }

    @Override
    public void updateUserLoginInfo(String userId, String device) {
        ClientUser clientUser = this.queryEntity(userId);
        clientUser.setLastLoginTime(clientUser.getLatestLoginTime());
        clientUser.setLastLoginIp(clientUser.getLatestLoginIp());
        clientUser.setLastLoginAddress(clientUser.getLatestLoginAddress());
        clientUser.setLastLoginDevice(clientUser.getLatestLoginDevice());
        clientUser.setLatestLoginTime(DateTime.now());
        String ip = CommonIpAddressUtil.getIp(CommonServletUtil.getRequest());
        clientUser.setLatestLoginIp(ip);
        clientUser.setLatestLoginAddress(CommonIpAddressUtil.getCityInfo(ip));
        clientUser.setLatestLoginDevice(device);
        this.updateById(clientUser);
    }

    @Override
    public ClientUser queryEntity(String id) {
        ClientUser clientUser = this.getById(id);
        if (ObjectUtil.isEmpty(clientUser)) {
            throw new CommonException("用户不存在，id值为：{}", id);
        }
        return clientUser;
    }
}
