package cn.data.management.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_data_manage")
public class DataManage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成方式
	private Long id;

	private String teamName;
	private String dataName;
	private String Ip;
	private String uploadBy;
	private Date createTime;
	private Date updateTime;
	private Long viewCount;
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getUploadBy() {
		return uploadBy;
	}

	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "DataManage [id=" + id + ", teamName=" + teamName + ", dataName=" + dataName + ", Ip=" + Ip
				+ ", uploadBy=" + uploadBy + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", viewCount=" + viewCount + ", url=" + url + "]";
	}

}
