package com.dlut.service.impl;

import com.dlut.pojo.QueryResult;
import com.dlut.service.ILandDataMineService;
import com.dlut.util.SolrHelper;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 2016/8/9.
 */
@Service("LandDataMineService")
public class LandDataMineServiceImpl implements ILandDataMineService {

    private static Logger log=Logger.getLogger(LandDataMineServiceImpl.class);

    /**
     * 一般搜索
     * @param qt
     * @return
     */
    public List<QueryResult> getQueryResults(String qt) {
        SolrServer solr = SolrHelper.initSolrServer();
        QueryResponse rsp = SolrHelper.solrQuery(solr, qt);
        List<QueryResult> qrresults = analyseResults(rsp);

        return qrresults;
    }

    /**
     *高级搜索
     * @param title
     * @param content
     * @param contentType
     * @param startDate
     * @param endDate
     * @return
     * @throws SolrServerException
     */
    public List<QueryResult> getdvancedQueryResults(String title,String content,String contentType,String startDate,String endDate) {
        SolrServer solr = SolrHelper.initSolrServer();
        QueryResponse rsp = null;
        try {
            rsp = SolrHelper.solrAdvancedQuery(solr, title, content, contentType, startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<QueryResult> qrresults = analyseResults(rsp);

        return qrresults;
    }

    /**
     * QueryResponse结果对象解析方法
     * @param rsp
     * @return List<QueryResult>
     */
    private List<QueryResult> analyseResults(QueryResponse rsp){
        List<QueryResult> qrresults=new ArrayList<QueryResult>();
        if(rsp==null){
            return null;
        }
//      log.info("查询结果："+rsp);
        SolrDocumentList list = rsp.getResults();
        Map<String, Map<String, List<String>>> map = rsp.getHighlighting();
        for (SolrDocument doc : list) {
            QueryResult qr=new QueryResult();
            log.info(doc.getFieldValue("id").toString());
            log.info(map.get(doc.getFieldValue("id").toString()));
            qr.setResultTitle(doc.getFieldValue("id").toString());
            //无内容查询时,返回结果会出现只返回id的情况,此处为这种情况的处理
            if (map.get(doc.getFieldValue("id").toString()).toString().equals("{}")){
                qr.setResultContent(doc.getFieldValue("attr_content").toString());
            } else {
                qr.setResultContent(map.get(doc.getFieldValue("id").toString()).get("attr_content").toString());
            }
            qrresults.add(qr);
        }
        return qrresults;
    }

}
