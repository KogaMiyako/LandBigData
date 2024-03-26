package com.dlut.service;

import com.dlut.pojo.Userfile;

public interface UserFileService {
    // user id / user name -> User file
    public Userfile getUserFile(int userId);

    // get file save path
    public String getUserFilePath();

    // get remote file save path
    public String getUserRemoteFilePath();

}
