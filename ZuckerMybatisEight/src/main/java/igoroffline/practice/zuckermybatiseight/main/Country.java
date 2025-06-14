package igoroffline.practice.zuckermybatiseight.main;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Country {

    private Integer id;
    private String country;
    private LocalDateTime lastUpdate;
}
