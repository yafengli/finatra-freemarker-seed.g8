<#macro layout title menu>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>\${title!"NOT SET title"}</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 alert alert-primary">
            <h1>\${menu!"not set menu"}</h1>
        </div>
    </div>
    <#nested />
</div>
</body>
</html>
</#macro>