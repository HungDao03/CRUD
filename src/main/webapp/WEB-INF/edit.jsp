<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sửa tài liệu</title>
</head>
<body>
<h1>Sửa tài liệu</h1>
<form method="post" action="documents?action=edit">
  <input type="hidden" name="id" value="${document.id}">

  <label for="name">Tên tài liệu:</label>
  <input type="text" id="name" name="name" value="${document.name}" required><br><br>

  <label for="year">Năm:</label>
  <input type="number" id="year" name="year" value="${document.year}" required><br><br>

  <label for="categories">Danh mục:</label>
  <input type="text" id="categories" name="categories" value="${document.categories}" required><br><br>

  <button type="submit">Cập nhật</button>
  <a href="documents">Hủy</a>
</form>
</body>
</html>