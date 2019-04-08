<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>${article.title} - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-item">

            <div class="entry-item__header">
                <h1>${article.title}</h1>
                <div class="date">
                    <sup data-hash="${article.createTime?date}">${article.createTime?date}</sup>
                </div>
            </div>

            <div class="entry-item__container">
                <div class="typo">${article.content}</div>
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

</body>
</html>
