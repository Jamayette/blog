<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>article - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-list">

            <div class="entry-item__header">
                <h1>#article</h1>
            </div>

            <!--<div class="entry-list__year">-->
            <!--<span>*</span><strong>2017</strong>-->
            <!--</div>-->

            <ul class="entry-list__list">
                <#if articleList??>
                    <#list articleList as article>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/article/${article.name}" class="link">
                                <strong class="title">${article.title}</strong>
                            </a>
                            <span>- ${article.createTime?date}</span>
                        </li>
                    </#list>
                </#if>
            </ul>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</body>
</html>
