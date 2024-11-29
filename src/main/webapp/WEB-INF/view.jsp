<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Chi tiết tài liệu</title>
</head>
<body>
<h1>Chi tiết tài liệu</h1>
<p><strong>ID:</strong> ${document.id}</p>
<p><strong>Tên tài liệu:</strong> ${document.name}</p>
<p><strong>Năm:</strong> ${document.year}</p>
<p><strong>Danh mục:</strong> ${document.categories}</p>
<a href="documents">Quay lại danh sách</a>
</body>
</html>