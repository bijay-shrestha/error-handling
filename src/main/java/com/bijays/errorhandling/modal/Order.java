package com.bijays.errorhandling.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>Order class.</p>
 *
 * @author bijayshrestha
 * @version $Id: $Id
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private String id;
    private String name;
    private Integer quantity;
    private Double price;
}
