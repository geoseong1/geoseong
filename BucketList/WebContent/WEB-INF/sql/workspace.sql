show tables;
desc bucketlist_info;
show create table bucketlist_info;

select * from guest_wishedu where brdno=30;
select brdno,brduserid,brdsubject,brdcontext,brdfilepath,brdcount,brdadddate from guest_wishedu;
update guest_wishedu set brdfilepath='wow';

desc guest_wishedu;

delete from guest_wishedu where brdno in(12, 13);

select * from member;

update member set 
	userpwd = '1234' ,
	userphone = '010-2023-6697' ,
	useremail = '404hunter@hanmail.net' ,
	joindate = curdate()
	where userid = 'geoseong';

	commit;