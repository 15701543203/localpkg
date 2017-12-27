package com.ngemobi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngemobi.service.OadsService;

@Controller
@RequestMapping("/google")
public class OadsController {
	@Autowired
	private OadsService oadsService;
	
	
	/**
	 * �ڹȸ��̵��в�ѯ��Ӧ���Ƿ��¼�
	 * 
	 */
	@RequestMapping(value="search",method=RequestMethod.POST)
	public void searchPkg(){
		//��ȡ���̵���û�е�pkg
		List<String> list = oadsService.getPkgName();	
		//ѭ����������ӵ����ݿ�
		for (String string : list) {
			addPkg(string);
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
