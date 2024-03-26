package com.dlut.service;

import com.dlut.pojo.File;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/20.
 */
public interface IFileService {
    public List<String> getFileList(String downLoadPath);
    public void uploadFile(String localName, String storePath);
    public void downloadFile(String storePath);
}
