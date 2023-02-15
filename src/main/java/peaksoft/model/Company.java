package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "companies")
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_gen"
    )
    private Long id;
    private String name;
    private String country;
    private String image;

    public Company(String name, String country, String image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
