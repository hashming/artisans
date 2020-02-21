CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL,
    type INT NOT NULL,
    commentator INT NOT NULL,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    like_count BIGINT DEFAULT 0
);