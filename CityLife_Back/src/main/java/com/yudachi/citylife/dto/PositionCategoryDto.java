package com.yudachi.citylife.dto;

import lombok.Data;

import java.util.List;

@Data
public class PositionCategoryDto {
    private Integer value;
    private String label;
    private List<PositionCategoryDto> children;
}
