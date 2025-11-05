package com.tourhelper.tourhelperservice.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection="Group")
@Data
public class Group {
    String groupId;
    String groupName;
    String owner;
    List<String> members;
}
