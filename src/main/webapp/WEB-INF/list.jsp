<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Danh sách tài liệu</title>
</head>
<body>
<h1>Danh sách tài liệu</h1>
<a href="documents?action=create">Thêm tài liệu mới</a>
<form method="get" action="documents">
  <input type="hidden" name="action" value="search">
  <input type="text" name="name" placeholder="Tìm kiếm theo tên">
  <button type="submit">Tìm kiếm</button>
</form>
<table border="1" cellspacing="0" cellpadding="10">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Năm</th>
    <th>Danh mục</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="document" items="${documents}">
    <tr>
      <td>${document.id}</td>
      <td>${document.name}</td>
      <td>${document.year}</td>
      <td>${document.categories}</td>
      <td>
        <a href="documents?action=edit&id=${document.id}">Sửa</a> |
        <a href="documents?action=delete&id=${document.id}" onclick="return confirm('Bạn có chắc chắn muốn xoá?')">Xoá</a> |
        <a href="documents?action=view&id=${document.id}">Xem chi tiết</a>
      </td>
    </tr>
  </c:forEach>
  <form method="get" action="documents">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="Tìm kiếm theo tên">
    <button type="submit">Tìm kiếm</button>
  </form>
  </tbody>
</table>
</body>
</html>