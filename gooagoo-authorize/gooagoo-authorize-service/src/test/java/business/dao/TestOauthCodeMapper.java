package business.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.authzserver.api.CodeGeneratorService;
import com.gooagoo.authzserver.dao.OauthCodeMapper;
import com.gooagoo.authzserver.entity.business.OauthCodeBusiness;
import com.gooagoo.common.utils.TimeUtils;

public class TestOauthCodeMapper
{
    @Autowired
    private OauthCodeMapper oauthCodeMapper;
    @Autowired
    private CodeGeneratorService codeGeneratorService;

    /**
     * 添加临时token
     */
    @Test
    public void testAddOauthCode() throws Exception
    {
        OauthCodeBusiness oauthCodeBusiness = new OauthCodeBusiness();
        oauthCodeBusiness.setAppKey("10004");
        oauthCodeBusiness.setCode(this.codeGeneratorService.generateValue());
        oauthCodeBusiness.setExpireTime(TimeUtils.convertStringToDate("2014-09-24 14:22:22"));
        this.oauthCodeMapper.addOauthCode(oauthCodeBusiness);

    }
}
