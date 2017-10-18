package com.example.mongojavatime;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTestJavaTime is a Querydsl query type for TestJavaTime
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTestJavaTime extends EntityPathBase<TestJavaTime> {

    private static final long serialVersionUID = -110108515L;

    public static final QTestJavaTime testJavaTime = new QTestJavaTime("testJavaTime");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath id = createString("id");

    public QTestJavaTime(String variable) {
        super(TestJavaTime.class, forVariable(variable));
    }

    public QTestJavaTime(Path<? extends TestJavaTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTestJavaTime(PathMetadata metadata) {
        super(TestJavaTime.class, metadata);
    }

}

