package org.landscape;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Getter
@Setter
@Builder
public class Routine {
    private double amount;
    private Date date;
}
