<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>write a review - Jamayette</title>
</head>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/movie/create/submit" method="POST">
        <input type="text" name="title" placeholder="title"/>
        <input type="text" name="name" placeholder="path"/><br/>
        <input type="text" name="artist" placeholder="artist"/>
        <input type="text" name="onYear" placeholder="onYear"/>
        <textarea id="comment" name="comment" cols="20" rows="2" class="ckeditor"></textarea>
        <button type="submit">Submit</button>
    </form>
</body>

</html>