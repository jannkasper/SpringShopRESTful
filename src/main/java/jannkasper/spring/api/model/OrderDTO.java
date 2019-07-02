package jannkasper.spring.api.model;

import jannkasper.spring.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    @PastOrPresent(message = "Date cannot be from future")
    private Date date;

    private Status status;

    private UserDTO userDTO;
}
