package com.ubicuosoft.project_tdd_vertical_slice1.features.obtenerProductoPorId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObtenerProductoPorIdCommand {
    private long id;
}
