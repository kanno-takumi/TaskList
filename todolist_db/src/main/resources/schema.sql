create table if not exists tasklist(
id varchar(8) primary key,--主キー
task varchar(30),
deadline varchar(10),
done boolean
);
--varcharはString型みたいなもの(8)は長さ8