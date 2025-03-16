package net.etfbl.clientfitnesapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pdf {


        private String fileName;
        private byte[] data;
}
