<#macro layout title menu>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>${title!"NOT SET title"}</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>${menu!"not set menu"}</h1>
<div class="container-fluid">
    <#nested />
</div>
</body>
</html>
</#macro>