package com.mmall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class OperaDiffcultyDto {
   private String operaId;
   private String classifyName;
   private String operaName;
   private String imgUrl;
   private String textbookName;
   private String author;
   private String expiryTime;
}
