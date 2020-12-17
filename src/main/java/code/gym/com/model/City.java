package code.gym.com.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long acreage;
    private Long population;
    private Long gdp;
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
