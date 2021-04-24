package com.minchanghsu.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum ErrorCodeMsg {
    // 1000 前後共用
    SYSTEM_OPERATION_ERROR(0, 1000, "系統操作錯誤，請洽詢系統人員"),
    DATABASE_ERROR(0, 1001, "Database系統錯誤，請洽詢系統人員"),
    COMMON_FAILED(0, 1002, "回應失敗"),
    FIND_NO_ADMIN_USER(0, 1003, "查無此用戶"),
    ADMIN_USER_SHUTDOWN(0, 1004, "用戶已失效"),
    UNAUTHORIZED(0, 1005, "用戶未登入"),
    FORBIDDEN(0, 1006, "用戶無操作權限"),
    TOKEN_EXPIRED(0, 1007, "Token過期"),
    TOKEN_ERROR(0, 1008, "Token驗證錯誤"),

    // 2000 Backstage
    GOOGLE_SECRET_KEY_EMPTY_ERROR(0, 2000, "使用者未綁定谷歌驗證碼錯誤"),
    GOOGLE_VALIDATION_CODE_ERROR(0, 2001, "谷歌驗證碼錯誤"),
    DUPLICATE_ROLE_NAME_ERROR(0, 2002, "重複的角色名稱 roleName:%s"),
    NOT_FOUND_ROLE_ID_ERROR(0, 2003, "查無此角色 roleId:%s"),
    PERMISSION_ID_LIST_ERROR(0, 2004, "權限Id有誤,請重新確認. permissionIdList:%s"),
    ROLE_IS_BOUND_TO_ACCOUNT_ERROR(0, 2005, "此角色已綁定帳號,無法刪除."),

    // 3000 RestApi
    REST_API_ERROR(0, 3000, "使用者未綁定谷歌驗證碼錯誤"),

    //5000開頭為異動資料庫時產生的錯誤
    //5000~5099：共用
    DB_DEFAULT_ERROR(0, 5000, "資料庫錯誤 %s"),
    //5100~5199：新增
    DB_INSERT_ERROR(0, 5100, "新增失敗 %s"),
    //5200~5299：查詢
    DB_QUERY_ERROR(0, 5200, "查詢失敗 %s"),
    //5300~5399：修改
    DB_UPDATE_ERROR(0, 5300, "修改失敗 %s"),
    //5400~5499：刪除
    DB_DELETE_ERROR(0, 5400, "刪除失敗 %s");


    private int code; //api對外回應的代碼
    private int errorCode;
    private String errorMsg;

    ErrorCodeMsg(int code, int errorCode, String errorMsg) {
        this.code = code;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private static Map<String, ErrorCodeMsg> map;

    static {
        map = Arrays.stream(ErrorCodeMsg.values())
                    .collect(Collectors.toMap(ErrorCodeMsg::toString, e -> e));
    }

    public static ErrorCodeMsg getInstanceOf(String whichEnum) {
        return map.get(whichEnum);
    }

    public String getErrorMsg(String... context) {
        if (context.length > 0) {
            // 找出有多少個%s
            int signCount = errorMsg.split("%s").length - 1;
            int supplementCount = signCount - context.length;
            // 傳入的參數個數不足，需產生新陣列，長度必須至少跟%s個數一樣(否則format會出錯)，並將null替換成""
            if (supplementCount > 0) {
                Object[] newContext = null;
                List<String> al = Arrays.asList(Arrays.copyOf(context, signCount));
                newContext = al.stream()
                               .map(StringUtils::defaultString)
                               .toArray();
                // String[] newContext = ArrayLis
                return String.format(errorMsg, newContext);
            }

            return String.format(errorMsg, (Object[]) context);
        } else {
            errorMsg = errorMsg.replaceAll("%s", "\"\"");
            return errorMsg;
        }
    }

    public String getErrorCodeMsg(String... context) {
        String errorMsg = getErrorMsg(context);
        return String.format("ErrorCode:%s; ErrorMsg:%s", errorCode, errorMsg);
    }
}
