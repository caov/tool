package com.cf.tool.util;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResult<T> {

	private int status;

	private String errorMsg;

	private T data;

	private ApiResult() {}

	private ApiResult(int status,T data, String errorMsg){
		this.status = status;
		this.data = data;
		this.errorMsg = errorMsg;
	}

	public static <T> ApiResult<PageResult<T>> ofPage(List<T> content, long totalCount){
		PageResult<T> pageResult = new PageResult<>();
		pageResult.setContent(content);
		pageResult.setTotal(totalCount);
		return ok(pageResult);
	}

	//================================构造方法================================================
	public static <T> ApiResult<T> ok(){
		return new ApiResult<>(HttpStatus.OK.value(),null,null);
	}
	public static <T> ApiResult<T> ok(T data){
		return new ApiResult<>(HttpStatus.OK.value(),data,null);
	}
	public static <T> ApiResult<T> error(HttpStatus status, String errorMsg){
		return new ApiResult<>(status.value(),null,errorMsg);
	}
	public static <T> ApiResult<T> error(int status, String errorMsg){
		return new ApiResult<>(status,null,errorMsg);
	}
	public static <T> ApiResult<T> error(int status, String errorMsg, T data){
		return new ApiResult<>(status,data,errorMsg);
	}
	public static <T> ApiResult<T> authError(String errorMsg){
		return new ApiResult<>(HttpStatus.UNAUTHORIZED.value(),null,errorMsg);
	}
	public static <T> ApiResult<T> paramError(String errorMsg){
		return new ApiResult<>(HttpStatus.BAD_REQUEST.value(),null,errorMsg);
	}
	public static <T> ApiResult<T> serverError(String errorMsg){
		return new ApiResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),null,errorMsg);
	}
	public boolean isSuccess() {
		return HttpStatus.OK.value() == status;
	}
//	public boolean isFailure() {
//		return ! isSuccess();
//	}
//	public boolean isPresent() {
//		return isSuccess() && data != null;
//	}

	public int getStatus() {
		return status;
	}

	public ApiResult<T> setStatus(int status) {
		this.status = status;
		return this;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public ApiResult<T> setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ApiResult<T> setData(T data) {
		this.data = data;
		return this;
	}


}
