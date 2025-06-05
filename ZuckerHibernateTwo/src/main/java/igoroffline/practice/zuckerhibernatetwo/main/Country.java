package igoroffline.practice.zuckerhibernatetwo.main;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;

    private String country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
