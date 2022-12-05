package com.squawk.webapp.services;

public interface DislikeCuackService {
    String add(Long cuackId, Long userId);
    Integer countDislikesOnCuacks(Long cuackId);
    Boolean isDislikedByUser(Long cuackId, Long userId);
    String delete(Long cuackId, Long userId);
}
