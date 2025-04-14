<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        h1 {
            color: #333;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 15px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .message {
            margin: 10px 0;
            color: green; /* Change color based on success or error */
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h1>Delete Book</h1>
<form action="DeleteBookServlet" method="post">
    <label for="bookno">Enter Book Number to Delete:</label>
    <input type="text" name="bookno" required>
    <input type="submit" value="Delete Book">
</form>

<% 
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div class="message <%= message.contains("success") ? "" : "error" %>">
        <%= message %>
    </div>
<%
    }
%>

</body>
</html>
