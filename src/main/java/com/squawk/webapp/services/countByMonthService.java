package com.squawk.webapp.services;

import com.squawk.webapp.models.countByMonth;

import java.util.List;
import java.util.Optional;

public interface countByMonthService {
    List<countByMonth> findCantCuacks();
    List<countByMonth> findCantUsers();
}