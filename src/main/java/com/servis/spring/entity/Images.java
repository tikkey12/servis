package com.servis.spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images_table")
@Data
public class Images {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id = 0;

        @Column(name = "data")
        private String data;

        public Images() {

        }

        public Images(String data) {
                this.data = data;
        }

        public Long getId() {
                return id;
        }
        public String getData() {return data;}
}
