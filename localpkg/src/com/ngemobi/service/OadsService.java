package com.ngemobi.service;

import java.util.List;

public interface OadsService {
	
	/**
	 * �õ�ȫ��Ӧ�õ�����
	 * @return
	 */
	List<String> getPkgName();
	
	/**
	 * ����¼ܵ�Ӧ������
	 * @param pkgName
	 */
	void addPkgName(String pkgName);

	/**
	 * ʹ��pkg��ѯ��pkg�Ƿ��Ѿ�����
	 * @param pkg
	 * @return
	 */
	void getpkg(String pkg);
}
