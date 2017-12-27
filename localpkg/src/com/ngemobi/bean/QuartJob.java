package com.ngemobi.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ngemobi.service.OadsService;

/**
 * ִ�ж�ʱ����ķ���
 * 
 * @Author user
 *
 * @Date 2017��12��24��
 */
public class QuartJob {
	@Autowired
	private OadsService oadsService;

	public void execute() {
		System.out.println("����ִ������ʼ!");		
		//��ȡ���̵���û�е�pkg
		List<String> list = oadsService.getPkgName();	
		//ѭ����������ӵ����ݿ�
		for (String pkg : list) {
			System.out.println(pkg);
			addPkg(pkg);
		}
	}
	/**
	 * ʹ���ڹȸ��̵��ѯ����pkg��ȥ��ѯ�Ƿ��Ѿ������ݿ���
	 * @param pkgName
	 */
	public void addPkg(String pkgName){
		oadsService.addPkgName(pkgName);
	}
}
