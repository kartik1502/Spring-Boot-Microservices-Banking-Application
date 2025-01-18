package org.training.account.service.model.dto;

import lombok.Data;
import org.training.account.service.model.AccountStatus;

@Data
public class AccountStatusUpdate {
    AccountStatus accountStatus;
}
