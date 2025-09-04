package com.example.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "ResponseObj")
public class ResponseObj {
	private String status;
	private String errorMessage;
	private String message;
}
