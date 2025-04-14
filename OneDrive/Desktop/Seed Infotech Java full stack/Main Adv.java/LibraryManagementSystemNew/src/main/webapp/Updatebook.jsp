<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Book Details</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; padding: 20px; background-color: #f9f9f9; }
        h1 { color: #333; }
        form { background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }
        label { display: block; margin-bottom: 8px; }
        input[type="text"], input[type="number"] { width: calc(100% - 22px); padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; }
        input[type="submit"] { padding: 10px 15px; background-color: #007BFF; color: #fff; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #0056b3; }
        .result { margin-top: 20px; }
    </style>
</head>
<body>

<h1>Update Book Details</h1>
<form action="UpdateBookServlet" method="post">
    <label for="bookno">Book Number:</label>
    <input type="text" name="bookno" required>

    <label for="bname">Book Name:</label>
    <input type="text" name="bname" required>

    <label for="aname">Author Name:</label>
    <input type="text" name="aname" required>

    <label for="price">Price:</label>
    <input type="number" name="price" required>

    <label for="pubname">Publisher Name:</label>
    <input type="text" name="pubname" required>

    <input type="submit" value="Update Book">
</form>

<%
    String updateResult = (String) request.getAttribute("updateResult");
    if (updateResult != null) {
%>
    <div class="result">
        <h2>Update Result:</h2>
        <p><%= updateResult.equals("success") ? "Book updated successfully!" : "Failed to update book." %></p>
    </div>
<%
    }
%>

</body>
</html>
