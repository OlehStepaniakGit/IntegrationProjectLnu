package org.stepaniak.lnu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Data {
    @Id
    @JsonIgnore
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String date;



    public Data() { }

    public Data(String content, String date) {
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
