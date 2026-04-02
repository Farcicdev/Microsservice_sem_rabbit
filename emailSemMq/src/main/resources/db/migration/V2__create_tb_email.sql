CREATE TABLE tb_email (
    email_id UUID PRIMARY KEY,

    email_from VARCHAR(255),
    email_to VARCHAR(255),
    subject VARCHAR(255),

    body TEXT,

    send_date TIMESTAMP,

    email_status VARCHAR(50)
);