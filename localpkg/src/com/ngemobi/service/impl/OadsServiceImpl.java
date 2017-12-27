package com.ngemobi.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngemobi.mapper.OadsMapper;
import com.ngemobi.service.OadsService;

@Service
public class OadsServiceImpl implements OadsService {
	@Autowired
	private OadsMapper oadsMapper;
	
	@Override
	public List<String> getPkgName() {
		//��ѯ����ȫ�����
		List<String> list = oadsMapper.selectPkgName();
		//ɸѡ���ȫ�����
		List<String> pkgList = new ArrayList<>();
		for (String pkg : list) {
			try {
				//ʹ��url���ʹȸ��̵꣬ͨ��url�õ�document
				Document doc = Jsoup.connect("https://play.google.com/store/search?q="+pkg).get();
				//��ȡdocument�а���"empty-search"��ѡ����
				Elements ele=doc.getElementsByClass("empty-search");
				for (Element link : ele) {
					//����element�õ��ı�
					  String linkText = link.text();
					  Thread.sleep((int)(Math.random()*1000+1001));
					  System.out.println((int)(Math.random()*1000+1001));
					  
					  //��/]�������Ƿ�������еĹؼ���Ϣ
					  if(linkText.contains("�Ҳ����κ��c�����ь���ԃ")&&linkText.contains("����ĽY���� ���h�U Ո�_���]���e�֡� Ո�Lԇ��ͬ���P�I�֡� Ոԇ�ú��x�^�V���P�I�֡�")){
						  //System.out.println("-----"+pkg+linkText);
						  pkgList.add(pkg);
					  }
					}
			} catch (Exception e) {
				System.err.println("404����"+pkg);
				//e.printStackTrace();
				//�������ʻ���404����
				
			} 
		}
		return pkgList;
	}

	@Override
	public void addPkgName(String pkgName) {
		//���
		oadsMapper.insertPkgName(pkgName);
	}

	@Override
	public void getpkg(String googlePkg) {
		//ʹ�����̵����޷��ҵ���pkg��ȥ���ݿ��ѯ
		String rePkg = oadsMapper.selectPkgByPkg(googlePkg);
		if(rePkg==null||rePkg.equals("")){
			oadsMapper.insertPkgName(googlePkg);
		}
	
	
	}

}
