<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
    <script src="../js/jquery.js"></script>
</head>
<body>
<div class="menu-left">
    <div class="menu-1">
        <h2>
            <b><img src="${absoluteContextPath}/images/icon/menu1.png" alt=""></b>
            <span>用户模块</span>
        </h2>
        <ul>
            <li>
                <b></b>
                <a href="${absoluteContextPath}/admin/users" title="用户列表" target="main_right">用户列表</a>
            </li>
            <li>
                <b></b>
                <a href="${absoluteContextPath}/admin/users/edit" title="添加用户" target="main_right">添加用户</a>
            </li>
        </ul>
    </div>
    <div class="menu-1">
        <h2>
            <b><img src="${absoluteContextPath}/images/icon/save1.png" alt="房源模块"></b>
            <span>房源模块</span>
        </h2>
        <ul>
            <li class="menu-show">
                <b></b>
                <a href="${absoluteContextPath}/admin/renthouse" title="房源列表" target="main_right">房源列表</a>
            </li>
            <li>
                <b></b>
                <a href="${absoluteContextPath}/admin/renthouse/releaseHouse" title="新增房源" target="main_right">新增房源</a>
            </li>
        </ul>
    </div>
</div>
</body>
<script>
    $('.menu-left').find('a').click(function () {
        $('.menu-left li').removeClass('menu-show');
        $(this).parent().addClass('menu-show');
    })
</script>
</html>