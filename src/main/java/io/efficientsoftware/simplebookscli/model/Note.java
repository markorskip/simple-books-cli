package io.efficientsoftware.simplebookscli.model;

import lombok.Data;

import java.util.Date;

@Data
public class Note {

    private Date dateCreated;
    private String note;

}
