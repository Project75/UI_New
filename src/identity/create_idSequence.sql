CREATE TABLE
    idSequence
    (
        idtype VARCHAR(100) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT ' ' NOT NULL,
        startid CHAR(20) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT ' ' NOT NULL,
        currentid CHAR(20) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT ' ' NOT NULL,
        idmask CHAR(20) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT ' ' NOT NULL,
        createid VARCHAR(60) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT 'user_name()' NOT NULL,
        createdate DATETIME DEFAULT GETDATE() NOT NULL,
        updateid VARCHAR(60) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT 'user_name()' NOT NULL,
        lastupdate DATETIME DEFAULT GETDATE() NOT NULL,
        rawval BIGINT DEFAULT 0 NOT NULL,
        CONSTRAINT PK_idSequence PRIMARY KEY (idtype)
    )