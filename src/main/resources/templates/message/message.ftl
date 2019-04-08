<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>send a message - Jamayette</title>
</head>
<body>
    <form id="smsForm" action="/message/send" method="POST">
        <input type="text" name="phoneNumber" placeholder="phoneNumber"/><br/>
        <input type="text" name="content" placeholder="content" size="60"/><br/>
        <input type="text" name="tag" placeholder="tag"/><br/>
        <input type="button" value="提交" onclick="sendMessage()">
    </form>
</body>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    function sendMessage() {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "/m/message/send" ,
            data: $('#smsForm').serialize(),
            success: function (result) {
                if (result === 'success'){
                    alert('发送成功')
                } else {
                    alert('发送失败')
                }
            }
        });
    }
</script>

</html>