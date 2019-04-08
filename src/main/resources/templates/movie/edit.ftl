<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit movie - Jamayette</title>
</head>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<body>
    <form action="/m/movie/edit/submit" method="POST">
        <input type="hidden" name="id" value="${movie.id?c}">
        <input type="text" name="title" value="${movie.title}" placeholder="title"/>
        <input type="text" name="name" value="${movie.name}" placeholder="path"/><br/>
        <input type="text" name="artist" value="${movie.artist}" placeholder="artist"/>
        <input type="text" name="onYear" value="${movie.onYear}" placeholder="onYear"/>
        <textarea id="comment" name="comment" cols="20" rows="2" class="ckeditor">${movie.comment}</textarea>
        <button type="submit">Submit</button>
    </form>
</body>

</html>