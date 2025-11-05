package com.tourhelper.tourhelperservice.dto;

import lombok.Data;

@Data
public class ExpenseBreakup {
    String userGuid;
    Double contribution;
    String remarks;
}
