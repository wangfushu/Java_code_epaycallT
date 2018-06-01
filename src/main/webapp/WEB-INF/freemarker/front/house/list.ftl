<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>出租</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="${absoluteContextPath}/css/front_public.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/chuzu.css">
    <script src="${absoluteContextPath}/dist/lib/jquery.min.js"></script>
</head>
<body>
<div class="wrap">
    <div class="commonTopbar">
        <div class="w pos clearfix">
            <div class="bar_left fl">
                <h2>无锡</h2>
                <span class="commonTopbar_ipconfig">
						[<a href="" target="_self">切换城市</a>]
					</span>
            </div>
            <div class="bar_right fr">
                <div class="commonTopbar_login fl">
                    <a href="" target="_self">登录</a>/
                    <a href="" target="_self">注册</a>
                </div>
                <div class="commonTopbar_my58menu fl">
                    <a href="" target="_blank">个人中心</a>
                </div>
                <div class="comment fl">
                    <a href="" target="_comment">论坛中心</a>
                </div>
            </div>
        </div>
    </div>
    <div class="ui-header-wrap clearfix">
        <a href="index.html" class="ui-logo fl">
        </a>
        <div class="ui-head-search fr">
            <div class="ui-search-box">
                <div class="ui-form">
                    <div class="ui-select-box a-select-box">
                        <div class="a-select-btn ui-select-btn ul-show-a">
                            出租
                        </div>
                        <i class="a-down-arrow ui-spriteIcon"></i>
                        <ul class="ui-select-ul ui-hide a-select-ul">
                            <li>
                                <a>出租</a>
                            </li>
                            <li>
                                <a>整租</a>
                            </li>
                            <li>
                                <a>合租</a>
                            </li>
                            <li>
                                <a>二手房</a>
                            </li>
                            <li>
                                <a>短租</a>
                            </li>
                            <li>
                                <a>店铺</a>
                            </li>
                            <li>
                                <a>写字楼</a>
                            </li>
                        </ul>
                    </div>
                    <span class="text ui-search-text">
							<input type="text" class="a-keyword-input" placeholder="开始找房子">
						</span>
                    <span class="btn ui-search-btn">
							<span class="a-search-btn">搜房源</span>
						</span>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="hotnews ui-hot-news">
                <a href="" target="_blank">个人房源</a>
                <a href="" target="_blank">青年白领租房</a>
                <a href="" target="_blank">小户型</a>
            </div>
        </div>
    </div>

    <div class="top-l-line"></div>
    <div class="search_nav">
        <div class="search_hd">
            <ul class="search-hd-ul clearfix">
                <!--选中状态类名为actived-->
                <li class="fl actived">
                    <a href="">租房</a>
                </li>
                <li class="fl">
                    <a href="">二手房</a>
                </li>
                <li class="fl">
                    <a href="">商业房产</a>
                </li>
            </ul>
        </div>
        <div class="search_bd">
            <dl class="secitem secitem_fist">
                <dt class="fl">区域：</dt>
                <!--选中状态类名为select-->
                <dd>
                    <a href="" class="select">不限</a>
                    <a href="">梁溪区</a>
                    <a href="">滨湖区</a>
                    <a href="">惠山区</a>
                    <a href="">锡山区</a>
                    <a href="">新吴区</a>
                    <a href="">江阴市</a>
                    <a href="">宜兴市</a>
                </dd>
            </dl>
            <!-- 租金 -->
            <dl id="secitem-rent" class="secitem clearfix">
                <dt class="fl">租金：</dt>
                <dd class="fl" style="width:1090px;">
                    <a href="">不限</a>
                    <a href="">500元以下</a>
                    <a href="">500-1000元</a>
                    <a href="">1000-1500元</a>
                    <a href="">1500-2000元</a>
                    <a href="">2000-3000元</a>
                    <a href="">3000-4500元</a>
                    <a href="">4500元以上</a>
                    <span class="prifilter">
	                        <span class="text pri-int">
	                            <input type="text" para="minprice" muti="1" min="0" max="999999" name="b_q"
                                       autocomplete="off">
	                        </span>
	                        <span class="dev"> - </span>
	                        <span class="text pri-int">
	                            <input type="text" para="minprice" muti="1" min="0" max="999999" name="b_q"
                                       autocomplete="off">
	                        </span>
	                        <span class="dev">元</span>
	                        <span class="shaixuanbtn none">
	                            <a rel="nofollow" href="">价格筛选</a>
	                        </span>
	                    </span>
                </dd>
            </dl>
            <!-- 厅室 -->
            <dl class="secitem clearfix">
                <dt class="fl">厅室：</dt>
                <dd class="fl" id="secitem-room">
                    <a rel="nofollow" href="">不限</a>
                    <a rel="nofollow" href="">一室</a>
                    <a rel="nofollow" href="">两室</a>
                    <a rel="nofollow" href="">三室</a>
                    <a rel="nofollow" href="">四室</a>
                    <a rel="nofollow" href="">四室以上</a>
                </dd>
            </dl>
            <!-- 方式 -->
            <dl class="secitem clearfix">
                <dt class="fl">方式：</dt>
                <dd class="fl" id="secitem-type">
                    <a rel="nofollow" href="">不限</a>
                    <a rel="nofollow" href="">整套出租</a>
                    <a rel="nofollow" href="">单间出租</a>
                </dd>
            </dl>
            <!-- 其他 -->
            <dl class="secitem clearfix">
                <dt class="fl">其他：</dt>
                <dd class="fl" id="secitem-other">
                    <div class="moniselectcon">
                        <div class="moniselect"><i></i>朝向不限</div>
                        <div id="secitem-direction" class="moniselectList selectlist01">
                            <a href="" class="select">朝向不限</a>
                            <a href="">东</a>
                            <a href="">南</a>
                            <a href="">西</a>
                            <a href="">北</a>
                            <a href="">南北</a>
                            <a href="">东西</a>
                            <a href="">东南</a>
                            <a href="">西南</a>
                            <a href="">东北</a>
                            <a href="">西北</a>
                        </div>
                    </div><!-- moniselectcon -->
                    <div class="moniselectcon">
                        <div class="moniselect"><i></i> 装修不限</div>
                        <div id="secitem-decoration" class="moniselectList selectlist02">
                            <a href="" class="select">装修不限</a>
                            <a href=""><i></i>毛坯</a>
                            <a href=""><i></i>简单装修</a>
                            <a href=""><i></i>中等装修</a>
                            <a href=""><i></i>精装修</a>
                            <a href=""><i></i>豪华装修</a>
                        </div>
                    </div><!-- moniselectcon -->
                    <span id="secitem-has-pic" class="checkbox">
			                <a class="unchecked" href="javascript:;" name="" value="" id="ispic"><!-- 未选中类名为：unchecked;选中类名为：checked -->
			                    <label for="ispic">只看有图</label>
			                </a>
			            </span>
                </dd>
            </dl>
        </div>
    </div>

    <div class="top-l-line"></div>

    <div class="content">
        <div class="listTitle">
            <ul class="search-hd-ul clearfix">
                <!--选中状态类名为actived-->
                <li class="fl actived">
                    <a href="">厦门出租</a>
                </li>
                <li class="fl">
                    <a href="">经纪人</a>
                </li>
                <li class="fl">
                    <a href="">热租房源</a>
                </li>
                <li class="fl">
                    <a href="">品牌公寓</a>
                </li>
            </ul>
        </div>
        <div class="listBox">
            <ul class="listUl">
            <#list houseList as house>
                <li class="">
                    <div class="img_list">
                        <a href="" target="_blank">
                            <img src="${house.firstImages}">
                        </a>
                        <span class="picNum">8 图</span>
                    </div>
                    <div class="des">
                        <h2>
                            <a href="" target="_blank">整租 | ${house.title}</a>
                            <em class="xinico"></em>
                        </h2>
                        <p class="room">${house.roomNumber}室${house.hallNumber}厅${house.toiletNumber}卫&nbsp;&nbsp;&nbsp;&nbsp;${house.size}㎡</p>
                        <p class="add"><a href="">${house.county}</a>&nbsp;&nbsp;${house.area}</p>
                        <div class="jjr">来自经纪人：
                            <span class=" jjr_par">
			                        <span class="listjjr">
			                            <a href="javascript:;">${house.agentName}</a>
			                        </span>
			                    </span>
                        </div>
                    </div>
                    <div class="listliright">
                        <div class="sendTime">今天</div>
                        <div class="money clearfix"><span class="fr"><b>${house.price?c}</b>元/月</span></div>
                    </div>
                </li>
            </#list>
            <#--<li class="">-->
            <#--<div class="img_list">-->
            <#--<a href="" target="_blank">-->
            <#--<img src="">-->
            <#--</a>-->
            <#--<span class="picNum">8 图</span>-->
            <#--</div>-->
            <#--<div class="des">-->
            <#--<h2>-->
            <#--<a href="" target="_blank">整租 | 鼎瑞 润柏复式全新家具家电配齐单身公寓仅租500元</a>-->
            <#--<em class="xinico"></em>-->
            <#--</h2>-->
            <#--<p class="room">1室0厅1卫&nbsp;&nbsp;&nbsp;&nbsp;61㎡</p>-->
            <#--<p class="add"><a href="">洛江</a>&nbsp;&nbsp;洛江润柏大都会</p>-->
            <#--<div class="jjr">来自经纪人：-->
            <#--<span class=" jjr_par">-->
            <#--<span class="listjjr">-->
            <#--<a href="javascript:;">vrdnq_p3</a>-->
            <#--</span>-->
            <#--</span>-->
            <#--</div>-->
            <#--</div>-->
            <#--<div class="listliright">-->
            <#--<div class="sendTime">今天</div>-->
            <#--<div class="money clearfix"><span class="fr"><b>1500</b>元/月</span></div>-->
            <#--</div>-->
            <#--</li>-->
            <#--<li class="">-->
            <#--<div class="img_list">-->
            <#--<a href="" target="_blank">-->
            <#--<img src="">-->
            <#--</a>-->
            <#--<span class="picNum">8 图</span>-->
            <#--</div>-->
            <#--<div class="des">-->
            <#--<h2>-->
            <#--<a href="" target="_blank">整租 | 鼎瑞 润柏复式全新家具家电配齐单身公寓仅租500元</a>-->
            <#--<em class="xinico"></em>-->
            <#--</h2>-->
            <#--<p class="room">1室0厅1卫&nbsp;&nbsp;&nbsp;&nbsp;61㎡</p>-->
            <#--<p class="add"><a href="">洛江</a>&nbsp;&nbsp;洛江润柏大都会</p>-->
            <#--<div class="jjr">来自经纪人：-->
            <#--<span class=" jjr_par">-->
            <#--<span class="listjjr">-->
            <#--<a href="javascript:;">vrdnq_p3</a>-->
            <#--</span>-->
            <#--</span>-->
            <#--</div>-->
            <#--</div>-->
            <#--<div class="listliright">-->
            <#--<div class="sendTime">今天</div>-->
            <#--<div class="money clearfix"><span class="fr"><b>1500</b>元/月</span></div>-->
            <#--</div>-->
            <#--</li>-->
            </ul>
        </div>
    </div>
</div>
</body>
<script src="${absoluteContextPath}/js/public.js"></script>
<script>
    $(function () {

        //填写筛选条件；显示筛选按钮
        $('.pri-int input').focus(function () {//输入框聚焦时显示按钮
            $('.shaixuanbtn').show();
        });
        $('.pri-int input').blur(function () {//输入框失焦时，当输入框val为空隐藏按钮
            if ($('.pri-int').eq(0).find('input').val() == '' && $('.pri-int').eq(1).find('input').val() == '') {
                $('.shaixuanbtn').hide();
            }
            ;
        });
    })
</script>
</html>