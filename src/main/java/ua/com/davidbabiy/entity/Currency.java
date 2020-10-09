package ua.com.davidbabiy.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Accessors(chain = true)
public class Currency {
    private String txt;
    private Double rate;
    private String cc;
    private String status = "200 OK";
}
