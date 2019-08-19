<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>life - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-list">

            <div class="entry-item__header">
                <h1>#life</h1>
            </div>

            <ul class="entry-list__list">
                <#if lifeList??>
                    <#list lifeList as life>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/life/${life.name}" class="link">
                                <strong class="title">${life.title}</strong>
                            </a>
                            <span>- ${life.createTime?date}</span>
                        </li>
                    </#list>
                </#if>
            </ul>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</html>
