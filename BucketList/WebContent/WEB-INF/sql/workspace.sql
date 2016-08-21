show tables;
desc bucketlist_info;
show create table bucketlist_info;

select * from guest_wishedu;
select brdno,brduserid,brdsubject,brdcontext,brdfilepath,brdcount,brdadddate from guest_wishedu;
update guest_wishedu set brdfilepath='wow';

desc guest_wishedu;

delete from guest_wishedu where brdno in(12, 13);