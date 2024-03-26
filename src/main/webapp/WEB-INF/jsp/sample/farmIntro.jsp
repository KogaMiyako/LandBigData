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
                        <img src="${pageContext.request.contextPath}/assets/img/soil/yangzhi-1.jpg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/yangzhi-2.jpg">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/assets/img/soil/yangzhi-3.jpg">
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
        <%--<h2>重金属采样点</h2>
        <h3>地点：辽宁省大连市</h3>
        <h3>采样数据：重金属数据</h3>
        <h3>主要污染：Cu、Zn、Ni</h3>
        <div style="margin-top: 18px">
            <h4 >&emsp;&emsp;重金属污染指由重金属或其化合物造成的环境污染。主要由采矿、废气排放、污水灌溉和使用重金属超标制品等人为因素所致。
                重金属原义是指比重大于5的金属（密度大于4.5 克每立方厘米的金属），
                包括金、银、铜、铁、铅等。重金属污染与其他有机化合物的污染不同。
                不少有机化合物可以通过自然界本身物理的、化学的或生物的净化，使有害性降低或解除。而重金属具有富集性，很难在环境中降解。</h4>
        </div>--%>
        <h2>散户养殖场视图</h2>
        <h3>地点：辽宁省大连市</h3>
        <h3>场景简介：以农家乐（动物互动）为主题的养殖园，为游客提供喂养动物的体验活动和餐饮服务。</h3>
        <h3>污染来源：动物饲养过程中的污染；游客在养殖园中活动时产生的垃圾</h3>
        <div style="margin-top: 18px">
            <h4 >&emsp;&emsp;Cu、Zn是动物机体必需微量元素之一，是非常重要的营养因素，它们直接或间接参与动物的生长和发育。另外游客由于不具备专业的喂养知识，
                有可能会喂养部分不适合动物的食物，从而导致土壤的污染。</h4>
            <h4>&emsp;&emsp;与大规模养殖不同的是，散户养殖场由于面向的对象不同，因此不具备规范的垃圾处理条件，在相应垃圾处理上存在疏漏而导致土壤污染，</h4>
        </div>
    </div>
</div>