<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
    <script src="${absoluteContextPath}/js/jquery.js"></script>
    <style type="text/css">
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
                <form id="add_form">
                    <div class="entry-inf">
                        <div class="ent-information sin-change">
                            <ul>
                                <li class="ent-inf1">
                                    <div class="inf-i1">
                                        <span>登录账号：</span>
                                        <input type="text" name="userName" required
                                               data-msg-remote="该账号已被注册"
                                               remote="${absoluteContextPath}/admin/users/usernameNotExist"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>电话：</span>
                                        <input type="text" name="telphone" required data-msg-remote="该电话已被使用"
                                               range="100000,99999999999"
                                               data-msg-range="请输入正确的电话号码"
                                               remote="${absoluteContextPath}/admin/users/telPhoneNotExist"/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>密码：</span>
                                        <input id="password" name="password" type="password" minlength="6"
                                               data-msg-minlength="密码必须大于等于6位" required/>
                                    </div>
                                    <div class="inf-i1">
                                        <span>确认密码：</span>
                                        <input type="password" required data-msg-equalTo="两次输入的密码不相同" required
                                               equalTo="#password"/>
                                    </div>
                                    <div>
                                        <span>绑定邮箱：</span>
                                        <input type="text" name="email" required email="true"/>
                                    </div>
                                    <div>
                                        <span>姓名：</span>
                                        <input type="text" name="realName" required/>
                                    </div>
                                </li>
                                <li class="ent-inf2 clearfix">
                                    <div>
                                        <span>性别：</span>
                                        <input type="radio" name="sex" value="0" checked>男
                                        <input type="radio" name="sex" value="1">女
                                    </div>
                                </li>
                                <li class="ent-inf2 clearfix">
                                    <div>
                                        <span>用户角色：</span>
                                        <select name="roleId">
                                            <option value="1">管理员</option>
                                            <option value="2">普通用户</option>
                                        </select>
                                    </div>
                                </li>

                                <li class="ent-inf2 clearfix">
                                    <div>
                                        <span>备注信息：</span>
                                        <textarea name="remark"></textarea>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <p class="memadd-btn">保存</p>
                    </div>
                </form>
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
<script type="text/javascript" src="${absoluteContextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/common.js"></script>
<script>
    $(function () {
        $('.memadd-btn').click(function () {
            $('.sure-reset').show();
        })
        $('.menu-left').find('a').click(function () {
            $('.menu-left li').removeClass('menu-show');
            $(this).parent().addClass('menu-show');
        });

        $("#add_form").validate({
            submitHandler: function (form) {
                var data = $("#add_form").serializeObject();      //序列化表单数据
                //这里是jquery表单验证通过的时候执行的操作，比如这里，表单验证通过的时候执行了jquery的ajax的post操作
                $.post('${absoluteContextPath}/admin/users/edit', data, function (result) {
                    alert(result);
                    if (result === "success") {
                        alert("添加成功");
                        window.location.href = "${absoluteContextPath}/admin/users";
                    }
                });

            }
        });
        $(".memadd-btn").click(function () {
            $("#add_form").submit();
        });
    })
</script>
</html>