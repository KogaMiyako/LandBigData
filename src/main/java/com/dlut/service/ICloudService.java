package com.dlut.service;

import com.dlut.pojo.Cluster;
import com.dlut.pojo.Node;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/20.
 */
public interface ICloudService {

    public Cluster getClusterInfoById(int clusterId);

    public List<Node> getNodeList();

    public boolean updateNodeByIp(String status,String ip);
}
