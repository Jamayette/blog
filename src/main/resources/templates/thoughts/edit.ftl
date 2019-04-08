<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit thoughts - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/thoughts/edit/submit" method="POST">
        <input type="hidden" name="id" value="${thoughts.id?c}">
        <input type="text" name="title" value="${thoughts.title}" placeholder="title" size="60"/>
        <input type="text" name="name" value="${thoughts.name}" placeholder="path" size="60"/>
        <textarea id="content" name="content" cols="20" rows="2" class="ckeditor">${thoughts.content}</textarea>
        <input type="text" name="createTime" value="${thoughts.createTime?string('yyyy/MM/dd')}" placeholder="date(1994/10/26)"/>
        <button type="submit">Submit</button>
    </form>
</body>

</html>