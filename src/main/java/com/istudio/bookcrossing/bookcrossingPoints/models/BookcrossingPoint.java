package com.istudio.bookcrossing.bookcrossingPoints.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookcrossing_points")
public class BookcrossingPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String title;
    public float latitude;
    public float longitude;
    public String addressText;
}
