<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增房源</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/select2.css">
    <script>
        window.UEDITOR_HOME_URL = "${absoluteContextPath}/ueditor/";
    </script>
    <script src="${absoluteContextPath}/js/jquery.js"></script>
    <script type="text/javascript" charset="utf-8" src="${absoluteContextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${absoluteContextPath}/ueditor/ueditor.all.min.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${absoluteContextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div {
            width: 100%;
        }

        label.error {
            color: red;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="permissions">
    <div class="con">
        <div class="con-head">
            <div>
                <span>位置：</span>
                <ul>
                    <li>房源模块</li>
                    <li>></li>
                    <li>新增房源</li>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="nav clearfix">
                <h2>新增房源</h2>
            </div>
            <div class="content">
                <div class="entry-inf" style="height: auto;padding-bottom:100px;">
                    <form id="add_form">
                        <div class="ent-information sin-change">
                            <ul>
                                <li class="ent-inf1">
                                    <div class="inf-i1">
                                        <span>标题：</span>
                                        <input type="text" placeholder="输入标题" required=true name="title"
                                               style="width: 575px"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>房子面积：</span>
                                        <input type="text" required digits=true placeholder="输入房子面积" name="size"/>
                                    </div>
                                    <div>
                                        <span>厅室：</span>
                                        <select name="roomNumber">
                                            <option value="1">1室</option>
                                            <option value="2">2室</option>
                                            <option value="3">3室</option>
                                            <option value="4">4室</option>
                                            <option value="5">5室</option>
                                        </select>
                                        <select name="hallNumber">
                                            <option value="0">0厅</option>
                                            <option value="1">1厅</option>
                                            <option value="2">2厅</option>
                                            <option value="3">3厅</option>
                                        </select>
                                        <select name="toiletNumber">
                                            <option value="0">0卫</option>
                                            <option value="1">1卫</option>
                                            <option value="2">2卫</option>
                                            <option value="3">3卫</option>
                                        </select>
                                    </div>
                                    <div>
                                        <span>房子类型：</span>
                                        <select name="msgFromType">
                                        <#list houseTypeEnum as houseType>
                                            <option value="0">${houseType.desc}</option>
                                        </#list>
                                        </select>
                                    </div>
                                    <div>
                                        <span>经纪人姓名：</span>
                                        <input name="agentName" required="true" type="text" placeholder="输入姓名"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>经纪人电话：</span>
                                        <input name="agentPhone" required range="100000,99999999999"
                                               data-msg-range="请输入正确的电话号码" type="text"
                                               placeholder="输入电话号码"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>付款形式：</span>
                                        <input name="priceType" required type="text" value="押一付一"
                                               placeholder="押一付一"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>价格：</span>
                                        <input type="text" name="price" required digits placeholder="输入价格"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>装修级别：</span>
                                        <select name="fixtureLevel">
                                            <option value="0">精装修</option>
                                            <option value="1">简单装修</option>
                                            <option value="2">未装修</option>
                                        </select>
                                    </div>
                                    <div>
                                        <span>所在地：</span>
                                        <select id="loc_province" style="width: 150px">
                                        </select>
                                        <select id="loc_city" style="width: 150px">
                                        </select>
                                        <select id="loc_town" style="width: 150px">
                                        </select>
                                    </div>
                                    <div>
                                        <span>详细地址：</span>
                                        <input name="address" type="text" required placeholder="输入详细地址"/>
                                    </div>
                                </li>
                                <li class="ent-inf2 clearfix">
                                    <div>
                                        <h1>房源描述</h1>
                                        <script id="editor" type="text/plain"
                                                style="width:730px;height:500px;"></script>
                                    </div>
                                </li>

                                <li class="rel-pic-box clearfix" style="width:712px;">
                                    <h2 class="rel-b-title">
                                        输入帖子内容<span>(最多只能上传9张图片，支持JPG、PNG、GIF格式，上传单个文件最大不能超过10M。)</span>
                                    </h2>
                                    <div class="rel-pic-up clearfix">
                                        <div id="upload">
                                        </div>
                                    </div>
                                </li>
                            </ul>

                            <p class="memadd-btn">新增</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="sure-reset">
        <div class="sure-inf">
            <div class="reset-top">
                <h2>提示信息</h2>
                <span class="close_img"></span>
            </div>
            <div class="reset-con reset-sav">
                <dl class="clearfix">
                    <dt class="fl"><img src="${absoluteContextPath}/images/demoimg/save-bg.png" alt="重置"></dt>
                    <dd class="fl">该项信息已修改，是否保存？</dd>
                </dl>
                <p>
                    <span>是</span>
                    <strong>否</strong>
                </p>
            </div>
        </div>
    </div>
    <div class="sorry">
        <div class="sure-inf">
            <div class="reset-top">
                <h2>提示信息</h2>
                <span class="close_img"></span>
            </div>
            <div class="reset-con reset-sav">
                <dl class="clearfix">
                    <dt class="fl"><img src="${absoluteContextPath}/images/demoimg/save-bg.png" alt="重置"></dt>
                    <dd class="fl">添加成功,即将调整</dd>
                </dl>
                <p>
                    <span>确认</span>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
<!--上传依赖-->
<link rel="stylesheet" type="text/css" href="${absoluteContextPath}/dist/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="${absoluteContextPath}/dist/css/diyUpload.css">
<script type="text/javascript" src="${absoluteContextPath}/dist/lib/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/dist/lib/diyUpload.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/common.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/area_select/area.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/area_select/location.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/pinyin.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/select2.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/select2_locale_zh-CN.js"></script>


<!--上传依赖-->
<script>
    $('#upload').diyUpload({
        // url:'server/fileupload.php',
        success: function (data) {
            console.info(data);
        },
        error: function (err) {
            console.info(err);
        }
    });
    $(function () {
        //删除提示
        $('.td-delete-btn').click(function () {
            $('.sure-reset').fadeIn();
        })
        //关闭提示
        $('.td-close-btn').click(function () {
            $('.sure-reset').fadeOut();
        })
        $('.menu-left').find('a').click(function () {
            $('.menu-left li').removeClass('menu-show');
            $(this).parent().addClass('menu-show');
        });

        $(".close_img").click(function () {
            $(this).parent().parent().parent().toggle();
        });
        $("#add_form").validate({
            submitHandler: function (form) {
                var data = $("#add_form").serializeObject();     //序列化表单数据
                var content = ue.getContent();
                if (content.trim() === "") {
                    alert("请填写房源描述内容");
                    return;
                }
                var province = $("#loc_province option:selected").text();
                var city = $("#loc_city option:selected").text();
                var area = $("#loc_town option:selected").text();
                data.description = content;
                data.editorValue = null;
                data.city = city;
                data.county = area;
                data.province = province;
                var $img_arr = $(".viewThumb");
                var images = [];
                $.each($img_arr, function (i) {
                    var src = $(this).find("img").attr("src").replace("data:image/jpeg;base64,", "");
                    var fileName = $(this).next().next().next().html();
                    images.push(fileName + "#" + src);
                });
                data.images = images;
                //这里是jquery表单验证通过的时候执行的操作，比如这里，表单验证通过的时候执行了jquery的ajax的post操作
                $.post('${absoluteContextPath}/admin/renthouse/editHouse', data, function (d) {
                    alert("保存成功");
                    window.location.href = "${absoluteContextPath}/admin/renthouse";
                });
            }
        });
        $(".memadd-btn").click(function () {
            $("#add_form").submit();
        });

        showLocation();
        $('#btnval').click(function () {
            alert($('#loc_province').val() + ' - ' + $('#loc_city').val() + ' - ' + $('#loc_town').val())
        })
        $('#btntext').click(function () {
            alert($('#loc_province').select2('data').text + ' - ' + $('#loc_city').select2('data').text + ' - ' + $('#loc_town').select2('data').text)
        })
    });

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
</script>
</html>