<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>所有用户</title>


    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
    <script src="${absoluteContextPath}/js/jquery.js"></script>
<#--<link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/tcal.css"/>-->
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/jquery.dataTables.min.css"/>
    <script type="text/javascript" src="${absoluteContextPath}/js/index.js"></script>
<#--<script type="text/javascript" src="${absoluteContextPath}/js/tcal.js"></script>-->
<#--    <script type="text/javascript" src="${absoluteContextPath}/js/select2.js"></script>
    <link rel="stylesheet" href="${absoluteContextPath}/css/select2.css">-->
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/jquery-easyui-1.5.2/themes/icon.css">
    <script type="text/javascript" src="${absoluteContextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/layer/layer.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/layer/mobile/need/layer.css"></script>
</head>
<body>
<div class="permissions">
    <div class="con">
        <div class="con-head">
            <div>
                <span>位置：</span>
                <ul>
                    <li>用户模块</li>
                    <li>></li>
                    <li>所有用户</li>
                </ul>
            </div>
            <div class="membernum">
                用户总数：<strong>${allUsers?size}</strong>
            </div>
        </div>

        <div class="content">
            <div class="nav clearfix">
                <h2>用户列表</h2>
                <form name="usersForm" action="${absoluteContextPath}/admin/users" method="post">
                    <div class="member-search search-leng">
                        <div style="border:none;">
                            <span style="font-size: smaller">注册时间：</span><input id="timeFrom" name="timeFrom"
                                                                                class="easyui-datebox"
                                                                                style="width: 100px;"
                                                                                data-options="formatter:myformatter,parser:myparser"/>至
                            <input id="timeTo" name="timeTo" class="easyui-datebox" style="width: 100px;"
                                   data-options="formatter:myformatter,parser:myparser"/>
                        </div>
                        <div class="member-id">

                            <input type="text" id="search" name="searchKey" placeholder="请输入会员名称或注册电话号码"
                                   value="${searchKey!''}"/>

                        </div>
                        <p onclick="document.forms[0].submit();">搜索</p>
                    </div>
                </form>
            </div>

            <div class="member-table">
                <table cellpadding="0" cellspacing="0" id="user_list">
                    <thead>
                    <tr class="list-th">
                        <th>姓名<i></i></th>
                        <th>手机号码<i></i></th>
                        <th>邮箱<i></i></th>
                        <th>注册时间<i></i></th>
                        <th>最近登录<i></i></th>
                        <th>备注信息<i></i></th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list allUsers as users>
                    <tr>
                        <td>${users.userName!''}</td>
                        <td>${users.telphone!''}</td>
                        <td>${users.email!''}</td>
                        <td>
                            <strong>${users.gmtCreate!''}</strong></td>
                        <td>
                            <strong>${users.lastLoginTime!''}</strong>
                        </td>
                        <td>${users.remark!''}</td>
                        <td>
                            <a href="${absoluteContextPath}/admin/users/alter/${users.id}" title="个人信息"
                               target="main_right">查看/编辑</a>
                        </td>
                    </tr>

                    </#list>


                    </tbody>
                </table>


            </div>
        </div>
    </div>
</div>


<script>

    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }


</script>
</body>
<script>
    $(function () {


        $("#timeFrom").datebox("setValue", "${timeFrom!''}");
        $("#timeTo").datebox("setValue", "${timeTo!''}");

        $('.td-delete-btn').click(function () {
            $('.inf-change').fadeIn();
        });
        //关闭提示
        $('.td-close-btn').click(function () {
            $('.inf-change').fadeOut();
        });

        $('#user_list').DataTable({
            "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
            "sDom": "<'row-fluid inboxHeader'<'span6'<'dt_actions'>l><'span6'f>r>t<'row-fluid inboxFooter'<'span6'i><'span6'p>>", //待补充
            "iDisplayLength": 10,//每页显示10条数据
            "bAutoWidth": true,//宽度是否自动，感觉不好使的时候关掉试试
            "bLengthChange": false,
            "bFilter": false,

            "oLanguage": {//下面是一些汉语翻译
                "sSearch": "搜索",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "没有检索到数据",
                "sInfo": "显示 _START_ 至 _END_ 条 &nbsp;&nbsp;共 _TOTAL_ 条",
                "sInfoFiltered": "(筛选自 _MAX_ 条数据)",
                "sInfoEmtpy": "没有数据",
                "sProcessing": "正在加载数据...",
                "sProcessing": "<img src='{{rootUrl}}global/img/ajaxLoader/loader01.gif' />", //这里是给服务器发请求后到等待时间显示的 加载gif
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "末页"
                }
            },

        });
    });
    //            "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
    //            "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。
    //            "sAjaxSource": "{{rootUrl}}ace_management/ace_list", //给服务器发请求的url
    //            "aoColumns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
    //                {"mData": 'nickname'}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列
    //                {"mData": 'follower_count'},
    //                {"mData": 'rank'},
    //                {"mData": 'month_count'},
    //                {"mData": 'equity'},
    //                {"mData": 'month_ror'},
    //                {"mData": 'now_orders'},
    //                {"mData": 'profit_total'},
    //                {"sDefaultContent": ''}, // sDefaultContent 如果这一列不需要填充数据用这个属性，值可以不写，起占位作用
    //                {"sDefaultContent": '', "sClass": "action"},//sClass 表示给本列加class
    //            ],
    //            "aoColumnDefs": [//和aoColums类似，但他可以给指定列附近爱属性
    //                {"bSortable": false, "aTargets": [1, 3, 6, 7, 8, 9]},  //这句话意思是第1,3,6,7,8,9列（从0开始算） 不能排序
    //                {"bSearchable": false, "aTargets": [1, 2, 3, 4, 5, 6, 7, 8, 9]}, //bSearchable 这个属性表示是否可以全局搜索，其实在服务器端分页中是没用的
    //            ],
    //            "aaSorting": [[2, "desc"]], //默认排序
    //            "fnRowCallback": function (nRow, aData, iDisplayIndex) {// 当创建了行，但还未绘制到屏幕上的时候调用，通常用于改变行的class风格
    //                if (aData.status == 1) {
    //                    $('td:eq(8)', nRow).html("<span class='text-error'>审核中</span>");
    //                } else if (aData.status == 4) {
    //                    $('td:eq(8)', nRow).html("<span class='text-error'>审核失败</span>");
    //                } else if (aData.active == 0) {
    //                    $('td:eq(8)', nRow).html("<span>隐藏</span>");
    //                } else {
    //                    $('td:eq(8)', nRow).html("<span class='text-success'>显示</span>");
    //                }
    //                $('td:eq(9)', nRow).html("<a href='' user_id='" + aData.user_id + "' class='ace_detail'>详情</a>");
    //                if (aData.status != 1 && aData.status != 4 && aData.active == 0) {
    //                    $("<a class='change_ace_status'>显示</a>").appendTo($('td:eq(9)', nRow));
    //                } else if (aData.status != 1 && aData.status != 4 && aData.active == 1) {
    //                    $("<a class='change_ace_status'>隐藏</a>").appendTo($('td:eq(9)', nRow));
    //                }
    //                return nRow;
    //            },
    //            "fnInitComplete": function (oSettings, json) { //表格初始化完成后调用 在这里和服务器分页没关系可以忽略
    //                $("input[aria-controls='DataTables_Table_0']").attr("placeHolder", "请输入高手用户名");
    //            }
</script>
</html>