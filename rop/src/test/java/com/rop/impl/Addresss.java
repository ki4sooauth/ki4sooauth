/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-4-17
 */
package com.rop.impl;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "address")
public class Addresss {

    @XmlAttribute
    @Pattern(regexp = "\\w{4,30}")
    private String zoneCode;

    @XmlAttribute
    private String doorCode;


    @XmlElementWrapper(name = "streets")
    @XmlElement(name = "street")
    private List<Street> streets;

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getDoorCode() {
        return doorCode;
    }

    public void setDoorCode(String doorCode) {
        this.doorCode = doorCode;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}

