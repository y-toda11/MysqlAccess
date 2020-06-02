package com.example.MysqlAccess;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_DEPARTMENT")
public class Department {
	@Id
	
	// データ取得
	@Column(name="D_CD" ,columnDefinition = "CHAR(2)")							// 部署コード
	private String d_num;
	
	@Column(name="D_NAME" ,nullable = false ,columnDefinition = "VARCHAR(20)")	// 部署名
	private String d_name;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")					// 更新日
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")				// 更新者
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")					// 作成日時
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")				// 作成者
	private String create_user;
	
	
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
	
	public void setAll(  String d_num
						,String d_name) {
		this.d_num = d_num;
		this.d_name = d_name;	
	}
	
	
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}

