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
    <link href="${absoluteContextPath}/H-ui-admin/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<!--/meta 作为公共模版分离出去-->

<title>新增房产 - 房产管理</title>
</head>

<body>
<article class="page-container">
	<form class="form form-horizontal" id="add_form">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>房产标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""  name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">房子面积：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder=""  name="size">
			</div>
		</div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>厅室：</label>

            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box inline">
					  <select name="roomNumber" class="select">
                          <option value="1">1室</option>
                          <option value="2">2室</option>
                          <option value="3">3室</option>
                          <option value="4">4室</option>
                          <option value="5">5室</option>
                      </select>
						<select name="hallNumber" class="select">
                        <option value="0">0厅</option>
                        <option value="1">1厅</option>
                        <option value="2">2厅</option>
                        <option value="3">3厅</option>
                    </select>
					 <select name="toiletNumber" class="select">
                         <option value="0">0卫</option>
                         <option value="1">1卫</option>
                         <option value="2">2卫</option>
                         <option value="3">3卫</option>
                     </select>
				</span>
            </div>

        </div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>房子类型：</label>

			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					 <select name="msgFromType" class="select">
						 <#list houseTypeEnum as houseType>
							 <option value="0">${houseType.desc}</option>
						 </#list>
                     </select>
				</span>
			</div>

		</div>


	<!-- 	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>文章类型：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
			<select name="articletype" class="select">
				<option value="0">全部类型</option>
				<option value="1">帮助说明</option>
				<option value="2">新闻资讯</option>
			</select>
			</span> </div>
	</div> -->
<!-- 		<div class="row cl">
	<label class="form-label col-xs-4 col-sm-2">排序值：</label>
	<div class="formControls col-xs-8 col-sm-9">
		<input type="text" class="input-text" value="0" placeholder="" id="articlesort" name="articlesort">
	</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">经纪人姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" name="agentName">
			</div>
		</div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">经纪人电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="agentPhone" class="input-text" required data-msg-remote="该电话已被使用"
                       range="100000,99999999999"
                       data-msg-range="请输入正确的电话号码"
                       remote="${absoluteContextPath}/admin/users/telPhoneNotExist"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">付款形式：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input class="input-text" name="priceType" required type="text" value="押一付一"
                       placeholder="押一付一">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text"  class="input-text" name="price" required digits placeholder="输入价格">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>装修级别：</label>

            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select name="fixtureLevel" class="select">
                        <option value="0">精装修</option>
                        <option value="1">简单装修</option>
                        <option value="2">未装修</option>
                    </select>
				</span>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所在地：</label>

            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select id="loc_province" class="select">
                    </select>
					<select id="loc_city" class="select">
                    </select>
					<select name=id="loc_town" class="select">
                    </select>
				</span>

            </div>
        </div>

        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="address" class="input-text" type="text" required placeholder="输入详细地址">
			</div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">房源描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
            </div>
        </div>


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">图片上传：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <div class="uploader-list-container">
                    <div class="queueList">
                        <div id="dndArea" class="placeholder">
                            <div id="filePicker-2"></div>
                            <p>或将照片拖到这里，单次最多可选300张</p>
                        </div>
                    </div>
                    <div class="statusBar" style="display:none;">
                        <div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
                        <div class="info"></div>
                        <div class="btns">
                            <div id="filePicker2"></div>
                            <div class="uploadBtn">开始上传</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 新增</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>

			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>


<script type="text/javascript" src="${absoluteContextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/common.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/area_select/area.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/area_select/location.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/pinyin.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/select2.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/select2_locale_zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
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
	//表单验证
/*	$("#form-article-add").validate({
		rules:{
			articletitle:{
				required:true,
			},
			articletitle2:{
				required:true,
			},
			articlecolumn:{
				required:true,
			},
			articletype:{
				required:true,
			},
			articlesort:{
				required:true,
			},
			keywords:{
				required:true,
			},
			abstract:{
				required:true,
			},
			author:{
				required:true,
			},
			sources:{
				required:true,
			},
			allowcomments:{
				required:true,
			},
			commentdatemin:{
				required:true,
			},
			commentdatemax:{
				required:true,
			},

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
	});*/
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

	var uploader = WebUploader.create({
		auto: true,
		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
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
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>