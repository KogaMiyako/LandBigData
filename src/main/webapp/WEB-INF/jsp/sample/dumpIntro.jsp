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
                        <img src="${pageContext.request.contextPath}/assets/img/soil/wumi-1-resize.jpeg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/wumi-2-resize.jpeg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/wumi-3-resize.jpeg">
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
        <h2>开放式景区视图</h2>
        <h3>地点：大连金石滩景区</h3>
        <h3>场景简介：海边的旅游景区，游客来海边游泳度假，商贩提供饮料零食烧烤等服务，活动过程中会产生大量垃圾，污染比较严重。</h3>
        <h3>污染来源：游客在海边游玩、饮食等产生的垃圾；小吃店、烧烤店周围产生的污染</h3>
        <div style="margin-top: 18px">
            <h4 >&emsp;&emsp;离岸边较远的地方设置的一些餐饮店通常与正常饭店不同，提供的餐具通常是便携的一次性纸质餐具，可供游客拿到其他地方享用；
                游客也经常会买一些章鱼烧，烤串之类的便携的食物，其中便会产生一些一次性餐具、食物残渣之类的污染。</h4>
            <h4>&emsp;&emsp;被丢入海洋中的垃圾会通过涨落潮漂到海岸边，逐渐堆积造成海岸边的污染，通常会集中堆积在几个区域，污染土壤的同时，对海洋生物造成影响。</h4>
        </div>
    </div>
</div>
