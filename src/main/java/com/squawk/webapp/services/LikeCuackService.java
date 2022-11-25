package com.squawk.webapp.services;

import com.squawk.webapp.models.LikeCuack;

public interface LikeCuackService {
    String add(Long cuackId, Long userId);
    Integer countLikesOnCuacks(Long cuackId);
    Boolean isLikedByUser(Long cuackId, Long userId);
    String delete(Long cuackId, Long userId);
}
