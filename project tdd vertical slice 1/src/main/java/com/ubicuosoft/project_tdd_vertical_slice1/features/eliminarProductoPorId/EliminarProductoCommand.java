package com.ubicuosoft.project_tdd_vertical_slice1.features.eliminarProductoPorId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EliminarProductoCommand {
    private long id;
}
