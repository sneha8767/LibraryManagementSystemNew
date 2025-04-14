<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Bean.BookBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Book</title>
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
        .result {
            margin-top: 20px;
            background: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<h1>Search Book by Book Number</h1>
<form action="SearchBookServlet" method="post">
    <label for="bookno">Enter Book Number:</label>
    <input type="text" name="bookno" required>
    <input type="submit" value="Search">
</form>

<%
    List<BookBean> books = (List<BookBean>) request.getAttribute("bookList");
    if (books != null && !books.isEmpty()) {
%>
    <div class="result">
        <h2>Search Results:</h2>
        <ul>
            <% for (BookBean book : books) { %>
                <li>
                    <strong>Book Number:</strong> <%= book.getBookNo() %> | 
                    <strong>Title:</strong> <%= book.getBname() %> | 
                    <strong>Author:</strong> <%= book.getAname() %> | 
                    <strong>Price:</strong> <%= book.getPrice() %> | 
                    <strong>Publisher:</strong> <%= book.getPubname() %>
                </li>
            <% } %>
        </ul>
    </div>
<%
    } else if (books != null) {
%>
    <div class="result">
        <h2>No results found.</h2>
    </div>
<%
    }
%>

</body>
</html>
