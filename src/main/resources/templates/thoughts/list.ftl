<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>thoughts - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-list">

            <div class="entry-item__header">
                <h1>#thoughts</h1>
            </div>

            <ul class="entry-list__list">
                <#if thoughtsList??>
                    <#list thoughtsList as thoughts>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/thoughts/${thoughts.name}" class="link">
                                <strong class="title">${thoughts.title}</strong>
                            </a>
                            <span>- ${thoughts.createTime?date}</span>
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
