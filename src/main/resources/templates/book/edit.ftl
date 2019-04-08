<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit book - Jamayette</title>
</head>

<body>
    <form action="/m/book/edit/submit" method="POST">
        <input type="hidden" name="id" value="${book.id?c}">
        <input type="text" name="title" value="${book.title}" placeholder="author" size="46"/><br/>
        <input type="text" name="author" value="${book.author}" placeholder="author"/>
        <input type="text" name="publishTime" value="${book.publishYear}" placeholder="publishYear"/><br/>
        <input type="text" name="imgUrl" value="${book.imgUrl}" placeholder="imgUrl" size="60"/><br>
        <input type="text" name="introUrl" value="${book.introUrl}" placeholder="introUrl" size="60"/><br>
        <textarea name="comment" rows="24" cols="72"></textarea><br>
        <button type="submit">Submit</button>
    </form>
</body>

</html>