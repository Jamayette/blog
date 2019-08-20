<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>subject - Jamayette</title>

<#include "/common/header.ftl"/>

<div class="layout-container">
    <div class="container">
        <div class="entry-item">

            <div class="entry-item__header">
                <h1>#subject</h1>
            </div>

            <ul class="subject-list">
                <#if subjectList??>
                    <#list subjectList as subject>
                        <li class="book-list__item">
                            <div class="image">
                                <a href="${subject.introUrl}" target=_blank>
                                    <img src="${subject.imgUrl}" alt="title">
                                </a>
                            </div>
                            <div class="info">
                                <h2 class="title"><a href="${subject.introUrl}" target=_blank>${subject.title}</a></h2>
                                <h3 class="author">${subject.author}</h3>
                                <p class="comment">${subject.comment}</p>
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
