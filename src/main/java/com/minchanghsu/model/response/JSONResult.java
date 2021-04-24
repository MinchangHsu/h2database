package com.minchanghsu.model.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minchanghsu.enums.ErrorCodeMsg;
import com.minchanghsu.enums.SuccessCodeMsg;
import com.minchanghsu.utils.DateTimeUtil;
import com.minchanghsu.utils.JsonUtil;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Getter
@ToString
public class JSONResult {

    private String time = DateTimeUtil.getNowString();
    private int code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int errorCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> result;

    private JSONResult() {
        super();
    }

    /***
     * @param errorEnum
     * @param params
     * @return JSONResult
     */
    public static JSONResult createResult(ErrorCodeMsg errorEnum, String... params) {
        JSONResult resultObj = new JSONResult();
        resultObj.message = errorEnum.getErrorMsg(params);
        resultObj.code = errorEnum.getCode();
        resultObj.errorCode = errorEnum.getErrorCode();
        return resultObj;
    }

    /**
     * @param successEnum
     * @param params
     * @return
     */
    public static JSONResult createResult(SuccessCodeMsg successEnum, String... params) {
        JSONResult resultObj = new JSONResult();
        resultObj.message = successEnum.getMsg();
        resultObj.code = successEnum.getCode();
        return resultObj;
    }

    /**
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static JSONResult createExceptionResult(int errorCode, String errorMsg) {
        JSONResult resultObj = new JSONResult();
        resultObj.message = errorMsg;
        resultObj.code = 0;
        resultObj.errorCode = errorCode;
        return resultObj;
    }

    /**
     * 一般回傳
     *
     * @param key
     * @param obj
     * @return
     */
    public JSONResult addResult(String key, Object obj) {
        Optional.ofNullable(result)
                .orElseGet(() -> this.result = new HashMap<>())
                .put(key, obj);
        return this;
    }

    public JSONResult addResult(Object obj) {

        if (Objects.isNull(obj)) return this;

        if (obj instanceof Iterable || obj.getClass().isArray()) {
            return this.addResult("list", obj);
        }

        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = oMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
        });
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.addResult(entry.getKey(), entry.getValue());
        }
        return this;
    }


    public String toJsonForLog() {
        return JsonUtil.toJsonLog(this);
    }

    @JsonIgnore
    public boolean isOk() {
        return Objects.equals(code, SuccessCodeMsg.COMMON_OK.getCode());
    }

}
