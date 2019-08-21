<!DOCTYPE html>
<html lang="zh" class="no-js">
<title>create a tech article - Jamayette</title>
<head>
    <meta charset="UTF-8">
    <title>write a tech article - Jamayette</title>
</head>
<body>

<form action="/m/tech/create/submit" method="POST">
    <input type="text" name="title" placeholder="title" size="60"/>
    <input type="text" name="name" placeholder="path" size="60"/><br/>
    <div id="editor">
        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
    </div>
    <textarea id="content" name="content" style="width:100%; height:200px;"></textarea>
    <input type="text" name="createTime" placeholder="date(1994/10/26)"/>
    <button type="submit">Submit</button>
</form>

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

</body>
</html>
