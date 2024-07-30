package com.example.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "RequestObj")
public class RequestObj {
	private Integer id;
	private String name;
	private String department;
}
