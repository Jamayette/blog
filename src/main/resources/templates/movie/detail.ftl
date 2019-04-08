<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>${movie.title} / ${movie.artist} / ${movie.onYear} - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-item">

            <div class="entry-item__header">
                <h1>${movie.title} / ${movie.artist} / ${movie.onYear}</h1>
            </div>

            <div class="entry-item__container">
                <div class="typo">${movie.comment}</div>
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
