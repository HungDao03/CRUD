package service;

import model.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAllDocuments();
    void addDocument(Document document);
    void updateDocument(int id,Document document);
    void deleteDocument(int id);
    Document getDocumentById(int id);
    List<Document>searchDocumentsByName(String name);


}
