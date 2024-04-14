package com.econovation.springstudy.sticker.application.dto.request;

public class AddInventoryRequest {

    private Long count;

    public AddInventoryRequest(Long count){ this.count = count; }

    public Long getCount() { return count; }

}
