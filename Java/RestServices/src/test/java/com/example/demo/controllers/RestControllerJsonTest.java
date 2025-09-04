package com.example.demo.controllers;

import com.example.demo.controllers.RestControllerJson;
import com.example.demo.model.RequestObj;
import com.example.demo.model.ResponseObj;
import com.example.demo.util.RestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerJsonTest {

    private RestControllerJson controller;

    @BeforeEach
    void setUp() {
        controller = new RestControllerJson();
    }

    @Nested
    @DisplayName("Fetch")
    class FetchTests {
        @Test
        void returnsOkWhenIdIsValid() {
            ResponseEntity<ResponseObj> response = controller.fetch(1L);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(RestUtil.SUCCESS, response.getBody().getStatus());
            assertEquals("DATA : OBJ ", response.getBody().getMessage());
        }

        @Test
        void returnsErrorWhenIdIsNull() {
            ResponseEntity<ResponseObj> response = controller.fetch(null);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            assertEquals(RestUtil.FAILURE, response.getBody().getStatus());
            assertEquals("Error Occurred ", response.getBody().getMessage());
        }
    }

    @Nested
    @DisplayName("Insert")
    class InsertTests {
        @Test
        void returnsOkWhenRequestIsValid() {
            RequestObj request = new RequestObj();
            request.setId(1);
            request.setName("John Doe");
            request.setDepartment("Engineering");
            ResponseEntity<ResponseObj> response = controller.insert(request);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(RestUtil.SUCCESS, response.getBody().getStatus());
            assertEquals("Inserted Data ", response.getBody().getMessage());
        }

        @Test
        void returnsErrorWhenRequestIsInvalid() {
            RequestObj request = new RequestObj();
            ResponseEntity<ResponseObj> response = controller.insert(request);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            assertEquals(RestUtil.FAILURE, response.getBody().getStatus());
            assertEquals("Error Occurred ", response.getBody().getMessage());
        }
    }

    @Nested
    @DisplayName("Patch")
    class PatchTests {
        @Test
        void returnsOkWhenIdOrNameIsValid() {
            RequestObj request = new RequestObj();
            request.setName("Updated Name");
            ResponseEntity<ResponseObj> response = controller.patch(1L, request);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(RestUtil.SUCCESS, response.getBody().getStatus());
            assertEquals("PATCHED DATA UPDATED: OBJ ", response.getBody().getMessage());
        }

        @Test
        void returnsErrorWhenIdAndNameAreNull() {
            RequestObj request = new RequestObj();
            ResponseEntity<ResponseObj> response = controller.patch(null, request);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            assertEquals(RestUtil.FAILURE, response.getBody().getStatus());
            assertEquals("Error Occurred ", response.getBody().getMessage());
        }
    }

    @Nested
    @DisplayName("Put")
    class PutTests {
        @Test
        void returnsOkWhenIdAndRequestAreValid() {
            RequestObj request = new RequestObj();
            request.setName("John Doe");
            request.setDepartment("Engineering");
            ResponseEntity<ResponseObj> response = controller.put(1L, request);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(RestUtil.SUCCESS, response.getBody().getStatus());
            assertEquals("Put DATA UPDATED: OBJ ", response.getBody().getMessage());
        }

        @Test
        void returnsErrorWhenIdOrRequestIsInvalid() {
            RequestObj request = new RequestObj();
            ResponseEntity<ResponseObj> response = controller.put(null, request);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            assertEquals(RestUtil.FAILURE, response.getBody().getStatus());
            assertEquals("Error Occurred ", response.getBody().getMessage());
        }
    }

    @Nested
    @DisplayName("Delete")
    class DeleteTests {
        @Test
        void returnsOkWhenIdIsValid() {
            ResponseEntity<ResponseObj> response = controller.delete(1L);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(RestUtil.SUCCESS, response.getBody().getStatus());
            assertEquals("DELETED DATA : OBJ ", response.getBody().getMessage());
        }

        @Test
        void returnsErrorWhenIdIsNull() {
            ResponseEntity<ResponseObj> response = controller.delete(null);
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            assertEquals(RestUtil.FAILURE, response.getBody().getStatus());
            assertEquals("Error Occurred ", response.getBody().getMessage());
        }
    }
}