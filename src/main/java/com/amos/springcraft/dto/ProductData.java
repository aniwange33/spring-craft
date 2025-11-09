package com.amos.springcraft.dto;

public record ProductData(
    Integer year,
    Double price,
    String CPUModel,
    String hardDiskSize
) {}