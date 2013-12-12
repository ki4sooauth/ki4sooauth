/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-8-2
 */
package com.rop.response;

import com.rop.security.MainError;
import com.rop.security.MainErrorType;
import com.rop.security.MainErrors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;

/**
 * <pre>
 *   当服务平台资源耗尽（超过最大线程数且列队排满后）
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class RejectedServiceResponse extends ErrorResponse  {

    public RejectedServiceResponse() {
    }

    public RejectedServiceResponse(Locale locale) {
        MainError mainError = MainErrors.getError(MainErrorType.FORBIDDEN_REQUEST, locale);
        setMainError(mainError);
    }
}

