package com.binarytree.binarytreestudents.applicationdto;

import com.binarytree.binarytreestudents.controller.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBinaryTreeDto {

    private Object data;
    private String message;
    private List<ErrorDTO> errors;

}
