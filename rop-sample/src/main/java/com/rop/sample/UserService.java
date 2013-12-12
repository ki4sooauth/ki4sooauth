/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-2-29
 */
package com.rop.sample;

import com.rop.RopRequest;
import com.rop.annotation.*;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.response.NotExistErrorResponse;
import com.rop.sample.request.CreateUserRequest;
import com.rop.sample.request.LogonRequest;
import com.rop.sample.request.UploadUserPhotoRequest;
import com.rop.sample.response.CreateUserResponse;
import com.rop.sample.response.LogonResponse;
import com.rop.sample.response.LogoutResponse;
import com.rop.sample.response.UploadUserPhotoResponse;
import com.rop.session.SimpleSession;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@ServiceMethodBean(version = "1.0")
public class UserService {

    private static final String USER_NAME_RESERVED = "USER_NAME_RESERVED";
    private List reservesUserNames = Arrays.asList(new String[]{"toms", "jhon"});

    @ServiceMethod(method = "user.getSession",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getSession(LogonRequest request) {
        //创建一个会话
        SimpleSession session = new SimpleSession();
        session.setAttribute("userName",request.getUserName());
        request.getRopRequestContext().addSession("mockSessionId1", session);

        //返回响应
        LogonResponse logonResponse = new LogonResponse();
        logonResponse.setSessionId("mockSessionId1");
        return logonResponse;
    }

    @ServiceMethod(method = "user.logon",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object logon(LogonRequest request) {
        //创建一个会话
        SimpleSession session = new SimpleSession();
        session.setAttribute("userName",request.getUserName());
        request.getRopRequestContext().addSession("mockSessionId1", session);

        //返回响应
        LogonResponse logonResponse = new LogonResponse();
        logonResponse.setSessionId("mockSessionId1");
        return logonResponse;
    }

    @ServiceMethod(method = "user.logout",version = "1.0")
    public Object logout(RopRequest request) {
        request.getRopRequestContext().removeSession();
        LogoutResponse response = new LogoutResponse();
        response.setSuccessful(true);
        return response;
    }

    /**
     * 过期版本的服务方法
     * @param request
     * @return
     */
    @ServiceMethod(method = "user.add", version = "0.9",obsoleted = ObsoletedType.YES)
    public Object addUserOfV0_9(CreateUserRequest request) {
        request.getRopRequestContext().getLocale();
        if (reservesUserNames.contains(request.getUserName())) {
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), USER_NAME_RESERVED,
                    request.getRopRequestContext().getLocale(), request.getUserName());
        } else {
            CreateUserResponse response = new CreateUserResponse();
            //add creaet new user here...
            response.setCreateTime("20120101010101");
            response.setUserId("1");
            return response;
        }
    }

