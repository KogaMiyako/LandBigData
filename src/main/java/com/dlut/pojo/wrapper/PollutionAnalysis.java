package com.dlut.pojo.wrapper;

import com.dlut.pojo.Pollution;

public class PollutionAnalysis {
    private PollutionWrapper plu;       //污染源包装类
    private Integer main = 0;           //相关性
    private Integer mainSimilar = 0;
    private Integer notMain = 0;
    private Integer notMainSimilar = 0;
    private boolean SimilarIsMain = false;


    public boolean isSimilarIsMain() {
        return SimilarIsMain;
    }

    public void setSimilarIsMain(boolean similarIsMain) {
        SimilarIsMain = similarIsMain;
    }

    public PollutionAnalysis(PollutionWrapper plu, Integer main, Integer mainSimilar, Integer notMain, Integer notMainSimilar, boolean similarIsMain) {
        this.plu = plu;
        this.main = main;
        this.mainSimilar = mainSimilar;

        this.notMain = notMain;
        this.notMainSimilar = notMainSimilar;
        SimilarIsMain = similarIsMain;
    }

    public Integer getMainSimilar() {
        return mainSimilar;
    }

    public void setMainSimilar(Integer mainSimilar) {
        this.mainSimilar = mainSimilar;
    }

    public Integer getNotMainSimilar() {
        return notMainSimilar;
    }

    public void setNotMainSimilar(Integer notMainSimilar) {
        this.notMainSimilar = notMainSimilar;
    }

    public PollutionAnalysis(PollutionWrapper plu) {
        this.plu = plu;
    }

    public PollutionWrapper getPlu() {
        return plu;
    }

    public void setPlu(PollutionWrapper plu) {
        this.plu = plu;
    }

    public Integer getMain() {
        return main;
    }

    public void setMain(Integer main) {
        this.main = main;
    }


    public Integer getNotMain() {
        return notMain;
    }

    public void setNotMain(Integer notMain) {
        this.notMain = notMain;
    }
}
