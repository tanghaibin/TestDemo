<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        function upload() {
            var file = document.querySelector("#file").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onloadend = function () {
                $("#img").attr("src", reader.result);
                var base64stream = this.result;
                if(base64stream) {
                    $.ajax({
                        url: '/upload',
                        type: "POST",
                        dataType:"text",
                        data:{"base64":base64stream},
                        async: false,
                        success:function(object){

                        },
                        error: function() {
                            alert("上传图片异常");
                        }
                    });
                }else{
                    alert("null");
                }

            };
        }
    </script>
</head>
<body>
    <input type="file" id="file"/>
    <img id="img" src=""/>
<input type="button" onclick="upload()" value="预览"/>
</body>

</html>