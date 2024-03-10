<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2024/3/10
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
<form method="post">
    New User Registration! <br>
    <input type="text" placeholder="Username"><br>
    <input type="password" placeholder="Password"><br>
    <input type="email" placeholder="Email"><br>
    <b>Gender:</b> <input type="radio" checked="checked" name="gender">Male <input type="radio"
                                                                                   name="gender">Female<br>
    <input type="text" placeholder="Date of Birth (yyyy-mm-dd)" id="dateInput"><br>
    <button style="background-color: orange">Register</button>
</form>
<script>
    var form = document.querySelector('form');
    var inputs = Array.from(form.querySelectorAll('input')); // 获取所有输入元素

    // 通用空白值检查
    function checkRequired(input) {
        if (input.value === '') {
            alert('This field is required!!');
        }
    }

    // 为所有输入元素添加blur事件监听器，进行空白值检查
    inputs.forEach(function (input) {
        input.addEventListener('blur', function () {
            checkRequired(this);
        });
    });

    // 特定字段的验证
    inputs[1].addEventListener('blur', function () { // 密码长度检查
        if (this.value.length>1 &&this.value.length < 8 ) {
            alert('Password must have at least 8 characters');
        }
    });

    inputs[2].addEventListener('blur', function () { // 邮箱格式检查
        if (!this.value.endsWith('@qq.com')) {
            alert('Please input a correct email ending with @qq.com');
        }
    });

    // 日期格式验证
    var dateInput = document.getElementById('dateInput'); // 通过ID获取日期输入框
    dateInput.addEventListener('blur', function () {
        var dateStr = this.value;
        var isValid = verifyDate(dateStr, dateReg);
        if (!isValid) {
            alert('Please input a valid date in the format yyyy-mm-dd');
        }
    });

    // 正则表达式
    var dateReg = /^(\d{4})-(\d{2})-(\d{2})$/;

    function verifyDate(dateStr, dateReg) {
        // 日期格式不匹配
        if (!dateReg.test(dateStr)) {
            return false;
        }

        // 使用捕获组获取日期
        var matches = dateStr.match(dateReg);
        var year = parseInt(matches[1], 10);
        var month = parseInt(matches[2], 10) - 1; // 月份从0开始计数
        var day = parseInt(matches[3], 10);

        // 创建日期对象
        var dateObj = new Date(year, month, day);

        // 检查日期是否有效
        return dateObj.getFullYear() === year && dateObj.getMonth() === month && dateObj.getDate() === day;
    }
</script>
</body>

</html>