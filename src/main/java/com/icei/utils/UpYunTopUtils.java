package com.icei.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import main.java.com.UpYun;

/**
 * 又拍云
 * @author 小诺诺
 *
 */
@Component
public class UpYunTopUtils {

	@Value("${ypyun.bucket_name}")
	private String bucket_name;
	@Value("${ypyun.operator_name}")
	private String operator_name;
	@Value("${ypyun.operator_pwd}")
	private String operator_pwd;
	@Value("${ypyun.temporary_url}")
	private String temporary_url;

	/**
	 * 云图片上传
	 * @param file
	 * @param filename
	 */
	public String upYunAdd(File file,String filename) {
		String urlName="";
		try {
			UpYun upyun = new UpYun(bucket_name, operator_name, operator_pwd);
			upyun.setTimeout(120);
			upyun.setContentMD5(UpYun.md5(file));
			boolean result = upyun.writeFile(filename, file, true);
			if(result) {
				urlName=filename;
				file.delete();//执行删除本地文件
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlName;
	}
	
	/**
	 * 云文件删除
	 * @param filename
	 * @return
	 */
	public boolean upYunDel(String filename) {
		UpYun upyun = new UpYun(bucket_name, operator_name, operator_pwd);
		return upyun.deleteFile(filename);
	}
	
	/**
	 * 解析文件上传云端-返回文件地址集合（常用）
	 * @param attachs
	 * @param url 云端位置(集合)
	 * @return
	 */
	public List<String> MultipartFile(MultipartFile[] attachs,String[] url) {
		List<String> imgs=new ArrayList<String>();
		try {
			String path= ResourceUtils.getURL(temporary_url).getPath();
			for (int i = 0; i < attachs.length; i++) {
				MultipartFile attach=attachs[i];
				if(!attach.isEmpty()) {
			        String fileName = attach.getOriginalFilename();//获取文件名
					String prefix=fileName.substring(fileName.lastIndexOf("."));//获取文件后缀
					String name=RandomCharData.getStringRandom(10)+prefix;//新名称
					newFile(path);//检查文件夹是否存在
					File file=new File(path, name);
					attach.transferTo(file);
					upYunAdd(file,url[i]+name);//文件上传
					imgs.add(url[i]+name);
				}
			}
			return imgs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 解析文件上传云端-返回文件地址 单个（常用）
	 * @param attach
	 * @param url 云端位置
	 * @return
	 */
	public String MultipartFile(MultipartFile attach,String url) {
		String img="";
		try {
			String path= ResourceUtils.getURL(temporary_url).getPath();
			if(!attach.isEmpty()) {
		        String fileName = attach.getOriginalFilename();//获取文件名
		        String prefix=fileName.substring(fileName.lastIndexOf("."));//获取文件后缀
				String name=RandomCharData.getStringRandom(10)+prefix;//新名称
				newFile(path);//检查文件夹是否存在
				File file=new File(path, name);
				attach.transferTo(file);
				upYunAdd(file,url+name);//文件上传
				img=url+name;
			}
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解析文件上传云端-返回文件地址集合png特殊形式
	 * @param attachs
	 * @param url 云端位置
	 * @return
	 */
	public List<String> DiyMultipartFile(MultipartFile[] attachs,String[] url) {
		List<String> imgs=new ArrayList<String>();
		try {
			String path= ResourceUtils.getURL(temporary_url).getPath();
			for (int i = 0; i < attachs.length; i++) {
				MultipartFile attach=attachs[i];
				if(!attach.isEmpty()) {
					String name=RandomCharData.getStringRandom(10)+".png";//新名称
					newFile(path);//检查文件夹是否存在
					File file=new File(path, name);
					attach.transferTo(file);
					upYunAdd(file,url[i]+name);//文件上传
					imgs.add(url[i]+name);
				}
			}
			return imgs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 创建文件夹
	 * @param strPath
	 */
	public void newFile(String strPath){
		File file = new File(strPath);
		if(!file.exists()){
			file.mkdirs();
		}
	}
}
