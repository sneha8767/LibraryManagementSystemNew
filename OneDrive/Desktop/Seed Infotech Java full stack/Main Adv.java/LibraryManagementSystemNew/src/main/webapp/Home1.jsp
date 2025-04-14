<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .navbar {
            background-color:#28a745;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }
        .navbar .lib-name {
            color: white;
            font-size: 24px;
            font-weight: bold;
        }
        .navbar .nav-links {
            display: flex;
            justify-content: center;
            flex-grow: 1;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 14px 16px;
            transition: background-color 0.3s;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .search-bar {
            margin: 20px auto;
            width: 80%;
        }
        .search-bar input[type="text"] {
            width: 70%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        .search-bar input[type="submit"] {
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }
        .search-bar input[type="submit"]:hover {
            background-color: #218838;
        }
        .featured-books {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .book {
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 10px;
            margin: 10px;
            width: 200px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: relative;
            width: 100%;
            margin-top: 20px;
        }
        .styled-button {
            padding: 10px 20px; /* Vertical | Horizontal padding */
            font-size: 16px; /* Font size */
            color: white; /* Text color */
            background-color: #007bff; /* Button color */
            border: none; /* No border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s, transform 0.2s; /* Smooth transitions */
        }
        .styled-button:hover {
            background-color: #0056b3; /* Darker shade on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }
        .styled-button:active {
            transform: scale(0.95); /* Slightly shrink when clicked */
        }
        
    </style>
</head>
<body>

    <div class="navbar">
        <div class="lib-name">City Library</div>
        <div class="nav-links">
            <a href="Addbook.html">Insert New Book</a>
            <a href="Updatebook.jsp">Update Book</a>
            <a href="searchBook.jsp">Search Book</a>
            <a href="deleteBook.jsp">Delete Book</a>
            <a href="showAllBooks.jsp">Show All Books</a>
            <a href="LogoutServlet">Logout</a>
        </div>
    </div>

    <div class="container">
        <h1>Welcome to the City Library</h1>
        <p>Your one-stop solution for managing library books.</p>
        <p>Explore our extensive collection and enjoy reading!</p>

        <div class="search-bar">
            <form action="Searchbook.html" method="get">
                <input type="text" name="query" placeholder="Search for books...">
                <input type="submit" value="Search">
            </form>
        </div>

        <h2>Featured Books</h2>
        <div class="featured-books">
            <div class="book">
                <h3>The Alchemist</h3>
                <p>Author: Paulo Coelho</p>
                <p>Publication: Penguin India</p>
                <p>Year: 2023</p>
                <button class="styled-button">Read Book</button>
            </div>
            <div class="book">
                <h3>The White Tiger</h3>
                <p>Author: Aravind Adiga</p>
                <p>Publication: HarperCollins</p>
                <p>Year: 2022</p>
                <button class="styled-button">Read Book</button>
            </div>
            <div class="book">
                <h3>Two States</h3>
                <p>Author: Chetan Bhagat</p>
                <p>Publication: Rupa Publications</p>
                <p>Year: 2021</p>
                 <button class="styled-button">Read Book</button>
            </div>
            <div class="book">
                <h3>The Guide</h3>
                <p>Author: R.K. Narayan</p>
                <p>Publication: Penguin India</p>
                <p>Year: 2020</p>
                 <button class="styled-button">Read Book</button>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 City Library. All rights reserved.</p>
    </footer>

</body>
</html>
