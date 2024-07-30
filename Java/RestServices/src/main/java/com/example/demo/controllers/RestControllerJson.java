/**
 * 
 */
package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RequestObj;
import com.example.demo.model.ResponseObj;
import com.example.demo.util.RestUtil;


/**
 * The Class RestControllerJson.
 * has Rest service methods that consumes/produces JSON Data.
 *
 * @author Vivek Jadhav
 */
@RestController
@RequestMapping("testJava/rs/json/")
public class RestControllerJson {

	/**
	 * Fetch.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping(value = "fetch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObj> fetch(@PathVariable("id") Long id) {
		ResponseObj responseObj = new ResponseObj();
		HttpStatus httpStatus;
		if(null != id) {
			//TODO SERVICE CALL
			httpStatus = HttpStatus.OK;
			responseObj.setStatus(RestUtil.SUCCESS);
			responseObj.setMessage("DATA : OBJ ");
			return new ResponseEntity<>(responseObj, httpStatus);
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObj.setStatus(RestUtil.FAILURE);
			responseObj.setMessage("Error Occurred ");
			return new ResponseEntity<>(responseObj, httpStatus);
		}
	}

	/**
	 * Insert.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObj> insert(@RequestBody RequestObj request) {
		ResponseObj responseObj = new ResponseObj();
		HttpStatus httpStatus;
		if(null != request.getId() && null != request.getName() && null != request.getDepartment()) {
			httpStatus = HttpStatus.OK;
			//TODO SERVICE CALL
			responseObj.setStatus(RestUtil.SUCCESS);
			responseObj.setMessage("Inserted Data ");
			return new ResponseEntity<>(responseObj, httpStatus);
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObj.setStatus(RestUtil.FAILURE);
			responseObj.setMessage("Error Occurred ");
			return new ResponseEntity<>(responseObj, httpStatus);
		}
	}

	/**
	 * Patch.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	@PatchMapping(value = "patch/{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObj> patch(@PathVariable("id") Long id, @RequestBody RequestObj request) {
		ResponseObj responseObj = new ResponseObj();
		HttpStatus httpStatus;
		if(null != id || null != request.getName()) {
			//TODO SERVICE CALL
			httpStatus = HttpStatus.OK;
			responseObj.setStatus(RestUtil.SUCCESS);
			responseObj.setMessage("PATCHED DATA UPDATED: OBJ ");
			return new ResponseEntity<>(responseObj, httpStatus);
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObj.setStatus(RestUtil.FAILURE);
			responseObj.setMessage("Error Occurred ");
			return new ResponseEntity<>(responseObj, httpStatus);
		}
	}

	/**
	 * Put.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	@PutMapping(value = "put/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObj> put(@PathVariable("id") Long id, @RequestBody RequestObj request) {
		ResponseObj responseObj = new ResponseObj();
		HttpStatus httpStatus;
		if(null != id && null != request.getName() && null != request.getDepartment()) {
			//SERVICE CALL
			httpStatus = HttpStatus.OK;
			responseObj.setStatus(RestUtil.SUCCESS);
			responseObj.setMessage("Put DATA UPDATED: OBJ ");
			return new ResponseEntity<>(responseObj, httpStatus);
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObj.setStatus(RestUtil.FAILURE);
			responseObj.setMessage("Error Occurred ");
			return new ResponseEntity<>(responseObj, httpStatus);
		}
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObj> delete(@PathVariable("id") Long id) {
		ResponseObj responseObj = new ResponseObj();
		HttpStatus httpStatus;
		if(null != id) {
			//SERVICE CALL
			httpStatus = HttpStatus.OK;
			responseObj.setStatus(RestUtil.SUCCESS);
			responseObj.setMessage("DELETED DATA : OBJ ");
			return new ResponseEntity<>(responseObj, httpStatus);
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObj.setStatus(RestUtil.FAILURE);
			responseObj.setMessage("Error Occurred ");
			return new ResponseEntity<>(responseObj, httpStatus);
		}
	}

}
