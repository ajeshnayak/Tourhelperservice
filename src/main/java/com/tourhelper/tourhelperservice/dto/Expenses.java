package com.tourhelper.tourhelperservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Expenses {
    String groupId;
    String paidBy;
    String contributionGuid;
    List<ExpenseBreakup> expenseBreakups;
}
