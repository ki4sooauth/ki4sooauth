/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-8-2
 */
package com.rop.security;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *    1.如果maxSize为非正数，则表示不限制大小；
 *    2.如果allowAllTypes为true表示不限制文件类型；
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class DefaultFileUploadController implements FileUploadController {

    private List<String> fileTypes;
    
    private int maxSize;

    private boolean allowAllTypes = false;

    public DefaultFileUploadController(int maxSize) {
        this.allowAllTypes = true;
        this.maxSize = maxSize;
    }

    public DefaultFileUploadController(List<String> fileTypes, int maxSize) {
        ArrayList<String> tempFileTypes = new ArrayList<String>(fileTypes.size());
        for (String fileType : fileTypes) {
            tempFileTypes.add(fileType.toLowerCase());
        }
        this.fileTypes = tempFileTypes;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isAllowFileType(String fileType) {
        if(allowAllTypes){
            return true;
        }else{
            if(fileType == null){
                return false;
            }else{
                fileType = fileType.toLowerCase();
                return fileTypes.contains(fileType);
            }
        }
    }

    @Override
    public boolean isExceedMaxSize(int fileSize) {
        if(maxSize > 0){
            return fileSize > maxSize * 1024;
        }else{
            return false;
        }
    }
}

