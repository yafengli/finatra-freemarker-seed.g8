<#include "layout/boot.ftl"/>
<@layout "This is title!" "_home">
<div class="row">
    <div class="col-sm-12 alert alert-primary" role="alert">
        <h1>${name!"Not SET Name!"}</h1>
    </div>
    <div class="col-sm-12 alert alert-info" role="alert">
        <ul>
            <#list persons as t>
                <li>${t.name}|${t.age}</li>
            </#list>
        </ul>
    </div>
    <div class="col-sm-12">
        <form action="/upload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="_file">上传文件</label>
                <input id="_file" type="file" name="file" placeholder="上传文件" class="form-control" aria-describedby="_file_help"/>
                <small id="_file_help" class="form-text text-muted">You must chose one file to upload.</small>
            </div>
            <div class="form-group">
                <label for="_name">下载文件名</label>
                <input id="_name" type="text" name="name" placeholder="下载文件名" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">提交</button>
        </form>
    </div>
</div>
</@layout>