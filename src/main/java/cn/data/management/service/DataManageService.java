package cn.data.management.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.mapper.Mapper;

import cn.data.management.entity.DataManage;
import cn.data.management.mapper.DataManageMapper;

public class DataManageService extends BaseService<DataManage> {

	@Autowired
	private DataManageMapper dataManageMapper;

	@Override
	public Mapper<DataManage> getMapper() {
		return dataManageMapper;
	}

}
