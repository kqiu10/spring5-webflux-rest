package springframework.springwebfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Date: 1/29/21
 * Question Description
 */
@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    private String description;
}
