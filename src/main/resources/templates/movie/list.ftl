<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>movie - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-list">

            <div class="entry-list__category">
                <span>#</span><strong>movie</strong>
            </div>

            <ul class="entry-list__list">
                <#if movieList??>
                    <#list movieList as movie>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/movie/${movie.name}" class="link">
                                <strong class="title">${movie.title}</strong>
                            </a>
                            <span>- ${movie.onYear}</span>
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
