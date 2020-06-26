package com.bottega.captraining;

import java.util.UUID;

public class MyError {

    String reqContent;
    String reason;
    String errorCode;
    String docUrl;
    UUID errorId;


    public MyError(String reqContent, String reason, String errorCode, String docUrl, UUID errorId) {
        this.reqContent = reqContent;
        this.reason = reason;
        this.errorCode = errorCode;
        this.docUrl = docUrl;
        this.errorId = errorId;
    }

    public String getReqContent() {
        return reqContent;
    }

    public String getReason() {
        return reason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public UUID getErrorId() {
        return errorId;
    }
}
