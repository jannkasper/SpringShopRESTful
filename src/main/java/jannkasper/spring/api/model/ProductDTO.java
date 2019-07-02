package jannkasper.spring.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotEmpty
    @Size(min = 3, max = 50, message = "About Me must be between 3 and 50 characters")
    private String name;


    private String type;
}
