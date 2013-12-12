/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-8-1
 */
package com.rop.request;

/**
 * <pre>
 *   将以BASE64位编码字符串转换为字节数组的{@link UploadFile}对象
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class UploadFileConverter implements RopConverter<String, UploadFile> {

    @Override
    public UploadFile convert(String source) {
        String fileType = UploadFileUtils.getFileType(source);
        byte[] contentBytes = UploadFileUtils.decode(source);
        return new UploadFile(fileType, contentBytes);
    }

    @Override
    public String unconvert(UploadFile target) {
        return UploadFileUtils.encode(target);
    }

    @Override
    public Class<String> getSourceClass() {
        return String.class;
    }

    @Override
    public Class<UploadFile> getTargetClass() {
        return UploadFile.class;
    }
}

