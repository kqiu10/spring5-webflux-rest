package springframework.springwebfluxrest.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class Vendor {
    @Id
    private String id;
    private String firstName;
    private String LastName;
}
