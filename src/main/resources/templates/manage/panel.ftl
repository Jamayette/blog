<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>management - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">

        <div>
            <a href="/m/article/create">new article</a> /
            <a href="/m/thoughts/create">new thoughts</a> /
            <a href="/m/book/create">new book</a> /
            <a href="/m/movie/create">new movie</a> /
            <a href="/m/message">send message</a>
        </div>

        <hr/>

        <div class="entry-list">

            <div class="entry-list__year"><span>*</span><strong>article</strong></div>
            <ul class="entry-list__list">
                <#if articleList??>
                    <#list articleList as article>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/article/${article.name}" class="link"><strong class="title">${article.title}</strong></a>
                            <span>${article.createTime?date}<span>
                            <a href="/m/article/edit/${article.id?c}" class="link">modify</strong></a> /
                            <a href="/m/article/delete/${article.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

            <div class="entry-list__year"><span>*</span><strong>thoughts</strong></div>
            <ul class="entry-list__list">
                <#if thoughtsList??>
                    <#list thoughtsList as thoughts>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/thoughts/${thoughts.name}" class="link"><strong class="title">${thoughts.title}</strong></a>
                            <span>${thoughts.createTime?date}<span>
                            <a href="/m/thoughts/edit/${thoughts.id?c}" class="link">modify</strong></a> /
                            <a href="/m/thoughts/delete/${thoughts.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

            <div class="entry-list__year"><span>*</span><strong>book</strong></div>
            <ul class="entry-list__list">
                <#if bookList??>
                    <#list bookList as book>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="${book.introUrl}" class="link" target="_blank"><strong class="title">${book.title}</strong></a>
                            <span>${book.publishYear}<span>
                            <a href="/m/book/edit/${book.id?c}" class="link">modify</strong></a> /
                            <a href="/m/book/delete/${book.id?c}" class="link">delete</strong></a>
                        </li>
                    </#list>
                </#if>
            </ul>

            <div class="entry-list__year"><span>*</span><strong>movie</strong></div>
            <ul class="entry-list__list">
                <#if movieList??>
                    <#list movieList as movie>
                        <li class="entry-list__item">
                            <span>- </span>
                            <a href="/" class="link"><strong class="title">${movie.title}</strong></a>
                            <span>${movie.onYear}<span>
                            <a href="/m/movie/edit/${movie.id?c}" class="link">modify</strong></a> /
                            <a href="/m/movie/delete/${movie.id?c}" class="link">delete</strong></a>
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