    @ServiceMethod(method = "user.add", version = "1.0")//② Let this method service the sample.user.add method
    public Object addUser(CreateUserRequest request) {
        if (reservesUserNames.contains(request.getUserName())) { //如果注册的用户是预留的帐号，则返回错误的报文
            //这个业务错误将引用扩展国际化错误资源中的消息（i18n/rop/sampleRopError）
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), USER_NAME_RESERVED,
                    request.getRopRequestContext().getLocale(), request.getUserName());
        } else {
            CreateUserResponse response = new CreateUserResponse();
            //add creaet new user here...
            response.setCreateTime("20120101010101");
            response.setUserId("1");
            response.setFeedback("hello");
            return response;
        }
    }

    //版本为2.0的user.add
    @ServiceMethod(method = "user.add", version = "2.0")
    public Object addUser2(CreateUserRequest request) {
        if (reservesUserNames.contains(request.getUserName())) { //如果注册的用户是预留的帐号，则返回错误的报文
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), USER_NAME_RESERVED,
                    request.getRopRequestContext().getLocale(), request.getUserName());
        } else {
            CreateUserResponse response = new CreateUserResponse();
            //add creaet new user here...
            response.setCreateTime("20120101010102");
            response.setUserId("2");
            return response;
        }
    }

    //版本为4.0的user.add:不需要会话
    @ServiceMethod(method = "user.add", version = "4.0", needInSession = NeedInSessionType.NO)
    public Object addUser4(CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        //add creaet new user here...
        response.setCreateTime("20120101010102");
        response.setUserId("4");
        return response;
    }

    //版本为5.0的user.add:不需要进行签名验证
    @ServiceMethod(method = "user.add", version = "5.0", ignoreSign = IgnoreSignType.YES)
    public Object addUser5(CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        response.setCreateTime("20120101010102");
        response.setUserId("4");
        return response;
    }

    //模拟一个会过期的服务（过期时间为1秒）
    @ServiceMethod(method = "user.timeout", version = "1.0", timeout = 1)
    public Object timeoutService(CreateUserRequest request) throws Throwable {
        Thread.sleep(2000);
        CreateUserResponse response = new CreateUserResponse();
        //add creaet new user here...
        response.setCreateTime("20120101010102");
        response.setUserId("2");
        return response;
    }

    @ServiceMethod(method = "user.rawRopRequest", version = "1.0")
    public Object useRawRopRequest(RopRequest request) throws Throwable {
        String userId = request.getRopRequestContext().getParamValue("userId");
        CreateUserResponse response = new CreateUserResponse();
        //add creaet new user here...
        response.setCreateTime("20120101010102");
        response.setUserId(userId);
        return response;
    }

    @ServiceMethod(method = "user.customConverter", version = "1.0")
    public Object customConverter(CreateUserRequest request) throws Throwable {
        String userId = request.getRopRequestContext().getParamValue("userId");
        CreateUserResponse response = new CreateUserResponse();
        //add creaet new user here...
        response.setCreateTime("20120101010102");
        response.setUserId(userId);
        response.setFeedback(request.getTelephone().getZoneCode() + "#" + request.getTelephone().getTelephoneCode());
        return response;
    }

    //直接使用RopRequest对象作为入参
    @ServiceMethod(method = "user.query", version = "1.0", httpAction = HttpAction.GET)
    public Object queryUsers(RopRequest request) throws Throwable {
        //直接从参数列表中获取参数值
        String userId = request.getRopRequestContext().getParamValue("userId");
        CreateUserResponse response = new CreateUserResponse();
        response.setCreateTime("20120101010102");
        response.setUserId(userId);
        response.setFeedback("user.query");
        return response;
    }

    /**
     * 当userId为9999时，模拟一个NotExistErrorResponse的响应
     * @param request
     * @return
     * @throws Throwable
     */
    @ServiceMethod(method = "user.get", version = "1.0", httpAction = HttpAction.GET)
    public Object getUser(RopRequest request) throws Throwable {
        String userId = request.getRopRequestContext().getParamValue("userId");
        if("9999".equals(userId)){
            return new NotExistErrorResponse("user","userId","9999",request.getRopRequestContext().getLocale());
        }else{
            CreateUserResponse response = new CreateUserResponse();
            //add creaet new user here...
            response.setCreateTime("20120101010102");
            response.setUserId(userId);
            response.setFeedback("user.get");
            return response;
        }
    }

    /**
     *  上传用户头像的图片
     * @param request
     * @return
     * @throws Throwable
     */
    @ServiceMethod(method = "user.upload.photo", version = "1.0", httpAction = HttpAction.POST)
    public Object uploadPhoto(UploadUserPhotoRequest request) throws Throwable {
        String fileType = request.getPhoto().getFileType();
        int length = request.getPhoto().getContent().length;
        ClassPathResource outFile = new ClassPathResource("/");
        FileCopyUtils.copy(request.getPhoto().getContent(),new File(outFile.getFile().getParent()+"/1." + fileType));
        UploadUserPhotoResponse response = new UploadUserPhotoResponse();
        response.setFileType(fileType);
        response.setLength(length);
        return response;
    }

}

