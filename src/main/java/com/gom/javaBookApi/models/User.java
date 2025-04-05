    package com.gom.javaBookApi.models;

    import jakarta.persistence.*;
    import lombok.*;

    import java.io.Serializable;
    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "tb_user")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")

    public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
        @OneToMany(mappedBy = "user")
        private List<Book> books = new ArrayList<>();
        private LocalDateTime createdAt;


        @PrePersist
        public void prePersist() {
            createdAt = LocalDateTime.now();
        }
    }
