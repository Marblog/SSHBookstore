package cn.itcast.bookStore.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.bookStore.dao.NoticeDao;
import cn.itcast.bookStore.domain.Notice;

public class NoticeService {
	private NoticeDao dao;

	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}
	
	public List<Notice> getAllNotices(){
		try {
			return dao.getAllNotices();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("��ѯ���й���ʧ��!");
		}
	}
	public void addNotice(Notice notice){
		try {
			dao.addNotice(notice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ӹ���ʧ��!");
		}
	}
	public Notice findNoticeById(String n_id){
		try {
			return dao.findNoticeById(n_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("����id���ҹ���ʧ��!");
		}
	}
	public void updateNotice(Notice bean){
		try {
			dao.updateNotice(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void deleteNotice(String n_id){
		try {
			dao.deleteNotice(n_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("����idɾ������ʧ��!");
		}
		
	}
	}



