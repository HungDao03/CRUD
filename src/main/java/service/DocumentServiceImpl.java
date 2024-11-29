package service;

import model.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {
    private static List<Document> documents = new ArrayList<Document>();

//        this.id = id;
//        this.name = name;
//        this.year = year;
//        this.category = category;

    static {
        documents.add(new Document(1, "Document 1",2021 ,"Category 1"));
        documents.add(new Document(2, "Document 2",2022 ,"Category 2"));
        documents.add(new Document(3, "Document 3",2023 ,"Category 3"));
    }


    @Override
    public List<Document> getAllDocuments() {
        return new ArrayList<>(documents);
    }

    @Override
    public void addDocument(Document document) {
        documents.add(document);
    }

    @Override
    public void updateDocument(int id, Document document) {
        for (Document doc : documents) {
            if (doc.getId() == id) {
                doc.setName(document.getName());
                doc.setYear(document.getYear());
                doc.setCategory(document.getCategory());
                return;
            }
        }
    }

    @Override
    public void deleteDocument(int id) {
        documents.removeIf(doc -> doc.getId() == id);

    }

    @Override
    public Document getDocumentById(int id) {
        return documents.stream().filter(doc -> doc.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Document> searchDocumentsByName(String name) {
        List<Document> result = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(doc);
            }
        }
        return result;
    }



}
