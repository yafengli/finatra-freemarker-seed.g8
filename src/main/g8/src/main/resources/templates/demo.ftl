<#include "layout/boot.ftl"/>
<@layout "This is title!" "_home">
<h1>\${name!"Not SET Name!"}</h1>
<ul>
    <#list persons as t>
        <li>\${t.name}|\${t.age}\</li>
    </#list>
</ul>

<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" placeholder="上传文件"/>
    <input type="text" name="name" placeholder="下载文件名"/>
    <input type="submit" value="提交"/>
</form>
</@layout>