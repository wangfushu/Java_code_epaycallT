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

 <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
 <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/jquery-easyui-1.5.2/themes/icon.css">
 <script type="text/javascript" src="${absoluteContextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
 <script type="text/javascript" src="${absoluteContextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>



<title>房产列表</title>
</head>
<script type="text/javascript"></script>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 房产管理 <span class="c-gray en">&gt;</span> 房产列表 <a id="refreshpage" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<!-- <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button> -->
	<form name="renthouseForm" action="${absoluteContextPath}/admin/renthouse" method="post">
	 <span class="select-box inline">
		<select name="msgFromType" id="msgFromType" class="select">
            <option value="">发布来源</option>
            <option value="0" <#if "${msgFromType!''}"=="0">selected="selected" </#if>>经纪人</option>
            <option value="1" <#if "${msgFromType!''}"=="1">selected="selected" </#if>>个人</option>
		</select>
		</span>
		<span class="select-box inline">
		<select id="userId" name="userId" class="easyui-combobox" style="width:100px;">
            <option value="">请选择</option>
			<#list allUsers as users>
				<option value="${users.id}">${users.userName}</option>
			</#list>
        </select>
		</span>

		日期范围：
        <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'timeTo\')||\'%y-%M-%d\'}' })" id="timeFrom" name="timeFrom" class="input-text Wdate" style="width:120px;" value="${timeFrom!''}">
		-
        <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'timeFrom\')}',maxDate:'%y-%M-%d' })"  id="timeTo" name="timeTo" class="input-text Wdate" style="width:120px;" value="${timeTo!''}">
		<input type="text" name="searchKey" id="search" placeholder=" 请输入经纪人名称或者房源标题" style="width:250px" class="input-text" value="${searchKey!''}">
		<button name="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜房产</button>
    </form>

	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<#--<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>-->
			<a class="btn btn-primary radius" data-title="添加房产" data-href="${absoluteContextPath}/admin/renthouse/releaseHouse" onclick="article_add('添加房产','${absoluteContextPath}/admin/renthouse/releaseHouse')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加房产</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="20">序号</th>
					<th width="220">标题</th>
					<th width="80">出租类型</th>
					<th width="80">大小(㎡)</th>
					<th width="120">厅室</th>
					<th width="75">发布来源</th>
					<th width="60">价格</th>
					<th width="80">经纪人姓名</th>
					<th width="120">经纪人电话</th>
					<th width="120">地区</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
		<#list data as rentHouses>
				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<td>${rentHouses_index+1}</td>
					<td class="text-l">${rentHouses.title!''}</td>
					<td><#if rentHouses.rentType == 1>住宅整租<#else>单租</#if></td>
					<td>${rentHouses.size!''}</td>
					<td>${rentHouses.roomNumber!''} 室 ${rentHouses.hallNumber!''}厅${rentHouses.toiletNumber!''}卫</td>
					<td class="td-status">
						<#if rentHouses.msgFromType == 0><span class="label label-success radius">经纪人房源</span>
						<#else><span class="label label-success radius">个人房源</span></#if>
						</td>
					<td>${rentHouses.price?c!''}/月</td>
					<td>
						<#if (rentHouses.users.id) ??>
                            ${rentHouses.users.userName!''}
                        <#else>
							${rentHouses.agentName!''}
						</#if>
					</td>
					<td>
						<#if (rentHouses.users.id) ??>${rentHouses.users.telphone!''}
                                <#else>${rentHouses.agentPhone!''}</#if>
					</td>
					<td>${rentHouses.address!''}</td>
					<td class="f-14 td-manage">
					 <a style="text-decoration:none" class="ml-5" onClick="article_edit('修改','article-add.html','10001')" href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="house_del(this,${rentHouses.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>

		</#list>
			</tbody>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/H-ui-admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
     "aaSorting": [[ 1, "asc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,2,3,5,6,8,9,10,11]}// 不参与排序的列
	]
});

/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-删除*/
function house_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'GET',
			url: '${absoluteContextPath}/admin/renthouse/delete',
            data:{id : id},
			success: function(data){
				//$(obj).parents("tr").remove();
                document.getElementById("refreshpage").click();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			}
		});

	});
}

/*资讯-审核*//*
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}*/
/*资讯-下架*//*
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}*/

/*资讯-发布*//*
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}*/
/*资讯-申请上线*//*
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}*/

</script> 
</body>
</html>