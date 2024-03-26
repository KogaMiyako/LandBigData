<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
    .carousel-inner{
        overflow: clip;
    }
</style>

<div class="row">
    <div class="col-md-6" style="margin-top: 45px">
        <div class="dumpShow">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/zhognzhi-1.jpg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/zhognzhi-2.jpg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/zhognzhi-3.jpg">
                        <div class="carousel-caption">
                        </div>
                    </div>

                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="false"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="false" ></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col-md-6" style="margin-top: 45px">
        <%--<h2>大连樱桃基地采样点</h2>
        <h3>地点：辽宁省大连市</h3>
        <h3>采样数据：土壤有机氯化物污染数据</h3>
        <h3>主要污染：六氯环己烷、双对氯苯基三氯乙烷、多环芳烃</h3>
        <div style="margin-top: 18px">
            <h4 >&emsp;&emsp;有机氯农药污染是多氯有机合成的杀虫剂所造成的环境污染。有机氯农药主要品种有滴滴涕（DDT）、
                六六六等。由于其化学性质稳定、难于分解，能造成对环境的严重污染。</h4>
        </div>--%>
        <h2>采摘园场景视图</h2>
        <h3>地点：辽宁省大连市</h3>
        <h3>场景简介：以采摘水果为主题的养殖园，为游客提供采摘水果的体验活动和餐饮服务。
            </h3>
        <h3>污染来源：果树种植过程中的污染（有机物污染，包括种植中常用的杀虫剂等有机农药）；游客在种植园中采摘时产生的垃圾</h3>
        <div style="margin-top: 18px">
            <h4 >&emsp;&emsp;随着人民日益增长的对美好生活的需求逐渐多样化，住在城市中的家庭产生了想让小朋友在周末与大自然更多接触，
                因此当地众多小型采摘园为满足城市居民的需求，开设采摘等周边服务，在小规模生产的同时开展服务业。</h4>
            <h4>&emsp;&emsp;大量游客的旅游需求必然会导致当地环境的污染，游客不文明采摘导致的污染更会对土壤造成严重的污染。</h4>
        </div>
    </div>
</div>