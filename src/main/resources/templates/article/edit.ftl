<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit article - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/article/edit/submit" method="POST">
        <input name="id" value="${article.id?c}" type="hidden">
        <input type="text" name="title" value="${article.title}" placeholder="title" size="60"/><br/>
        <input type="text" name="name" value="${article.name}" placeholder="path" size="60"/><br/>
        <textarea id="content" name="content" cols="20" rows="2" class="ckeditor">${article.content}</textarea>
        <input type="text" name="createTime" value="${article.createTime?string('yyyy/MM/dd')}"/>
        <button type="submit">Submit</button>
    </form>
</body>

</html>