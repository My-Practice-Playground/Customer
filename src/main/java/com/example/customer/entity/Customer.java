package com.example.customer.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements SuperEntity {
    @Id
    private String id;
    @NonNull
    private String name;
    private String city;
    private String email;
}
