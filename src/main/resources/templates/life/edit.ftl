<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit life - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/life/edit/submit" method="POST">
        <input type="hidden" name="id" value="${life.id?c}">
        <input type="text" name="title" value="${life.title}" placeholder="title" size="60"/>
        <input type="text" name="name" value="${life.name}" placeholder="path" size="60"/>
        <textarea id="content" name="content" cols="20" rows="2" class="ckeditor">${life.content}</textarea>
        <input type="text" name="createTime" value="${life.createTime?string('yyyy/MM/dd')}" placeholder="date(1994/10/26)"/>
        <button type="submit">Submit</button>
    </form>
</body>

</html>
