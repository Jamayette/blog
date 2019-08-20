<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit subject - Jamayette</title>
</head>

<body>
    <form action="/m/subject/edit/submit" method="POST">
        <input type="hidden" name="id" value="${subject.id?c}">
        <input type="text" name="title" value="${subject.title}" placeholder="author" size="46"/><br/>
        <input type="text" name="author" value="${subject.author}" placeholder="author"/>
        <input type="text" name="publishTime" value="${subject.publishYear}" placeholder="publishYear"/><br/>
        <input type="text" name="imgUrl" value="${subject.imgUrl}" placeholder="imgUrl" size="60"/><br>
        <input type="text" name="introUrl" value="${subject.introUrl}" placeholder="introUrl" size="60"/><br>
        <textarea name="comment" rows="24" cols="72"></textarea><br>
        <button type="submit">Submit</button>
    </form>
</body>

</html>
