package com.ngemobi.mapper;

import java.util.List;

public interface OadsMapper {
	/**
	 * ��ѯӦ������
	 * @return
	 */
	List<String> selectPkgName();
	
	/**
	 * ���Ӧ������
	 * @param name
	 */
	void insertPkgName(String name);
	
	/**
	 * ��pkgȥ���ݿ��ѯ�Ƿ����
	 * @param pkg
	 * @return
	 */
	String selectPkgByPkg(String pkg);
	
	
}
