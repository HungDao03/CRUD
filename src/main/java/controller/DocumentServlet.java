package controller;

import model.Document;
import service.DocumentService;
import service.DocumentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DocumentServlet", urlPatterns = "/documents")
public class DocumentServlet extends HttpServlet {
    private final DocumentService documentService = new DocumentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteDocument(request, response);
                break;
            case "search":
                searchDocuments(request, response);
                break;
            default:
                listDocuments(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                createDocument(request, response);
                break;
            case "edit":
                updateDocument(request, response);
                break;
            default:
                listDocuments(request, response);
                break;
        }
    }

    private void listDocuments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> documents = documentService.getAllDocuments();
        request.setAttribute("documents", documents);
        request.getRequestDispatcher("document/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("document/create.jsp").forward(request, response);
    }

    private void createDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String categories = request.getParameter("categories");

        Document document = new Document(id, name, year, categories);
        documentService.addDocument(document);
        response.sendRedirect("/documents");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Document document = documentService.getDocumentById(id);
        request.setAttribute("document", document);
        request.getRequestDispatcher("document/edit.jsp").forward(request, response);
    }

    private void updateDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String categories = request.getParameter("categories");

        Document updatedDocument = new Document(id, name, year, categories);
        documentService.updateDocument(id, updatedDocument);
        response.sendRedirect("/documents");
    }

    private void deleteDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        documentService.deleteDocument(id); // Xóa tài liệu với ID tương ứng
        response.sendRedirect("documents"); // Quay lại danh sách
    }

    private void searchDocuments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Document> documents = documentService.searchDocumentsByName(name);
        request.setAttribute("documents", request);
        request.getRequestDispatcher("document/list.jsp").forward(request, response);
    }

    private void viewDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Document document = documentService.getDocumentById(id); // Lấy tài liệu từ danh sách
        if (document != null) {
            request.setAttribute("document", document); // Gửi tài liệu qua request
            request.getRequestDispatcher("document/view.jsp").forward(request, response); // Điều hướng đến JSP
        } else {
            response.sendRedirect("documents"); // Nếu không tìm thấy, quay lại danh sách
        }
    }

}