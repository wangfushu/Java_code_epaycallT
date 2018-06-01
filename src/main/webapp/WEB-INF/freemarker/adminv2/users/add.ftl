<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/H-ui-admin/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/H-ui-admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/css/style.css" />
    <!--/meta 作为公共模版分离出去-->

    <title>添加用户</title>
</head>
<body>
<article class="page-container">
    <form id="add_form" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>登录账号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="userName" class="input-text" required
                       data-msg-remote="该账号已被注册"
                       remote="${absoluteContextPath}/admin/users/usernameNotExist"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <input type="text" name="telphone" class="input-text" required data-msg-remote="该电话已被使用"
                       range="100000,99999999999"
                       data-msg-range="请输入正确的电话号码"
                       remote="${absoluteContextPath}/admin/users/telPhoneNotExist"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <input id="password" name="password" class="input-text" type="password" minlength="6"
                       data-msg-minlength="密码必须大于等于6位" required/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>确认密码：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <input type="password"  class="input-text" required data-msg-equalTo="两次输入的密码不相同" required
                       equalTo="#password"/>
            </div>
        </div>
  <#--      <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="mobile" name="mobile">
            </div>
        </div>-->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>绑定邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="@" name="email" id="email">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="realName" required/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input name="sex" value="0" type="radio" id="sex-0" checked>
                    <label for="sex-0">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-1" name="sex" value="1">
                    <label for="sex-1">女</label>
                </div>
            </div>
        </div>


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">用户角色：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				   <select name="roleId" class="select">
                       <option value="1">管理员</option>
                       <option value="2">普通用户</option>
                   </select>
				</span> </div>
        </div>
    <#--    <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">附件：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file-2" class="input-file">
				</span> </div>
        </div>-->
     <#--   <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">所在城市：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="city">
                    <option value="" selected>请选择城市</option>
                    <option value="1">北京</option>
                    <option value="2">上海</option>
                    <option value="3">广州</option>
                </select>
				</span> </div>
        </div>-->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">备注信息：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
        </div>
        <div class="row cl">
            <div class="formControls col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
/*        $("#add_form").validate({
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
        });*/
      $("#add_form").validate({
            rules:{
/*                username:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },*/
                sex:{
                    required:true,
                },
/*                mobile:{
                    required:true,
                    isMobile:true,
                },*/
                email:{
                    required:true,
                    email:true,
                },
/*                uploadfile:{
                    required:true,
                },*/

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                //parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>