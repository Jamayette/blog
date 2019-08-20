<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>management - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">

        <div>
            <a href="/m/tech/create">new tech</a> /
            <a href="/m/life/create">new life</a> /
            <a href="/m/subject/create">new subject</a> /
        </div>

        <hr/>

        <div class="entry-list">

            <div class="entry-list__year"><span>*</span><strong>tech</strong></div>
            <ul class="entry-list__list">
                <#if techList??>
                    <#list techList as tech>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/tech/${tech.name}" class="link"><strong class="title">${tech.title}</strong></a>
                            <span>${tech.createTime?date}<span>
                            <a href="/m/tech/edit/${tech.id?c}" class="link">modify</strong></a> /
                            <a href="/m/tech/delete/${tech.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

            <div class="entry-list__year"><span>*</span><strong>life</strong></div>
            <ul class="entry-list__list">
                <#if lifeList??>
                    <#list lifeList as life>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/life/${life.name}" class="link"><strong class="title">${life.title}</strong></a>
                            <span>${life.createTime?date}<span>
                            <a href="/m/life/edit/${life.id?c}" class="link">modify</strong></a> /
                            <a href="/m/life/delete/${life.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

            <div class="entry-list__year"><span>*</span><strong>subject</strong></div>
            <ul class="entry-list__list">
                <#if subjectList??>
                    <#list subjectList as subject>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="${subject.introUrl}" class="link" target="_blank"><strong class="title">${subject.title}</strong></a>
                            <span>${subject.publishYear}<span>
                            <a href="/m/subject/edit/${subject.id?c}" class="link">modify</strong></a> /
                            <a href="/m/subject/delete/${subject.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</html>
