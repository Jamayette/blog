<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>${tech.title} - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-item">

            <div class="entry-item__header">
                <h1>${tech.title}</h1>
                <div class="date">
                    <sup data-hash="${tech.createTime?date}">${tech.createTime?date}</sup>
                </div>
            </div>

            <div class="entry-item__container">
                <div class="typo">${tech.content}</div>
                <div class="eof">- EOF -</div>
                <#if tagList??>
                    <div class="category">
                        <#list tagList as tag>
                            <a class="c" href="/tag/${tag.name}.html">#${tag.name}</a>
                        </#list>
                    </div>
                </#if>
            </div>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</html>
