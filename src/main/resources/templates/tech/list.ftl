<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>tech - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-list">

            <div class="entry-item__header">
                <h1>#tech</h1>
            </div>

            <!--<div class="entry-list__year">-->
            <!--<span>*</span><strong>2017</strong>-->
            <!--</div>-->

            <ul class="entry-list__list">
                <#if techList??>
                    <#list techList as tech>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/tech/${tech.name}" class="link">
                                <strong class="title">${tech.title}</strong>
                            </a>
                            <span>- ${tech.createTime?date}</span>
                        </li>
                    </#list>
                </#if>
            </ul>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</html>
