package com.dlut.pojo.wrapper;

import com.dlut.pojo.Pollution;

import java.util.List;

public class PollutionWrapper extends Pollution {
    private double[] pluArrs;

    public double[] getPluArrs() {
        return pluArrs;
    }

    public void setPluArrs(double[] pluArrs) {
        this.pluArrs = pluArrs;
    }
    public static void convert(List<Pollution> from,List<PollutionWrapper> to){
        for(Pollution plu : from){
            PollutionWrapper pw = new PollutionWrapper();
            pw.setAs(plu.getAs());
            pw.setCd(plu.getCd());
            pw.setCu(plu.getCu());
            pw.setCr(plu.getCr());
            pw.setHg(plu.getHg());
            pw.setPb(plu.getPb());
            pw.setZn(plu.getZn());
            pw.setNi(plu.getNi());
            pw.setPollutionDescribe(plu.getPollutionDescribe());
            pw.setPollutionId(plu.getPollutionId());
            pw.setPollutionName(plu.getPollutionName());
            double[] arr = new double[]{pw.getCr(),pw.getNi(),pw.getCu(),pw.getZn(),pw.getAs(),pw.getCd(),pw.getHg(),pw.getPb()};
            pw.setPluArrs(arr);
            to.add(pw);
        }
    }
    public static PollutionWrapper convert(Pollution plu){
        PollutionWrapper pw = new PollutionWrapper();
        pw.setAs(plu.getAs());
        pw.setCd(plu.getCd());
        pw.setCu(plu.getCu());
        pw.setCr(plu.getCr());
        pw.setHg(plu.getHg());
        pw.setPb(plu.getPb());
        pw.setZn(plu.getZn());
        pw.setNi(plu.getNi());
        pw.setPollutionDescribe(plu.getPollutionDescribe());
        pw.setPollutionId(plu.getPollutionId());
        pw.setPollutionName(plu.getPollutionName());
        double[] arr = new double[]{pw.getCr(),pw.getNi(),pw.getCu(),pw.getZn(),pw.getAs(),pw.getCd(),pw.getHg(),pw.getPb()};
        pw.setPluArrs(arr);
        return pw;
    }
}
