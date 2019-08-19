<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>book - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-item">

            <div class="entry-item__header">
                <h1>#book</h1>
            </div>

            <ul class="book-list">
                <#if bookList??>
                    <#list bookList as book>
                        <li class="book-list__item">
                            <div class="image">
                                <a href="${book.introUrl}" target=_blank>
                                    <img src="${book.imgUrl}" alt="title">
                                </a>
                            </div>
                            <div class="info">
                                <h2 class="title"><a href="${book.introUrl}" target=_blank>${book.title}</a></h2>
                                <h3 class="author">${book.author}</h3>
                                <p class="comment">${book.comment}</p>
                            </div>
                        </li>
                    </#list>
                </#if>
            </ul>

        </div>
    </div>
</div>

<#include "/common/footer.ftl"/>

</html>
