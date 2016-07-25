package com.bucketlist.home;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class VO {
	
	private JdbcTemplate jdbcTemplate;
	 
	   /* // 방법 1. 생성자를 통한 DataSource를 > JdbcTemplate에 전달하여 JdbcTemplate 객체 생성.
	    public PjtMakeDAO(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }*/
	    
	 // 방법 2. setter를 통한 DataSource를 > JdbcTemplate 전달하여 JdbcTemplate 객체 생성.
	    public void setDataSource(DataSource dataSource){
	        this.jdbcTemplate = new JdbcTemplate(dataSource);    
	    }
	    
	    public void msg(){
	    	System.out.println("msg");
	    }
	    
	//프로젝트 코드를 구하는 쿼리문
		public int selectCode() {
			String sql = "select count(*) from pjtmake";
			return jdbcTemplate.queryForObject(sql, Integer.class);
		}
		
	//최근 등록한 프로젝트 먼저 출력하기
	public List<String> selectAll(){
		List<String> results = 
				jdbcTemplate.query("select pjtName from pjtMake order by pjtCode"
				,
				new RowMapper<String>(){
					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						String res ="";
						res = rs.getString("pjtName");
						return res;
					}
				}
			);
		return results.isEmpty()?null:results;
	}
}
