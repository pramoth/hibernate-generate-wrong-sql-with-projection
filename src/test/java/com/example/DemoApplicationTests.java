package com.example;

import com.example.domain.Document;
import com.example.repository.DocumentRepository;
import com.example.repository.DocumentRepository2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTests {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentRepository2 documentRepository2;

    /**
     * Hibernate generate incorrect sql when use projection in query method.
     */
    @Test
    public void findWithProjection() {
        List<DocumentRepository.DocumentWithoutParent> byParentIsNull = documentRepository.findByParentIsNull();
        Assertions.assertThat(byParentIsNull).isEmpty();
    }

    /**
     * Hibernate generate correct sql when not use projection.
     */
    @Test
    public void findWithOutProjection() {
        List<Document> byParentIsNull = documentRepository2.findByParentIsNull();
        Assertions.assertThat(byParentIsNull).isEmpty();
    }

}
