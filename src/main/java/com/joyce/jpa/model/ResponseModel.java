package com.joyce.jpa.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseModel implements Serializable {
    private static final long serialVersionUID = 3436477890959388400L;

    public ResponseModel(){
    }

    /**
     * support Controller return fail information
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public synchronized static ResponseModel failOfOpenapi(String errorCode, String errorMsg){
        ResponseModel result = new ResponseModel();
        result.setCode(errorCode);
        result.setMsg(errorMsg);
        return result;
    }

    /**
     * support Controller return fail information
     * @param errorCode
     * @param error
     * @return
     */
    public synchronized static ResponseModel failWithError(String errorCode, String error){
        ResponseModel result = new ResponseModel();
        result.setCode(errorCode);
        result.setError(error);
        return result;
    }

    public synchronized static ResponseModel successWithList(List list){
        ResponseModel result = new ResponseModel();
        result.setCode("0000");
        result.setList(list);
        return result;
    }

    public boolean isSuccess(){
        if(StringUtils.equalsIgnoreCase(this.getCode(), "0000")){
            return true;
        }
        return false;
    }

    /*
     * field
     */

    String code = "0000";
    String msg;
    String error;
    List list = new ArrayList();
    Map<String, Object> map = new HashMap<>();

    /*
     * getter and setter
     */

    public ResponseModel setCode(String code) {
        this.code = code;
        return this;
    }

    public ResponseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
