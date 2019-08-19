<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>publish some life - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/life/create/submit" method="POST">
        <input type="text" name="name" placeholder="path" size="60"/>
        <input type="text" name="title" placeholder="title" size="60"/>
        <textarea id="content" name="content" cols="20" rows="2" class="ckeditor"></textarea>
        <input type="text" name="createTime" placeholder="date(1994/10/26)"/>
        <button type="submit">Submit</button>
    </form>
</body>

</html>
