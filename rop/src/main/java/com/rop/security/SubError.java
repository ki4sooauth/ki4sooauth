/**
 *
 * 日    期：12-2-12
 */
package com.rop.security;


import javax.xml.bind.annotation.*;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "subError")
public class SubError {

    @XmlAttribute
    private String code;

    @XmlElement
    private String message;

    public SubError() {
    }

    public SubError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

