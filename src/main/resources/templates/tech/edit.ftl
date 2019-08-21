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
        <div id="editor">
            ${tech.content}
        </div>
        <textarea id="content" name="content" style="width:100%; height:200px;"></textarea>
        <input type="text" name="createTime" value="${tech.createTime?string('yyyy/MM/dd')}"/>
        <button type="submit">Submit</button>
    </form>
</body>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    editor.customConfig.uploadImgServer = '/upload'
    editor.customConfig.uploadFileName = 'file'
    var $content = $('#content')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $content.val(html)
    }
    editor.create()
    // 初始化 textarea 的值
    $content.val(editor.txt.html())
</script>

</html>
