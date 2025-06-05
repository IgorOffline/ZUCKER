package igoroffline.practice.zuckerjdbcthree.main;

import java.time.LocalDateTime;

public record Country(Integer id, String country, LocalDateTime lastUpdate) {
}
