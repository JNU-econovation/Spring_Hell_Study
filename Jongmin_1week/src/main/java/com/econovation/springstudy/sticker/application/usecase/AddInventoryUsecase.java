package com.econovation.springstudy.sticker.application.usecase;

import com.econovation.springstudy.sticker.application.dto.request.AddInventoryRequest;
import com.econovation.springstudy.sticker.application.dto.response.AddInventoryResponse;

public interface AddInventoryUsecase {

    public AddInventoryResponse add(AddInventoryRequest request);

}
