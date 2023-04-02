CREATE TABLE loan (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   loan_id UUID NOT NULL,
   loan_value DECIMAL NOT NULL,
   first_installment_date date NOT NULL,
   number_of_installments INT NOT NULL,
   status INT NOT NULL,
   customer_id BIGINT NOT NULL,
   CONSTRAINT pk_loan PRIMARY KEY (id)
);

ALTER TABLE loan ADD CONSTRAINT uc_loan_loanid UNIQUE (loan_id);

ALTER TABLE loan ADD CONSTRAINT FK_LOAN_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);