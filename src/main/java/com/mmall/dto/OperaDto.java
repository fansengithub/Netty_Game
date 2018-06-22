package com.mmall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class OperaDto {
    private String id;
    private String classifyName;
    private String operaName;
    private String coverPicture;
    private String learnBookName;
    private String author;
    private String difficulty;
    private String expiryTime;
    private int classifyId;

}
