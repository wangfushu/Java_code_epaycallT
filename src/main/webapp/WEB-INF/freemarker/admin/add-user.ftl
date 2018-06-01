<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
    <script src="${absoluteContextPath}/js/jquery.js"></script>
</head>
<body>
<div class="permissions">
    <div class="con">
        <div class="con-head">
            <div>
                <span>位置：</span>
                <ul>
                    <li>用户管理</li>
                    <li>></li>
                    <li>添加用户</li>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="nav clearfix">
                <h2>添加用户</h2>
            </div>
            <div class="content">
                <div class="entry-inf">
                    <div class="ent-information sin-change">
                        <ul>
                            <li class="ent-inf1">
                                <div class="inf-i1">
                                    <i>*</i>
                                    <span>注册电话：</span>
                                    <input type="text"/>
                                    <strong>该号码已经注册！</strong>
                                </div>
                                <div class="inf-i1">
                                    <i>*</i>
                                    <span>密码：</span>
                                    <input type="text"/>
                                </div>
                                <div class="inf-i1">
                                    <i>*</i>
                                    <span>确认密码：</span>
                                    <input type="text"/>
                                </div>
                                <div>
                                    <span>绑定邮箱：</span>
                                    <input type="text"/>
                                </div>
                                <div>
                                    <span>姓名：</span>
                                    <input type="text"/>
                                </div>
                            </li>
                            <li class="ent-inf2 clearfix">
                                <div>
                                    <span>性别：</span>
                                    <input type="radio" name="sex1">男
                                    <input type="radio" name="sex1">女
                                </div>

                            </li>
                            <li class="ent-inf2 clearfix">
                                <div>
                                    <span>生日：</span>
                                    <select>
                                        <option value="">2013</option>
                                        <option value="">2014</option>
                                        <option value="">2015</option>
                                    </select>年
                                    <select>
                                        <option value="">1</option>
                                        <option value="">2</option>
                                        <option value="">3</option>
                                    </select>月
                                    <select>
                                        <option value="">1</option>
                                        <option value="">2</option>
                                        <option value="">3</option>
                                    </select>日
                                </div>
                            </li>
                            <li class="ent-inf2 clearfix">
                                <div>
                                    <span>所在地：</span>
                                    <select>
                                        <option value="">广东省</option>
                                        <option value="">福建省</option>
                                    </select>
                                    <select>
                                        <option value="">深圳市</option>
                                        <option value="">广州市</option>
                                        <option value="">佛山市</option>
                                    </select>
                                    <select>
                                        <option value="">福田区</option>
                                        <option value="">南山区</option>
                                        <option value="">宝安区</option>
                                    </select>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <p class="memadd-btn">保存</p>
                </div>
            </div>
        </div>
    </div>
    <!-- <div class="sure-reset">
        <div class="sure-inf">
            <div class="reset-top">
                <h2>提示信息</h2>
                <span></span>
            </div>
            <div class="reset-con reset-sav">
                <dl class="clearfix">
                    <dt><img src="images/demoimg/save-bg.png" alt="重置"></dt>
                    <dd>该项信息已修改，是否保存？</dd>
                </dl>
                <p>
                    <span>是</span>
                    <strong>否</strong>
                </p>
            </div>
        </div>
    </div> -->
</div>
</body>
<script>
    $(function () {
        $('.memadd-btn').click(function () {
            $('.sure-reset').show();
        })
        $('.menu-left').find('a').click(function () {
            $('.menu-left li').removeClass('menu-show');
            $(this).parent().addClass('menu-show');
        })
    })
</script>
</html>