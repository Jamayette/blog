<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>comment a book - Jamayette</title>
</head>

<body>
    <form action="/m/book/edit/submit" method="POST">
        <input type="text" name="title" placeholder="title" size="46"/><br>
        <input type="text" name="author" placeholder="author"/>
        <input type="text" name="publishYear" placeholder="publishYear"/><br>
        <input type="text" name="imgUrl" placeholder="imgUrl" size="60"/><br>
        <input type="text" name="introUrl" placeholder="introUrl" size="60"/><br>
        <textarea name="comment" rows="24" cols="72"></textarea><br>
        <button type="submit">Submit</button>
    </form>
</body>

</html>