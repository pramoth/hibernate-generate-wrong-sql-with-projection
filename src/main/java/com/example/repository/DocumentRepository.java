package com.example.repository;

import com.example.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pramoth on 9/28/2016 AD.
 */
public interface DocumentRepository extends JpaRepository<Document,Integer> {
    public List<DocumentWithoutParent> findByParentIsNull();

    public static interface DocumentWithoutParent{
        Long getId();
        String getDescription();
        String getDocumentType();
        String getDocumentCategory();

        /**
         * If we remove this test will pass
         */
        List<DocumentWithoutParent> getChild();
    }
}
