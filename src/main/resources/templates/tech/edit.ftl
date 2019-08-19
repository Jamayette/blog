<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit tech - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/tech/edit/submit" method="POST">
        <input name="id" value="${tech.id?c}" type="hidden">
        <input type="text" name="title" value="${tech.title}" placeholder="title" size="60"/><br/>
        <input type="text" name="name" value="${tech.name}" placeholder="path" size="60"/><br/>
        <textarea id="content" name="content" cols="20" rows="2" class="ckeditor">${tech.content}</textarea>
        <input type="text" name="createTime" value="${tech.createTime?string('yyyy/MM/dd')}"/>
        <button type="submit">Submit</button>
    </form>
</body>

</html>
