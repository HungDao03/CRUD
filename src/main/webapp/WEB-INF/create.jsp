<!DOCTYPE html>
<html>
<head>
    <title>Thêm tài liệu mới</title>
</head>
<body>
<h1>Thêm tài liệu mới</h1>
<form method="post" action="documents?action=create">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br><br>

    <label for="name">Tên tài liệu:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="year">Năm:</label>
    <input type="number" id="year" name="year" required><br><br>

    <label for="categories">Danh mục:</label>
    <input type="text" id="categories" name="categories" required><br><br>

    <button type="submit">Thêm</button>
    <a href="documents">Hủy</a>
</form>
</body>
</html>