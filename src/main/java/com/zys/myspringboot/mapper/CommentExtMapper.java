package com.zys.myspringboot.mapper;

import com.zys.myspringboot.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}